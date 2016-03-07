package action;

import java.util.List;

import action.base.EmpBaseAction;

/**
 * <p>Title: AppChangeAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ7ÈÕ
 * @version  1.0
 */

public class AppChangeAction extends EmpBaseAction {

	public AppChangeAction() {
		// TODO Auto-generated constructor stub
	}
	private List types;
	public void setTypes(List types)
	{
		this.types = types;
	}
	public String execute() throws Exception
	{
		setTypes(emp.getAllType());
		return SUCCESS;
	}
	
	
}

