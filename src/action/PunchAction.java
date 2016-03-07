package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.interceptor.*;

import action.base.EmpBaseAction;

public class PunchAction extends EmpBaseAction
{
	//��װ��������punchIsValid����
	private int PunchIsValid;

	public int getPunchIsValid() {
		return PunchIsValid;
	}

	public void setPunchIsValid(int PunchIsValid) {
		this.PunchIsValid = PunchIsValid;
	}
	
	public String excute() throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡhttpsession�е�user����
		String user = (String)ctx.getSession().get(WebConstant.USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//��ʽ����ǰʱ��
		String dutyDay = sdf.format(new Date());
		//����ҵ���߼����������û�����
		int result = emp.validPunch(user,dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
		
	}
	
}
