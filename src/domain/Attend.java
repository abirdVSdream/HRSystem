package domain;

import java.io.Serializable;
import java.util.Date;

public class Attend implements Serializable
{
	private static final long serialVersionUID = 48L;

	//代表标识属性
	private Integer id;
	//出勤日期
	private String dutyDay;
	//打卡时间
	private Date punchTime;
	//代表本次打卡是否为上班打卡
	private boolean isCome;
	//本次出勤的类型
	private AttendType type;
	//本次出勤关联的员工
	private Employee employee;
	public Attend(){}
	public Attend(Integer id,String dutyDay,Date punchTime,boolean isCome,AttendType type,Employee employee)
	{
		this.id = id;
		this.dutyDay= dutyDay;
		this.punchTime = punchTime;
		this.isCome= isCome;
		this.type= type;
		this.employee = employee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDutyDay() {
		return dutyDay;
	}
	public void setDutyDay(String dutyDay) {
		this.dutyDay = dutyDay;
	}
	public Date getPunchTime() {
		return punchTime;
	}
	public void setPunchTime(Date punchTime) {
		this.punchTime = punchTime;
	}
	
	
	public boolean getIsCome() {
		return isCome;
	}
	public void setIsCome(boolean isCome) {
		this.isCome = isCome;
	}
	public AttendType getType() {
		return type;
	}
	public void setType(AttendType type) {
		this.type = type;
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
	public boolean equals(Object obj)
	{
		if(this ==obj)
		{
			return true;
		}
		if(obj!=null &&obj.getClass()==Attend.class)
		{
			Attend attend = (Attend) obj;
			return getEmployee().equals(attend.getEmployee())
					&& getDutyDay().equals(attend.getDutyDay())
					&& getIsCome() == attend.getIsCome();
		}
		return false;
	}
	public int hashCode()
	{
		if(getIsCome())
		{
			return dutyDay.hashCode() + 29 * employee.hashcode() +1;
		}
		return dutyDay.hashCode() + 29 * employee.hashcode();
	}
	
}
