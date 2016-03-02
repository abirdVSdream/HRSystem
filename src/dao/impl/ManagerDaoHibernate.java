package dao.impl;

import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import dao.ManagerDao;
import domain.Manager;

/**
 * <p>Title: ManagerDaoHibernate.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ1ÈÕ
 * @version  1.0
 */

public class ManagerDaoHibernate extends YeekuHibernateDaoSupport implements ManagerDao {

	public ManagerDaoHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Manager get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Manager.class, id);
	}

	@Override
	public String save(Manager manager) {
		// TODO Auto-generated method stub
		return (String)getHibernateTemplate().save(manager);
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(manager);
	}

	@Override
	public void delete(Manager manager) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(manager);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return (List<Manager>)getHibernateTemplate().find("from manager");
	}

	@Override
	public List<Manager> findByNameAndPass(Manager mgr) {
		// TODO Auto-generated method stub
		return getHibernateTemplate()
				.find("from manager m where m.name = ? and m.pass = ?",
						mgr.getName(),mgr.getPass());
	}

	@Override
	public Manager findByName(String name) {
		// TODO Auto-generated method stub
		List<Manager> mgr = (List<Manager>)getHibernateTemplate()
				.find("from manager where name = ?",name);
		if(mgr != null && mgr.size() >= 1)
		{
			return mgr.get(0);
		}
		return null;
	}

}

