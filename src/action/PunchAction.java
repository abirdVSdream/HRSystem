package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.interceptor.*;

import action.base.EmpBaseAction;

public class PunchAction extends EmpBaseAction
{
	//封装处理结果的punchIsValid属性
	private int PunchIsValid;

	public int getPunchIsValid() {
		return PunchIsValid;
	}

	public void setPunchIsValid(int PunchIsValid) {
		this.PunchIsValid = PunchIsValid;
	}
	
	public String excute() throws Exception
	{
		//创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//获取httpsession中的user属性
		String user = (String)ctx.getSession().get(WebConstant.USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//格式化当前时间
		String dutyDay = sdf.format(new Date());
		//调用业务逻辑方法处理用户请求
		int result = emp.validPunch(user,dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
		
	}
	
}
