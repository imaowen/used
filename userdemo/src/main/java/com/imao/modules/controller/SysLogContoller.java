package com.imao.modules.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imao.common.annotation.SysLog;


@RestController
public class SysLogContoller {

	@SysLog("测试日志")
	@RequestMapping("/log")
	public Object log() {
		return "hello springboot~~";
	}
	
}
