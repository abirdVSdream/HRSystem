package vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: AttendBean.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016年3月1日
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

	//初始化全部属性的构造器
		public AttendBean(int id , String dutyDay 
			, String unType , Date time)
		{
			this.id = id;
			this.dutyDay = dutyDay;
			this.unType = unType;
			this.time = time;
		}

		//id属性的setter和getter方法
		public void setId(int id)
		{
			this.id = id;
		}
		public int getId()
		{
			return this.id;
		}

		//dutyDay属性的setter和getter方法
		public void setDutyDay(String dutyDay)
		{
			this.dutyDay = dutyDay;
		}
		public String getDutyDay()
		{
			return this.dutyDay;
		}

		//unType属性的setter和getter方法
		public void setUnType(String unType)
		{
			this.unType = unType;
		}
		public String getUnType()
		{
			return this.unType;
		}

		//time属性的setter和getter方法
		public void setTime(Date time)
		{
			this.time = time;
		}
		public Date getTime()
		{
			return this.time;
		}
}

