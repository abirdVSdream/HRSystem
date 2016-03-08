package action.authority;

import com.opensymphony.xwork2.*;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import action.WebConstant;

/**
 * <p>Title: EmpAuthorityInterceptor.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ7ÈÕ
 * @version  1.0
 */

public class EmpAuthorityInterceptor extends AbstractInterceptor {

	public EmpAuthorityInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		String level = (String)ctx.getSession().get(WebConstant.EMP_LEVEL);
		if(level != null && (level.equals(WebConstant.EMP_LEVEL)||level.equals(WebConstant.EMP_LEVEL)))
		{
			return invocation.invoke();
		}
		else
		{
			return Action.LOGIN;
		}
	}
}

