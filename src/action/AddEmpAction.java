package action;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;
import domain.Employee;

/**
 * <p>Title: AddEmpAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月8日
 * @version  1.0
 */

public class AddEmpAction extends MgrBaseAction{

	private Employee emp;
	private String tip;
	
	public void setEmp(Employee emp)
	{
		this.emp = emp;
	}
	public Employee getEmp()
	{
		return this.emp;
	}
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String mgrName = (String)ctx.getSession().get(WebConstant.USER);
		mgr.addEmp(emp, mgrName);
		setTip("新增员工成功");
		return SUCCESS;
	}
}

