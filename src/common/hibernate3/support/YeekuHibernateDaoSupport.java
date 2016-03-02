package common.hibernate3.support;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

/**
 * <p>Title: YeekuHibernateDaoSupport.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��2��29��
 * @version  1.0
 */

public class YeekuHibernateDaoSupport extends HibernateDaoSupport{

	public YeekuHibernateDaoSupport() {}

	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findByPage(final String hql,final int offset,final int pageSize)
	{
		List list = getHibernateTemplate().executeFind(new HibernateCallback()
				{
					public Object doInHibernate(Session session) throws HibernateException, SQLException 
					{
						List result = session.createQuery(hql)
								.setFirstResult(offset)
								.setMaxResults(pageSize).list();
						
						return result;
					}
				});
		return list;
	}
	
	
	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param value ���hql��һ��������Ҫ���룬value���Ǵ���hql���Ĳ���
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findByPage(final String hql,final Object value,final int offset,final int pageSize)
	{
		List list = getHibernateTemplate().executeFind(new HibernateCallback()
				{

					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException 
					{
						List result = session.createQuery(hql)
								.setParameter(0, value)
								.setFirstResult(offset)
								.setMaxResults(pageSize)
								.list();
						return result;
					}
				}
				);
		return list;
	}
	
	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param values ���hql�ж����������Ҫ���룬values���Ǵ���hql�Ĳ�������
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findBypage(final String hql,final Object [] values,final int offset, final int pageSize)
	{
		List list=getHibernateTemplate()
				.executeFind(new HibernateCallback()
						{

							@Override
							public Object doInHibernate(Session session) throws HibernateException, SQLException
							{
								Query query = session.createQuery(hql);
								for(int i = 0;i<values.length;i++)
								{
									query.setParameter(i, values[i]);
								}
								List result = query.setFetchSize(offset)
										.setMaxResults(pageSize).list();
								return result;
							}
					
						});
		return list;
	}
}

