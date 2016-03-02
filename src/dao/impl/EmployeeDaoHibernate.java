package dao.impl;

import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import dao.EmployeeDao;
import domain.Employee;
import domain.Manager;

/**
 * <p>Title: EmployeeDaoHibernate.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ1ÈÕ
 * @version  1.0
 */

public class EmployeeDaoHibernate extends YeekuHibernateDaoSupport 
			implements EmployeeDao {

	public EmployeeDaoHibernate() {
		// TODO Auto-generated constructor stub
		}

	@Override
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Employee.class, id);
	}

	@Override
	public Integer save(Employee employee) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(employee);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(employee);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return (List<Employee>)getHibernateTemplate().find("from Employee");
	}

	@Override
	public List<Employee> findByNameAndPass(Employee employee) {
		// TODO Auto-generated method stub
		return (List<Employee>)getHibernateTemplate()
				.find("from Employee p where p.name = ? and p.pass = ? ",
						employee.getName(),employee.getPass());
	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		 List<Employee> emp = getHibernateTemplate()
				 .find("from Employee where name = ?",name);
		 if(emp != null && emp.size() >= 1)
		 {
			 return emp.get(0);
		 }
		 return null;
	}

	@Override
	public List<Employee> findByMgr(Manager manager) {
		// TODO Auto-generated method stub
		return (List<Employee>)getHibernateTemplate()
				.find("from Employee as e where e.manager = ?",manager);
	}

}

