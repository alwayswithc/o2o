package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.PersonExecution;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.exception.PersonOperationException;

public interface PersonService {

	/**
	 * 注册用户信息
	 * 
	 * @param person
	 * @return
	 * @throws PersonOperationException
	 */
	PersonExecution addPerson(PersonInfo person) throws PersonOperationException;
	/**
	 * 通过帐号和密码查询对应信息，登录用
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	PersonExecution queryPersonByNameAndPwd(String name, String password) throws PersonOperationException;
}
