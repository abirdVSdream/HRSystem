package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.EmpBaseAction;
import vo.AttendBean;

/**
 * <p>Title: ViewUnAttendAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ8ÈÕ
 * @version  1.0
 */

public class ViewUnAttendAction extends EmpBaseAction{
	private List<AttendBean> unAttend;
	public void setUnAttend(List<AttendBean> unAttend)
	{
		this.unAttend = unAttend;
	}
	public List<AttendBean> getUnAttend()
	{
		return this.unAttend;
	}
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String user = (String)ctx.getSession().get(WebConstant.USER);
		List<AttendBean> result = emp.unAttend(user);
		setUnAttend(result);
		return SUCCESS;
	}
}

