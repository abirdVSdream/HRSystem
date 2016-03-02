package vo;

import java.io.Serializable;

/**
 * <p>Title: SalaryBean.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��1��
 * @version  1.0
 */

public class SalaryBean implements Serializable {

	private static final long serialVersionUID = 48L;
	private String empName;
	private double amount;

	//�޲����Ĺ�����
	public SalaryBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public SalaryBean(String empName , double amount)
	{
		this.empName = empName;
		this.amount = amount;
	}

	//empName���Ե�setter��getter����
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getEmpName()
	{
		return this.empName;
	}

	//amount���Ե�setter��getter����
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public double getAmount()
	{
		return this.amount;
	}
}

