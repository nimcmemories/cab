package com.cab.bean;

public abstract class SystemBean {
	private boolean accessAllowed;

	public boolean isAccessAllowed() {
		return accessAllowed;
	}

	public void setAccessAllowed(boolean accessAllowed) {
		this.accessAllowed = accessAllowed;
	}
}
