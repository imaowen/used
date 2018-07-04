package com.imao.modules.dao;

import org.apache.ibatis.annotations.Mapper;

import com.imao.modules.entity.SysLogEntity;

/**
 * 系统日志
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
