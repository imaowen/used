package com.imao.modules.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.imao.common.utils.Constant;
import com.imao.common.utils.Md5Util;
import com.imao.modules.dao.Md5ApplyDao;
import com.imao.modules.entity.Md5ApplyEntity;

@Service
public class Md5ApplyServiceImpl{
	private Logger logger = LoggerFactory.getLogger(Md5ApplyServiceImpl.class);
	@Autowired
	private Md5ApplyDao md5ApplyDao;

	@Async
	public void mk() {
		String[] wordArr = Constant.ALL_WORD.split(",");
		String[] partArr = Constant.ALL_WORD_PART.split(",");
		for (String part : partArr) {
			for (String word : wordArr) {
				for (String word2 : wordArr) {
					for (String word3 : wordArr) {
						for (String word4 : wordArr) {
							String name = part+word+word2+word3+word4;
							String md5 = Md5Util.digestByMd5(name);
							Md5ApplyEntity entity = new Md5ApplyEntity(name, md5, "5_1");
							logger.info("新增md5参数--5_1--"+name);
							int num = md5ApplyDao.save(entity);
							logger.info("新增md5返回--"+num);
						}
					}
				}
			}
		}
	}
	
	@Async
	public void mk2() {
		String[] wordArr = Constant.ALL_WORD.split(",");
		String[] partArr = Constant.ALL_WORD_PART_2.split(",");
		for (String part : partArr) {
			for (String word : wordArr) {
				for (String word2 : wordArr) {
					for (String word3 : wordArr) {
						for (String word4 : wordArr) {
							String name = part+word+word2+word3+word4;
							String md5 = Md5Util.digestByMd5(name);
							Md5ApplyEntity entity = new Md5ApplyEntity(name, md5, "5_2");
							logger.info("新增md5参数--5_2--"+name);
							int num = md5ApplyDao.save(entity);
							logger.info("新增md5返回--"+num);
						}
					}
				}
			}
		}
	}
	
	@Async
	public void mk3() {
		String[] wordArr = Constant.ALL_WORD.split(",");
		String[] partArr = Constant.ALL_WORD_PART_3.split(",");
		for (String part : partArr) {
			for (String word : wordArr) {
				for (String word2 : wordArr) {
					for (String word3 : wordArr) {
						for (String word4 : wordArr) {
							String name = part+word+word2+word3+word4;
							String md5 = Md5Util.digestByMd5(name);
							Md5ApplyEntity entity = new Md5ApplyEntity(name, md5, "5_3");
							logger.info("新增md5参数--5_3--"+name);
							int num = md5ApplyDao.save(entity);
							logger.info("新增md5返回--"+num);
						}
					}
				}
			}
		}
	}
	
	@Async
	public void mk4() {
		String[] wordArr = Constant.ALL_WORD.split(",");
		String[] partArr = Constant.ALL_WORD_PART_4.split(",");
		for (String part : partArr) {
			for (String word : wordArr) {
				for (String word2 : wordArr) {
					for (String word3 : wordArr) {
						for (String word4 : wordArr) {
							String name = part+word+word2+word3+word4;
							String md5 = Md5Util.digestByMd5(name);
							Md5ApplyEntity entity = new Md5ApplyEntity(name, md5, "5_4");
							logger.info("新增md5参数--5_4--"+name);
							int num = md5ApplyDao.save(entity);
							logger.info("新增md5返回--"+num);
						}
					}
				}
			}
		}
	}
	
	@Async
	public void mk5() {
		String[] wordArr = Constant.ALL_WORD.split(",");
		String[] partArr = Constant.ALL_WORD_PART_5.split(",");
		for (String part : partArr) {
			for (String word : wordArr) {
				for (String word2 : wordArr) {
					for (String word3 : wordArr) {
						for (String word4 : wordArr) {
							String name = part+word+word2+word3+word4;
							String md5 = Md5Util.digestByMd5(name);
							Md5ApplyEntity entity = new Md5ApplyEntity(name, md5, "5_5");
							logger.info("新增md5参数--5_5--"+name);
							int num = md5ApplyDao.save(entity);
							logger.info("新增md5返回--"+num);
						}
					}
				}
			}
		}
	}

}
