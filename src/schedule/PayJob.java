package schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import service.EmpManager;

/**
 * <p>Title: PayJob.java</p>
 * <p>Description: </p>
 * @author  caizelin
 * @date 2016Äê3ÔÂ4ÈÕ
 * @version  1.0
 */

public class PayJob extends QuartzJobBean {
	private boolean isRunning = false;
	private EmpManager empMgr;

	public PayJob() {
		// TODO Auto-generated constructor stub
	}
	

	public void setEmpMgr(EmpManager empMgr) {
		this.empMgr = empMgr;
	}


	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub

		if(!isRunning)
		{
			System.out.println("Satrt to add the pay");
			isRunning = true;
			empMgr.autoPay();
			isRunning = false;
		}
	}
}

