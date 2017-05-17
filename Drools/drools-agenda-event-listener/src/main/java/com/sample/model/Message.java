package com.sample.model;

/**
 * POJO class to wrap the example data 
 * that will be evaluated by the rule
 *
 */
public class Message {
	
	private int code;
	private String text;
	
	public Message(int code, String text) {
		super();
		this.code = code;
		this.text = text;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
