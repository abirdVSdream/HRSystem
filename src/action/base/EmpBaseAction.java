package action.base;

import com.opensymphony.xwork2.ActionSupport;

import service.EmpManager;

/**
 * <p>Title: EmpBaseAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��4��
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

