package domain;

public class AttendType 
{
	private static final long serialVersionUID = 48L;
	private Integer id;
	private String name;
	private double acerce;
	
	public AttendType(){}
	public AttendType(Integer id,String name,double acerce)
	{
		this.id = id;
		this.name = name;
		this.acerce = acerce;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAcerce() {
		return acerce;
	}
	public void setAcerce(double acerce) {
		this.acerce = acerce;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
