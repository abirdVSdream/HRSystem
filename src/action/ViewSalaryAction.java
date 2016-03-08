package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.EmpBaseAction;
import vo.PaymentBean;

/**
 * <p>Title: ViewSalaryAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ8ÈÕ
 * @version  1.0
 */

public class ViewSalaryAction extends EmpBaseAction {

	private List salarys;
	
	public void setSalarys(List salarys)
	{
		this.salarys = salarys;
	}
	public List getSalarys()
	{
		return this.salarys;
	}
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String user = (String)ctx.getSession().get(WebConstant.USER);
		List<PaymentBean> salarys = emp.empSalary(user);
		setSalarys(salarys);
		return SUCCESS;
				
	}
}

