package com.imooc.myo2o.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.myo2o.dao.PersonDao;
import com.imooc.myo2o.dto.PersonExecution;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.enums.PersonStateEnum;
import com.imooc.myo2o.exception.PersonOperationException;
import com.imooc.myo2o.exception.ShopOperationException;
import com.imooc.myo2o.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDao personDao;

	@Override
	public PersonExecution addPerson(PersonInfo person) throws PersonOperationException {

		// 空值判断
		if (person == null) {
			return new PersonExecution(PersonStateEnum.NULL_PERSON);
		}
		try {
			person.setEnableStatus(1);
			person.setCreateTime(new Date());
			person.setLastEditTime(new Date());
			// 添加用户信息
			int effectedNum = personDao.insertPerson(person);
			if (effectedNum <= 0) {
				throw new ShopOperationException("用户注册失败");
			}
		} catch (Exception e) {
			throw new PersonOperationException("addPerson error:" + e.getMessage());
		}
		return new PersonExecution(PersonStateEnum.SUCCESS, person);

	}

	@Override
	public PersonExecution queryPersonByNameAndPwd(String name, String password) throws PersonOperationException {
		if (name == null || name.equals("") || password == null || password.equals("")) {
			return new PersonExecution(PersonStateEnum.NULL_PERSON);
		}
		PersonExecution pe = new PersonExecution();
		try {
			PersonInfo p = personDao.queryPersonByNameAndPwd(name, password);
			if (p != null) {
				pe.setPerson(p);
			} else {
				return new PersonExecution(PersonStateEnum.INNER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pe;

	}

}
