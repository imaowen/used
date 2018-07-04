package com.imao.demo.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 定时任务
 */
@Component
public class TimingTask {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/*
	 * 上一次 启动时间点之后 X秒执行一次
	 */
//    @Scheduled(fixedRate = 3000)
//    public void scheduledFixedRate() {
//        System.out.println("fixedRate--现在时间：" + dateFormat.format(new Date()));
//    }
    
    /*
     * 上一次 结束时间点之后 每X秒执行一次
     */
//    @Scheduled(fixedDelay = 3000)
//    public void scheduledFixedDelay() {
//        System.out.println("fixedDelay--现在时间：" + dateFormat.format(new Date()));
//    }
   
    /*
     * 每隔5s执行一次
     */
//	@Scheduled(cron = "0/5 * * * * ?")
//    public void cron3s() {
//        System.out.println("cron3--现在时间：" + dateFormat.format(new Date()));
//    }
	
	/*
     * 每天3点执行一次
     */
	@Scheduled(cron = "0 0 3 * * ? ")
    public void cron3h() {
        System.out.println("cron3--现在时间：" + dateFormat.format(new Date()));
    }
}
