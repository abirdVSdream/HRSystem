package domain;

import domain.Employee;

public class Payment {

	private static final long serialVersionUID = 48L;
	private Integer id;
	private String payMonth;
	private double amount;
	private Employee employee;
	public Payment() {}
	public Payment(Integer id,String payMonth,double amount,Manager manager, Employee employee)
	{
		this.id = id;
		this.payMonth= payMonth;
		this.amount= amount;
		this.employee = employee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getpayMonth() {
		return payMonth;
	}
	public void setpayMonth(String payMonth) {
		this.payMonth = payMonth;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
