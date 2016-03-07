package action;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: LogoutAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月7日
 * @version  1.0
 */

public class LogoutAction extends ActionSupport implements ServletRequestAware{
private HttpServletRequest request;

public HttpServletRequest getRequest() {
	return request;
}

public void setRequest(HttpServletRequest request) {
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

