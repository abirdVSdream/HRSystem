package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import dao.AttendDao;
import domain.Attend;
import domain.AttendType;
import domain.Employee;

/**
 * <p>Title: AttendDaoHibernate.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ1ÈÕ
 * @version  1.0
 */

public class AttendDaoHibernate extends YeekuHibernateDaoSupport implements AttendDao {

	public AttendDaoHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Attend get(Integer id) {
		return getHibernateTemplate()
				.get(Attend.class , id);
	}

	@Override
	public Integer save(Attend attend) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate()
				.save(attend);
	}

	@Override
	public void Update(Attend attend) {
		// TODO Auto-generated method stub
		getHibernateTemplate()
		.update(attend);
	}

	@Override
	public void delete(Attend attend) {
		// TODO Auto-generated method stub
		getHibernateTemplate()
		.delete(attend);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate()
		.delete(get(id));
	}

	@Override
	public List<Attend> findAll() {
		// TODO Auto-generated method stub
		return (List<Attend>)getHibernateTemplate()
				.find("from Attend");
	}

	@Override
	public List<Attend> fildByEmp(Employee emp) {
		// TODO Auto-generated method stub
		return (List<Attend>)getHibernateTemplate()
				.find("from Attend as a where a.employee=?" , emp);
	}

	@Override
	public List<Attend> findByEmpAndDutyDate(Employee emp, String dutyDay) {
		// TODO Auto-generated method stub
		return (List<Attend>)getHibernateTemplate()
				.find("from Attend as a where a.employee=? and "
				+ "a.dutyDay=?" , new Object[]{emp , dutyDay});
	}

	@Override
	public Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay, boolean isCome) {
		// TODO Auto-generated method stub
		List<Attend> al = findByEmpAndDutyDate(emp , dutyDay);
		if (al != null || al.size() > 1)
		{
			for (Attend attend : al)
			{
				if (attend.getIsCome() == isCome )
				{
					return attend;
				}
			}
		}
		return null;
	}

	@Override
	public List<Attend> findByEmpUnAttend(Employee emp, AttendType type) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String end = sdf.format(c.getTime());
		c.add(Calendar.DAY_OF_MONTH, -3);
		String start = sdf.format(c.getTime());

		Object[] args = {emp , type , start , end};
		return (List<Attend>)getHibernateTemplate()
			.find("from Attend as a where a.employee=? and "
			+ "a.type != ? and a.dutyDay between ? and ?" , args);
	}
}

