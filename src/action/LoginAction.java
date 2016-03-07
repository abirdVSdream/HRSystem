package action;
import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletRequest;

import domain.Manager;
import action.base.EmpBaseAction;


public class LoginAction extends EmpBaseAction
{
	//����һ��������ΪԱ����¼�ɹ���Result��
	private final String EMP_RESULT = "emp";
	//����һ��������Ϊ������¼�ɹ���result��
	private final String MGR_RESULT = "mgr";
	//��װ�������
	private Manager manager;
	//��¼����֤��
	private String vercode;
	//�����¼�����ʾ��Ϣ
	private String tip;
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	//�����û�����
	public String execute() throws Exception
	{
		//����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		//��ȡHTTPSession�е�rand����
		String ver2 = (String)ctx.getSession().get("rand");
		if(vercode.equalsIgnoreCase(ver2))
		{
			//����ҵ���߼������������¼����
			int result = emp.validLogin(getManager());
			//��¼���Ϊ��ͨԱ��
			if(result == LOGIN_EMP)
			{
				ctx.getSession().put(WebConstant.USER,manager.getName());
				ctx.getSession().put(WebConstant.LEVEL,WebConstant.EMP_LEVEL);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return EMP_RESULT;
			}
			//��¼���Ϊ����
			else if(result == LOGIN_MGR)
			{
				ctx.getSession().put(WebConstant.USER,manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.MGL_LEVEL);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return MGR_RESULT;
			}
			else
			{
				setTip("�û���/���벻ƥ��");
				return ERROR;
			}
		}
		else
		{
			setTip("��֤�벻ƥ�䣬����������");
			return ERROR;
		}
	}
}
