package com.cab.bean;

import java.io.Serializable;

public abstract class BaseBean implements Serializable{
	public abstract boolean validateBean(StringBuffer messageOfValidation);
	
}
