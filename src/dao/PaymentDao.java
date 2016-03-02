package dao;

import java.util.List;

import domain.Employee;
import domain.Payment;

/**
 * <p>Title: PaymentDao.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��2��29��
 * @version  1.0
 */

public interface PaymentDao {
	/**
	 * ���ݱ�ʶ����������Paymentʵ��
	 * @param id ��Ҫ���ص�Paymentʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Paymentʵ��
	 */
	Payment get(Integer id);

	/**
	 * �־û�ָ����Paymentʵ��
	 * @param payment ��Ҫ���־û���Paymentʵ��
	 * @return Paymentʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(Payment payment);

	/**
	 * �޸�ָ����Paymentʵ��
	 * @param payment ��Ҫ���޸ĵ�Paymentʵ��
	 */
	void update(Payment payment);

	/**
	 * ɾ��ָ����Paymentʵ��
	 * @param payment ��Ҫ��ɾ����Paymentʵ��
	 */
	void delete(Payment payment);

	/**
	 * ���ݱ�ʶ����ɾ��Paymentʵ��
	 * @param id ��Ҫ��ɾ����Paymentʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	/**
	 * ��ѯȫ����Paymentʵ��
	 * @return ���ݿ���ȫ����Paymentʵ��
	 */
	List<Payment> findAll();
	
	/**
	 * ����Ա����ѯ�½�нˮ
	 * @return ��Ա����Ӧ���½�нˮ����
	 */ 
	List<Payment> findByEmp(Employee emp);
	
	/**
	 * ����Ա���ͷ�н�·�����ѯ�½�нˮ
	 * @param payMonth ��н�·�
	 * @param emp ��н��Ա��
	 * @return ָ��Ա����ָ���·ݵ��½�нˮ
	 */ 
	Payment findByPayMonthAndEmp(String payMonth,Employee emp);

}

