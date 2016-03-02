package dao.impl;

import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import dao.CheckBackDao;
import domain.Attend;
import domain.CheckBack;

/**
 * <p>Title: CheckBackDaoHibernate.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ1ÈÕ
 * @version  1.0
 */

public class CheckBackDaoHibernate extends YeekuHibernateDaoSupport implements CheckBackDao {

	public CheckBackDaoHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CheckBack get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CheckBack.class, id);
	}

	@Override
	public Integer save(Attend attend) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(attend);
	}

	@Override
	public void update(CheckBack checkBack) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(checkBack);

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<CheckBack> findAll() {
		// TODO Auto-generated method stub
		return (List<CheckBack>)getHibernateTemplate().find("from CheckBack");
	}

}

