package action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: LogoutAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月7日
 * @version  1.0
 */

public class LogoutAction extends ActionSupport implements ServletRequestAware{
private HttpServletRequestAware request;

public HttpServletRequestAware getRequest() {
	return request;
}

public void setRequest(HttpServletRequestAware request) {
	this.request = request;
}
public String execute() throws Exception
{
	//获取httpSession
	HttpSession session = request.getSession();
	//使session失效
	session.invalidate();
	return SUCCESS;
}

}

