package action.base;

import com.opensymphony.xwork2.ActionSupport;

import service.MgrManager;

/**
 * <p>Title: MgrBaseAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ4ÈÕ
 * @version  1.0
 */

public class MgrBaseAction extends ActionSupport {

	protected MgrManager mgr;
	public void setMgrManager(MgrManager mgr)
	{
		this.mgr = mgr;
	}
}

