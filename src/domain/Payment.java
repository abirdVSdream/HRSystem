package domain;

public class Payment {

	private static final long serialVersionUID = 48L;
	private Integer id;
	private String payMonth;
	private double accoum;
	private Manager manager;
	public Payment() {}
	public Payment(Integer id,String payMonth,double accoum,Manager manager)
	{
		this.id = id;
		this.payMonth= payMonth;
		this.accoum= accoum;
		this.manager = manager;
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
	public double getAccoum() {
		return accoum;
	}
	public void setAccoum(double accoum) {
		this.accoum = accoum;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
