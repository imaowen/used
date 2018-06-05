package com.imao.demo.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class ExcuteActivityJob  implements Job {
	
	private ThreadPoolManager pool = ThreadPoolManager.getInstance("exec_activity");

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			System.out.println("111");
			
		} catch (Exception e) {
			System.out.println("ExcuteActivityJob--execute--error--");
		}
		
	}

}
