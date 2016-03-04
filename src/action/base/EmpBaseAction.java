package action.base;

import com.opensymphony.xwork2.ActionSupport;

import service.EmpManager;

/**
 * <p>Title: EmpBaseAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ4ÈÕ
 * @version  1.0
 */

public class EmpBaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
protected EmpManager emp;
public void setEmpManager(EmpManager emp)
{
	this.emp = emp;
}

}

