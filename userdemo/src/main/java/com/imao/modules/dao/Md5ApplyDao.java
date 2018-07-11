package com.imao.modules.dao;

import org.apache.ibatis.annotations.Param;

import com.imao.modules.entity.Md5ApplyEntity;

public interface Md5ApplyDao extends BaseDao<Md5ApplyEntity> {

	int insBatch(@Param(value="sql")String sql);
}
