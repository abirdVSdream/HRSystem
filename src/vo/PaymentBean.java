package vo;

import java.io.Serializable;

/**
 * <p>Title: PaymentBean.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月1日
 * @version  1.0
 */

public class PaymentBean implements Serializable {
	private static final long serialVersionUID = 48L;
	private String payMonth;
	private double amount;

	//无参数的构造器
	public PaymentBean()
	{
	}
	//初始化全部属性的构造器
	public PaymentBean(String payMonth , double amount)
	{
		this.payMonth = payMonth;
		this.amount = amount;
	}

	//payMonth属性的setter和getter方法
	public void setPayMonth(String payMonth)
	{
		this.payMonth = payMonth;
	}
	public String getPayMonth()
	{
		return this.payMonth;
	}

	//amount属性的setter和getter方法
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public double getAmount()
	{
		return this.amount;
	}

}

