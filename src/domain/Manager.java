package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee implements Serializable
{
	private static final long serialVersionUID = 48L;
	private String dept;
	private Set<Employee> employee= new HashSet<Employee>();
	private Set<CheckBack> checks = new HashSet<CheckBack>();
	public Manager(){};
	public Manager(String dept,Set<Employee> employee,Set<CheckBack> checks)
	{
		this.dept = dept;
		this.employee = employee;
		this.checks = checks;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	public Set<CheckBack> getChecks() {
		return checks;
	}
	public void setChecks(Set<CheckBack> checks) {
		this.checks = checks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
