package com.example.springpropsdemo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("customerresponsefilter")
public class FilterPojo {
	private String field1;
	@JsonIgnore
	private String password;
	private String field3;
	
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	@Override
	public String toString() {
		return "FilterPojo [field1=" + field1 + ", password=" + password + ", field3=" + field3 + "]";
	}
	public FilterPojo(String field1, String password, String field3) {
		super();
		this.field1 = field1;
		this.password = password;
		this.field3 = field3;
	}
	
	
}
