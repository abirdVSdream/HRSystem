package service.impl;

import java.util.Calendar;
import java.util.List;

import dao.ApplicationDao;
import dao.AttendDao;
import dao.AttendTypeDao;
import dao.CheckBackDao;
import dao.EmployeeDao;
import dao.ManagerDao;
import dao.PaymentDao;
import domain.Employee;
import domain.Manager;
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
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		return null;
	}

	@Override
	public List<EmpBean> getEmployeeBymgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppBean> getAppByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void check(int appid, String mgrName, boolean result) {
		// TODO Auto-generated method stub

	}

}
