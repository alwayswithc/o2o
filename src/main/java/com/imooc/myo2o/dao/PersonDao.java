package com.imooc.myo2o.dao;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.PersonInfo;

public interface PersonDao {
	/**
	 * 用户添加
	 * @param PersonInfo person
	 * @return
	 * 
	 */
	int insertPerson(PersonInfo person);
	/**
	 * 通过帐号和密码查询对应信息，登录用
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	PersonInfo queryPersonByNameAndPwd(@Param("name")String name, @Param("password")String password);
	

}
