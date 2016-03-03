package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import domain.CheckBack;
import domain.Employee;
import domain.Manager;
import domain.Payment;
import exception.HrException;
import service.MgrManager;
import vo.AppBean;
import vo.EmpBean;
import vo.SalaryBean;

public class MgrManagerImpl implements MgrManager 
{
	private ApplicationDao appDao;
	private AttendDao attendDao;
	private AttendTypeDao typeDao;
	private CheckBackDao checkDao;
	private EmployeeDao empDao;
	private ManagerDao mgrDao;
	private PaymentDao payDao;
	
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
	public void addEmp(Employee emp, String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager manager = mgrDao.findByName(mgr);
		if(manager == null)
		{
			throw new HrException();
		}
		emp.setManager(manager);
		empDao.save(emp);
	}

	@Override
	public List<SalaryBean> getSalaryByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager manager = mgrDao.findByName(mgr);
		if(manager == null)
		{
			throw new HrException("不好意思。您不是经理或者您没有登录");
		}
		List<Employee> emps = empDao.findByMgr(manager);
		if(emps == null ||emps.size() < 1)
		{
			throw new HrException("你的部门没有员工");
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm");
		String payMonth = sdf.format(c.getTime());
		List<SalaryBean> result = new ArrayList<SalaryBean>();
		for (Employee e : emps)
		{
			Payment p = payDao.findByPayMonthAndEmp(payMonth, e);
			if(p != null)
			{
				result.add(new SalaryBean(e.getName(),p.getAmount()));
			}
		}
		return result;
	}

	@Override
	public List<EmpBean> getEmployeeBymgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager manager = mgrDao.findByName(mgr);
		if(manager == null)
		{
			throw new HrException("不好意思。您不是经理或者您没有登录");
		}
		List<Employee> emps = empDao.findByMgr(manager);
		if(emps == null || emps.size() < 1)
		{
			throw new HrException("你的部门下没有员工");
		}
		List<EmpBean> result = new ArrayList<EmpBean>();
		for(Employee e : emps)
		{
			result.add(new EmpBean(e.getName(),e.getPass(),e.getSalary()));
		}
		
		return result;
	}

	@Override
	public List<AppBean> getAppByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager manager = mgrDao.findByName(mgr);
		if(manager == null)
		{
			throw new HrException("不好意思，你不是经理或者您没有登陆");
		}
		List<Employee> emps = empDao.findByMgr(manager);
		if(emps == null || emps.size() < 1)
		{
			throw new HrException("你的部门下没有员工");
		}
		List<AppBean> result = new ArrayList<AppBean>();
		for(Employee e: emps)
		{
			List<Application> apps =  appDao.findByEmp(e);
			if(apps != null && apps.size() > 0)
			{
				for(Application app : apps)
				{
					if(app.getResult() == false)
					{
						Attend attend = app.getAttend();
						result.add(new AppBean(app.getId(),e.getName(),attend.getType().getName(),
									app.getType().getName(),app.getReason()));
					}
				}
			}
		}
		return result;
	}

	@Override
	public void check(int appid, String mgrName, boolean result) {
		// TODO Auto-generated method stub
		Application app = appDao.get(appid);
		CheckBack check = new CheckBack();
		check.setApplication(app);
		if(result)
		{
			//设置通过申请
			check.setResult(true);
			//修改申请为已经批复
			app.setResult(true);
			appDao.save(app);
			//修改出勤的类型
			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.save(attend);
		}else
		{
			check.setResult(false);
			app.setResult(true);
			appDao.save(app);
		}
		checkDao.save(check);
	}

}
