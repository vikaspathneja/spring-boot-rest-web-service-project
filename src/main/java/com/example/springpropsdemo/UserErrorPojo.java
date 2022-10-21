package com.example.springpropsdemo;

public class UserErrorPojo {
	private String errorDescrption;

	public String getErrorDescrption() {
		return errorDescrption;
	}

	public void setErrorDescrption(String errorDescrption) {
		this.errorDescrption = errorDescrption;
	}

	@Override
	public String toString() {
		return "UserErrorPojo [errorDescrption=" + errorDescrption + "]";
	}

	public UserErrorPojo(String errorDescrption) {
		super();
		this.errorDescrption = errorDescrption;
	}
	
	

}
