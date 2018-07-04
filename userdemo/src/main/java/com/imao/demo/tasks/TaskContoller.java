package com.imao.demo.tasks;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/task")
public class TaskContoller {

	@Autowired
	private AsyncTask asyncTask;
	/**
	 * 等待异步任务完成再下一步
	 */
	@RequestMapping("/asyn")
	public Object asyn() throws Exception {
    	long start = System.currentTimeMillis();
    	
    	Future<Boolean> a = asyncTask.doTask11();
    	Future<Boolean> b = asyncTask.doTask22();
    	Future<Boolean> c = asyncTask.doTask33();
    	
    	while (!a.isDone() || !b.isDone() || !c.isDone()) {
    		if (a.isDone() && b.isDone() && c.isDone()) {
    			break;
    		}
    	}
    	
    	long end = System.currentTimeMillis();
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
	}
	/**
	 * 调用异步任务后
	 * 直接执行下一步
	 */
	@RequestMapping("/asyn2")
	public Object asyn2() throws Exception {
    	long start = System.currentTimeMillis();
    	
    	Future<Boolean> a = asyncTask.doTask11();
    	Future<Boolean> b = asyncTask.doTask22();
    	Future<Boolean> c = asyncTask.doTask33();
    	
    	long end = System.currentTimeMillis();
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
	}
	
}
