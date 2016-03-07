package action;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: LogoutAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��7��
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
	//��ȡhttpSession
	HttpSession session = request.getSession();
	//ʹsessionʧЧ
	session.invalidate();
	return SUCCESS;
}

}

