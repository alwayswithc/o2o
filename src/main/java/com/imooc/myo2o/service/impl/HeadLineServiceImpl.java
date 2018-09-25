package com.imooc.myo2o.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.imooc.myo2o.dao.HeadLineDao;
import com.imooc.myo2o.entity.HeadLine;
import com.imooc.myo2o.service.HeadLineService;

@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Autowired
	private HeadLineDao headLineDao;
	
	@Override
	@Transactional
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
		
		return headLineDao.queryHeadLine(headLineCondition);
	}
}
