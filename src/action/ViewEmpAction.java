package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;

/**
 * <p>Title: ViewEmpAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月8日
 * @version  1.0
 */

public class ViewEmpAction extends MgrBaseAction{
	//封装当前经理的所有员工list
	private List emps;
	
	public void setEmps(List emps)
	{
		this.emps = emps;
	}
	public List getEmps()
	{
		return this.emps;
	}
	public String execute()throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String mgrName = (String)ctx.getSession().get(WebConstant.USER);
		setEmps(mgr.getEmployeeBymgr(mgrName));
		return SUCCESS;
	}
}

