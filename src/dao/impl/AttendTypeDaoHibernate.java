package dao.impl;

import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import dao.AttendTypeDao;
import domain.Attend;
import domain.AttendType;

/**
 * <p>Title: AttendTypeDaoHibernate.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ1ÈÕ
 * @version  1.0
 */

public class AttendTypeDaoHibernate extends YeekuHibernateDaoSupport implements AttendTypeDao {

	public AttendTypeDaoHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AttendType get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(AttendType.class, id);
	}

	@Override
	public Integer save(AttendType attendType) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(attendType);
	}

	@Override
	public void update(AttendType attendType) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(attendType);
	}

	@Override
	public void delete(AttendType attendType) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(attendType);
	}

	@Override
	public void deldete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<AttendType> findAll() {
		// TODO Auto-generated method stub
		return (List<AttendType>)getHibernateTemplate().find("from AttendType");
	}

}

