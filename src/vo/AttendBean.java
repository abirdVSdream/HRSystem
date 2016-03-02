package vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: AttendBean.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016��3��1��
 * @version  1.0
 */

public class AttendBean implements Serializable {

	private static final long serialVersionUID = 48L;
	private int id;
	private String dutyDay;
	private String unType;
	private Date time;
	
	public AttendBean() {
		// TODO Auto-generated constructor stub
	}

	//��ʼ��ȫ�����ԵĹ�����
		public AttendBean(int id , String dutyDay 
			, String unType , Date time)
		{
			this.id = id;
			this.dutyDay = dutyDay;
			this.unType = unType;
			this.time = time;
		}

		//id���Ե�setter��getter����
		public void setId(int id)
		{
			this.id = id;
		}
		public int getId()
		{
			return this.id;
		}

		//dutyDay���Ե�setter��getter����
		public void setDutyDay(String dutyDay)
		{
			this.dutyDay = dutyDay;
		}
		public String getDutyDay()
		{
			return this.dutyDay;
		}

		//unType���Ե�setter��getter����
		public void setUnType(String unType)
		{
			this.unType = unType;
		}
		public String getUnType()
		{
			return this.unType;
		}

		//time���Ե�setter��getter����
		public void setTime(Date time)
		{
			this.time = time;
		}
		public Date getTime()
		{
			return this.time;
		}
}

