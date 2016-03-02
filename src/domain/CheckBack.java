package domain;

import java.io.Serializable;

public class CheckBack implements Serializable{
	
	public static final long serialVersionUID = 48L;
	private Integer id;
	private Manager manager;
	private boolean result;
	private String reason;
	private Application app;
	
	public CheckBack() {}
	public CheckBack(Integer id,Manager manager,boolean result,String reason,Application app)
	{
		this.id = id;
		this.manager = manager;
		this.result = result;
		this.reason = reason;
		this.app = app;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Application getApplication() {
		return app;
	}
	public void setApplication(Application application) {
		this.app = application;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
