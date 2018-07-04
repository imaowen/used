package com.imao.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imao.modules.dao.SysLogDao;
import com.imao.modules.entity.SysLogEntity;
import com.imao.modules.service.SysLogService;


@Service
public class SysLogServiceImpl implements SysLogService {
	
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public int save(SysLogEntity sysLog){
		return sysLogDao.save(sysLog);
	}
	
	
}
