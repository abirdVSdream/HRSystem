package schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import domain.Employee;
import service.EmpManager;

/**
 * <p>Title: PunchJob.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ4ÈÕ
 * @version  1.0
 */

public class PunchJob extends QuartzJobBean {

	private boolean isRunning = false;
	private EmpManager empMgr;
	public PunchJob() {
		// TODO Auto-generated constructor stub
	}
	

	public void setEmpMgr(EmpManager empMgr) {
		this.empMgr = empMgr;
	}


	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		if(!isRunning)
		{
			System.out.println("Start to punch");
			isRunning = true;
			empMgr.autoPunch();
			isRunning = false;
		}
	}
}

