package action;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;

/**
 * <p>Title: CheckAppAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��7��
 * @version  1.0
 */

public class CheckAppAction extends MgrBaseAction{

	private int appid;
	private String result;
	private String tip;
	public void setAppid(int appid)
	{
		this.appid = appid;
	}
	public int getAppid()
	{
		return this.appid;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public String getResult()
	{
		return this.result;
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
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		String mgrName = (String)ctx.getSession().get(WebConstant.USER);
		//ͨ������
		if(result.equals("pass"))
		{
			mgr.check(appid, mgrName, false);
		}
		else if(result.equals("deny"))
		{
			mgr.check(appid, mgrName, false);
		}
		else
		{
			throw new Exception("������ʧ");
		}
		setTip("����Ա������ɹ�");
		return SUCCESS;
	}
}

