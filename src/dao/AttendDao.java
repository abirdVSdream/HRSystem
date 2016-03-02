package dao;

import java.util.List;

import domain.Attend;
import domain.AttendType;
import domain.Employee;

public interface AttendDao 
{
	/**
	 * ���ݱ�ʶ����������Attendʵ��
	 * @param id ��Ҫ���ص�Attendʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Attendʵ��
	 */
	Attend get(Integer id);
	
	/**
	 * �־û�ָ����Attendʵ��
	 * @param attend ��Ҫ���־û���Attendʵ��
	 * @return Attendʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(Attend attend);
	
	/**
	 * �޸�ָ����Attendʵ��
	 * @param attend ��Ҫ���޸ĵ�Attendʵ��
	 */
	void Update(Attend attend);
	
	/**
	 * ɾ��ָ����Attendʵ��
	 * @param attend ��Ҫ��ɾ����Attendʵ��
	 */
	void delete(Attend attend);
	
	/**
	 * ���ݱ�ʶ����ɾ��Attendʵ��
	 * @param id ��Ҫ��ɾ����Attendʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);
	
	/**
	 * ��ѯȫ����Attendʵ��
	 * @return ���ݿ���ȫ����Attendʵ��
	 */
	List<Attend> findAll();
	
	/**
	 * ����Ա����ѯ��Ա���Ĵ򿨼�¼
	 * @param emp Ա��
	 * @return ��Ա����ȫ�����ڼ�¼
	 */ 
	List<Attend> fildByEmp(Employee emp);
	
	/**
	 * ����Ա�������ڲ�ѯ��Ա���Ĵ򿨼�¼����
	 * @param emp Ա��
	 * @param dutyDay  ����
	 * @return ��Ա����ĳ��Ĵ򿨼�¼����
	 */
	 List<Attend> findByEmpAndDutyDate(Employee emp,String dutyDay);
	 
	/**
	 * ����Ա�������� �����°��ѯ��Ա���Ĵ򿨼�¼����
	 * @param emp Ա��
	 * @param dutyDay  ����
	 * @param isCome �Ƿ��ϰ�
	 * @return ��Ա����ĳ���ϰ���°�Ĵ򿨼�¼
	 */
	 Attend findByEmpAndDutyDayAndCome(Employee emp , 
				String dutyDay , boolean isCome);
	 
	/**
	 * �鿴Ա��ǰ����ķ�������
	 * @param emp Ա��
	 * @return ��Ա����ǰ����ķ�������
	 */

	 List<Attend> findByEmpUnAttend(Employee emp, AttendType type);
}
