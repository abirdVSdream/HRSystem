package action;

import action.base.EmpBaseAction;

/**
 * <p>Title: ProcessAppAction.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��7��
 * @version  1.0
 */

public class ProcessAppAction extends EmpBaseAction {

	public ProcessAppAction() {
		// TODO Auto-generated constructor stub
	}
	private int attId;
	private int typeId;
	private String reason;
	private String tip;
	
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getAttId() {
		return attId;
	}
	public void setAttId(int attId) {
		this.attId = attId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String eecute() throws Exception
	{
		boolean result = emp.addApplication(attId,typeId,reason);
		if(result)
		{
			setTip("���Ѿ�����ɹ����ȴ���������");
		}
		else
		{
			setTip("����ʧ�ܣ���ע�ⲻҪ�ظ�����");
		}
		return SUCCESS;
	}

}

