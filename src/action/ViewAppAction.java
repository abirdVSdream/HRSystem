package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;

/**
 * <p>Title: ViewAppAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��7��
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
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡhttpsession�е�����
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		//��ȡ��Ҫ����ǰ�������ȫ������
		setApps(mgr.getAppByMgr(mgrName));
		return SUCCESS;
	}
	
	
}

