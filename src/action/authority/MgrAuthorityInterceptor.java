package action.authority;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import action.WebConstant;

/**
 * <p>Title: MgrAuthorityInterceptor.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ7ÈÕ
 * @version  1.0
 */

public class MgrAuthorityInterceptor extends AbstractInterceptor {

	public MgrAuthorityInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		String level = (String)ctx.getSession().get(WebConstant.LEVEL);
		if(level != null && level.equals(WebConstant.MGR_LEVEL))
		{
			return invocation.invock();
		}
		else
		{
			return Action.LOGIN;
		}
	}
}

