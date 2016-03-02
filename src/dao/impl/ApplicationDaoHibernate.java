package dao.impl;

import java.util.List;

import common.hibernate3.support.YeekuHibernateDaoSupport;
import dao.ApplicationDao;
import domain.Application;
import domain.Employee;

/**
 * <p>Title: ApplicationDaoHibernate.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��2��29��
 * @version  1.0
 */

public class ApplicationDaoHibernate extends YeekuHibernateDaoSupport implements ApplicationDao{

	public ApplicationDaoHibernate() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * ���ݱ�ʶ����������Applicationʵ��
	 * @param id ��Ҫ���ص�Applicationʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Applicationʵ��
	 */
	public Application get(Integer id) {
		return getHibernateTemplate().get(Application.class, id);
	}
	
	/**
	 * �־û�ָ����Applicationʵ��
	 * @param application ��Ҫ���־û���Applicationʵ��
	 * @return Applicationʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Application application)
	{
		return (Integer)getHibernateTemplate().save(application);
	}
	
	/**
	 * �޸�ָ����Applicationʵ��
	 * @param application ��Ҫ���޸ĵ�Applicationʵ��
	 */
	public void update(Application application)
	{
		getHibernateTemplate().update(application);
	}
	
	/**
	 * ɾ��ָ����Applicationʵ��
	 * @param application ��Ҫ��ɾ����Applicationʵ��
	 */
	public void deldete(Application application)
	{
		getHibernateTemplate().delete(application);
	}
	
	/**
	 * ���ݱ�ʶ����ɾ��Applicationʵ��
	 * @param id ��Ҫ��ɾ����Applicationʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	

	/**
	 * ��ѯȫ����Applicationʵ��
	 * @return ���ݿ���ȫ����Applicationʵ��
	 */
	public List<Application> findAll()
	{
		return(List<Application>)getHibernateTemplate().find("from Application");
	}
	
	/**
	 * ����Ա����ѯδ������춯����
	 * @param emp ��Ҫ��ѯ��Ա��
	 * @return ��Ա����Ӧ��δ������춯����
	 */ 
	public List<Application> findByEmp(Employee emp)
	{
		return(List<Application>)getHibernateTemplate().find("from Application as a where"
				+"a.attend.employee=?",emp);
	}
}

