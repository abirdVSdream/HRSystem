package action;

import service.EmpManager;
import static service.EmpManager.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessPunchAction extends ActionSupport
{
	private EmpManager empMgr;
	private String tip;
	public EmpManager getEmpMgr() {
		return empMgr;
	}
	public void setEmpMgr(EmpManager empMgr) {
		this.empMgr = empMgr;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String come() throws Exception
	{
		return process(true);
	}
	public String leave() throws Exception
	{
		return process(false);
	}
	private String process(boolean isCome)throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String user = (String)ctx.getSession().get(WebConstant.USER);
		System.out.print("----��----"+user);
		String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
		int result = empMgr.punch(user, dutyDay, isCome);
		switch(result)
		{
			case PUNCH_FAIL:
				setTip("��ʧ��");
				break;
			case PUNCHED:
				setTip("���Ѿ�������ˣ���Ҫ�ظ���");
				break;
			case PUNCH_SUCC:
				setTip("�򿨳ɹ�");
				break;
		}
		return SUCCESS;
	}
}
