package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.ApplicationDao;
import dao.AttendDao;
import dao.AttendTypeDao;
import dao.CheckBackDao;
import dao.EmployeeDao;
import dao.ManagerDao;
import dao.PaymentDao;
import domain.Application;
import domain.Attend;
import domain.AttendType;
import domain.Employee;
import domain.Manager;
import domain.Payment;
import service.EmpManager;
import vo.AttendBean;
import vo.PaymentBean;

/**
 * <p>
 * Title: EmployeImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author caizelin
 * @date 2016年3月3日
 * @version 1.0
 */

public class EmpManagerImpl implements EmpManager {

	private ApplicationDao appDao;
	private AttendDao attendDao;
	private AttendTypeDao typeDao;
	private CheckBackDao checkDao;
	private EmployeeDao empDao;
	private ManagerDao mgrDao;
	private PaymentDao payDao;

	public EmpManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setAppDao(ApplicationDao appDao) {
		this.appDao = appDao;
	}

	public void setAttendDao(AttendDao attendDao) {
		this.attendDao = attendDao;
	}

	public void setTypeDao(AttendTypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public void setCheckDao(CheckBackDao checkDao) {
		this.checkDao = checkDao;
	}

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public void setMgrDao(ManagerDao mgrDao) {
		this.mgrDao = mgrDao;
	}

	public void setPayDao(PaymentDao payDao) {
		this.payDao = payDao;
	}

	@Override
	public int validLogin(Manager mgr) {
		// TODO Auto-generated method stub
		if (mgrDao.findByNameAndPass(mgr).size() >= 1) {
			return LOGIN_MGR;
		} else if (empDao.findByNameAndPass(mgr).size() >= 1) {
			return LOGIN_EMP;
		} else {
			return LOGIN_FAIL;
		}
	}

	@Override
	public void autoPunch() {
		// TODO Auto-generated method stub
		System.out.println("自动插入旷工记录");
		List<Employee> emps = empDao.findAll();
		// 获取当前时间
		String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
		for (Employee e : emps) {
			// 获取旷工对应的出勤类型
			AttendType atype = typeDao.get(6);
			Attend att = new Attend();
			att.setDutyDay(dutyDay);
			att.setType(atype);
			// 如果当前时间是早上，对应于上班打卡
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT) {
				att.setIsCome(true);
			} else {
				// 下班打卡
				att.setIsCome(false);
			}
			att.setEmployee(e);
			attendDao.save(att);
		}
	}

	@Override
	public void autoPay() {
		// TODO Auto-generated method stub
		System.out.println("auto pay");
		List<Employee> emps = empDao.findAll();
		// get last Month
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm");
		String payMonth = sdf.format(c.getTime());
		// calculate the pay of each employee last month
		for (Employee e : emps) {
			Payment pay = new Payment();
			// get the salary of this employee
			double amount = e.getSalary();
			// get the last-month-attend of this employee
			List<Attend> attends = attendDao.fildByEmp(e);
			// add attend-pay from salary
			for (Attend att : attends) {
				amount += att.getType().getAcerce();
			}
			// add amount
			pay.setpayMonth(payMonth);
			pay.setEmployee(e);
			pay.setAmount(amount);
			payDao.save(pay);
		}

	}

	@Override
	public int validPunch(String user, String dutyDay) {
		// if the user is not find ,return can't punch
		Employee emp = empDao.findByName(user);
		if (emp == null) {
			return NO_PUNCH;
		}
		// find the attends for this employee at today
		List<Attend> attends = attendDao.findByEmpAndDutyDate(emp, dutyDay);
		// if System isn't input the empty record,unable punch
		if (attends == null || attends.size() <= 0) {
			return NO_PUNCH;
		}
		// punch
		else if (attends.size() == 1 && attends.get(0).getIsCome() && attends.get(0).getPunchTime() == null) {
			return COME_PUNCH;
		} else if (attends.size() == 1 && attends.get(0).getPunchTime() == null) {
			return LEAVE_PUNCH;
		} else if (attends.size() == 2) {
			// can punch at working and go off work
			if (attends.get(0).getPunchTime() == null && attends.get(1).getPunchTime() == null) {
				return BOTH_PUNCH;
			}
			// only can punch at go off work
			else if (attends.get(1).getPunchTime() == null) {
				return LEAVE_PUNCH;
			} else {
				return NO_PUNCH;
			}
		}
		return NO_PUNCH;
	}

	@Override
	public int punch(String user, String dutyDay, boolean isCome) {
		Employee emp = empDao.findByName(user);
		if (emp == null) {
			return PUNCH_FAIL;
		}
		// find employee punch-attends on this time
		Attend attend = attendDao.findByEmpAndDutyDayAndCome(emp, dutyDay, isCome);
		if (attend == null) {
			return PUNCH_FAIL;
		}
		// have punch
		if (attend.getPunchTime() != null) {
			return PUNCHED;
		}
		System.out.println("======punch======");
		// get punch time
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		attend.setPunchTime(new Date());
		// punch for go to work
		if (isCome) {
			// before 9:00 is normal
			if (punchHour < COME_LIMIT) {
				attend.setType(typeDao.get(1));
			}
			// 9-11 is late
			else if (punchHour < LATE_LIMIT) {
				attend.setType(typeDao.get(4));
			}
		}
		// punch for go off work
		else {
			// after 18:00 is normal
			if (punchHour > LEAVE_LIMIT) {
				attend.setType(typeDao.get(1));
			}
			// between 16 and 18 is early-leave
			else if (punchHour < EARLY_LIMIT) {
				attend.setType(typeDao.get(5));
			}
		}
		attendDao.Update(attend);
		return PUNCH_SUCC;
	}

	@Override
	public List<PaymentBean> empSalary(String empName) {
		// get employee
		Employee emp = empDao.findByName(empName);
		// get the pays for this employee
		List<Payment> pays = payDao.findByEmp(emp);
		List<PaymentBean> result = new ArrayList<PaymentBean>();
		// package vo collection
		for (Payment p : pays) {
			result.add(new PaymentBean(p.getpayMonth(), p.getAmount()));
		}
		return result;
	}

	@Override
	public List<AttendBean> unAttend(String empName) {
		// get normal working
		AttendType type = typeDao.get(1);
		Employee emp = empDao.findByName(empName);
		// find unattend
		List<Attend> attends = attendDao.findByEmpUnAttend(emp, type);
		List<AttendBean> result = new ArrayList<AttendBean>();
		// package vo collection
		for (Attend att : attends) {
			result.add(new AttendBean(att.getId(), att.getDutyDay(), att.getType().getName(), att.getPunchTime()));
		}
		return result;
	}

	@Override
	public List<AttendType> getAllType() {
		return typeDao.findAll();
	}

	@Override
	public boolean addApplication(int attId, int typeId, String reason) {
		Application app = new Application();
		Attend att = attendDao.get(attId);
		AttendType type = typeDao.get(typeId);
		app.setAttend(att);
		app.setType(type);
		if (reason != null) {
			app.setReason(reason);
		}
		appDao.save(app);
		return true;
	}

}
