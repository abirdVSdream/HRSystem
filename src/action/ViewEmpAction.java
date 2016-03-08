package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;

/**
 * <p>Title: ViewEmpAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��8��
 * @version  1.0
 */

public class ViewEmpAction extends MgrBaseAction{
	//��װ��ǰ���������Ա��list
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

