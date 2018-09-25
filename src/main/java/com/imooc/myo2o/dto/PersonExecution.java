package com.imooc.myo2o.dto;

import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.enums.PersonStateEnum;

public class PersonExecution {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;
	
	private PersonInfo person;
	
	public PersonExecution() {
		
	}

	// 失败的构造器
	public PersonExecution(PersonStateEnum stateEnum) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}

	
	// 成功的构造器
	public PersonExecution(PersonStateEnum stateEnum, PersonInfo person) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.person = person;
		}
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public PersonInfo getPerson() {
		return person;
	}

	public void setPerson(PersonInfo person) {
		this.person = person;
	}


}
