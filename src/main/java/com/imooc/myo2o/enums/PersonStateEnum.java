package com.imooc.myo2o.enums;

public enum PersonStateEnum {
	SUCCESS(1, "操作成功"), INNER_ERROR(-1001,"内部系统错误"), 
	NULL_USERID(-1002, "userId为空"),NULL_PERSON(-1003, "person信息为空");
	
	private int state;
	private String stateInfo;

	private PersonStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static PersonStateEnum stateOf(int state) {
		for (PersonStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}


}
