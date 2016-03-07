package action;
import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletRequest;

import domain.Manager;
import action.base.EmpBaseAction;


public class LoginAction extends EmpBaseAction
{
	//定义一个常量作为员工登录成功的Result名
	private final String EMP_RESULT = "emp";
	//定义一个常量作为经历登录成功的result名
	private final String MGR_RESULT = "mgr";
	//封装请求参数
	private Manager manager;
	//登录的验证码
	private String vercode;
	//处理登录后的提示信息
	private String tip;
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	//处理用户请求
	public String execute() throws Exception
	{
		//创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//获取HTTPSession中的rand属性
		String ver2 = (String)ctx.getSession().get("rand");
		if(vercode.equalsIgnoreCase(ver2))
		{
			//调用业务逻辑方法来处理登录请求
			int result = emp.validLogin(getManager());
			//登录结果为普通员工
			if(result == LOGIN_EMP)
			{
				ctx.getSession().put(WebConstant.USER,manager.getName());
				ctx.getSession().put(WebConstant.LEVEL,WebConstant.EMP_LEVEL);
				setTip("您已经成功登录系统");
				return EMP_RESULT;
			}
			//登录结果为经理
			else if(result == LOGIN_MGR)
			{
				ctx.getSession().put(WebConstant.USER,manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.MGL_LEVEL);
				setTip("您已经成功登录系统");
				return MGR_RESULT;
			}
			else
			{
				setTip("用户名/密码不匹配");
				return ERROR;
			}
		}
		else
		{
			setTip("验证码不匹配，请重新输入");
			return ERROR;
		}
	}
}
