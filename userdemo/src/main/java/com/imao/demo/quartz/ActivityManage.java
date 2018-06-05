package com.imao.demo.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;


/**
 * 
 * @author lmw
 *  跟进提醒 启动 入口  每天 执行一次
 */
public class ActivityManage {
	public final static String JOBNAME_PREFIX = "job_activity1";
	public final static String GROUPNAME_PREFIX = "group_activity1";
	
	public final static String TRIGGERNAME_PREFIX = "trigger_activity1";
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		try
		{
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(TRIGGERNAME_PREFIX , GROUPNAME_PREFIX);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			//每多久  执行一次
			String exp = "0/5 * * * * ?";
			if (!CronExpression.isValidExpression(exp))
			{
				System.out.println("定时格式不对...");
				return;
			}
			System.out.println("执行中....");
			//TestJob2
			JobDetail jobDetail = JobBuilder.newJob(ExcuteActivityJob.class).withIdentity(JOBNAME_PREFIX, GROUPNAME_PREFIX).build();
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(exp);
			// 按新的表达式构建一个新的trigger
			trigger = TriggerBuilder.newTrigger().withIdentity(TRIGGERNAME_PREFIX, GROUPNAME_PREFIX )
					.withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(jobDetail, trigger);
			//启动
			scheduler.start();
		}catch (Exception e){
			System.out.println(sdf.format(new Date())+"--ActivityManage--");
		}
	}
}
