package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;
import vo.SalaryBean;

/**
 * <p>Title: ViewDeptAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ7ÈÕ
 * @version  1.0
 */

public class ViewDeptAction extends MgrBaseAction {

	private List sals;
	public void setSals(List sals)
	{
		this.sals = sals;
	}
	public List getSals()
	{
		return this.sals;
	}
	public String excute() throws Exception
	{
		ActionContext ctx =ActionContext.getContext();
		String mgrName = (String)ctx.getSession().get(WebConstant.USER);
		List<SalaryBean> result = mgr.getSalaryByMgr(mgrName);
		System.out.println("-----------"+result);
		return SUCCESS;
	}
}

