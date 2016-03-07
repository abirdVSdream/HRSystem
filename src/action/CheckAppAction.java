package action;

import com.opensymphony.xwork2.ActionContext;

import action.base.MgrBaseAction;

/**
 * <p>Title: CheckAppAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月7日
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
		//创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		String mgrName = (String)ctx.getSession().get(WebConstant.USER);
		//通过申请
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
			throw new Exception("参数丢失");
		}
		setTip("处理员工申请成功");
		return SUCCESS;
	}
}

