package org.yadi.restfulapi.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String message;
	private int errorcode;
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorMessage(String message, int errorcode) {
		this.setErrorcode(errorcode);
		this.setMessage(message);
			}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	
	
	
}
