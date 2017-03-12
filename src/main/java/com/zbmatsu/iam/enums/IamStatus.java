package com.zbmatsu.iam.enums;

public enum IamStatus {

	NORMAL("0"), DELETE("1");

	private final String status;

	private IamStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}
	
}
