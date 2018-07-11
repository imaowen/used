package com.imao.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imao.modules.service.impl.Md5ApplyServiceImpl;

/*
 * md5处理
 */
@RestController
@RequestMapping("/md5")
public class Md5ApplyController {
	
	@Autowired
	private Md5ApplyServiceImpl md5ApplyService;
	
	@RequestMapping("/mk/{len}")
	public Object mk(@PathVariable("len") int len) {
		switch (len) {
		case 1:
			md5ApplyService.mk();
			break;
		case 2:
			md5ApplyService.mk2();
			break;
		case 3:
			md5ApplyService.mk3();
			break;
		case 4:
			md5ApplyService.mk4();
			break;
		case 5:
			md5ApplyService.mk5();
			break;
		}
		return len+"长度正在生成MD5";
	}
}
