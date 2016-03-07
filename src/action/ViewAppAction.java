package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;

/**
 * <p>Title: ViewAppAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月7日
 * @version  1.0
 */

public class ViewAppAction extends MgrBaseAction {

	private List apps;
	public ViewAppAction() {
		// TODO Auto-generated constructor stub
	}
	public List getApps() {
		return apps;
	}
	public void setApps(List apps) {
		this.apps = apps;
	}

	public String execute() throws Exception
	{
		//创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//获取httpsession中的属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		//获取需要被当前经理处理的全部申请
		setApps(mgr.getAppByMgr(mgrName));
		return SUCCESS;
	}
	
	
}

