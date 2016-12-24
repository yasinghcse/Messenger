package org.yadi.restfulapi.filter;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	private @QueryParam("year") int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
