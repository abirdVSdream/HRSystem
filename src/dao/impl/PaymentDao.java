package dao.impl;

import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import domain.Employee;
import domain.Payment;

/**
 * <p>Title: PaymentDao.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ1ÈÕ
 * @version  1.0
 */

public class PaymentDao extends YeekuHibernateDaoSupport implements dao.PaymentDao {

	public PaymentDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Payment get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Payment.class, id);
	}

	@Override
	public Integer save(Payment payment) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(payment);
	}

	@Override
	public void update(Payment payment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(payment);
	}

	@Override
	public void delete(Payment payment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(payment);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return (List<Payment>)getHibernateTemplate().find("from payment");
	}

	@Override
	public List<Payment> findByEmp(Employee emp) {
		// TODO Auto-generated method stub
		return (List<Payment>)getHibernateTemplate()
				.find("from payment where employee = ?",emp);
	}

	@Override
	public Payment findByPayMonthAndEmp(String payMonth, Employee emp) {
		// TODO Auto-generated method stub
		List<Payment> pays = (List<Payment>)getHibernateTemplate().find("from payment as p "
				+ "where p.paymonth = ? and p.employee = ?",new  Object []{payMonth,emp});
		if(pays != null && pays.size() >= 1)
		{
			return pays.get(0);
		}
		return null;
	}

}

