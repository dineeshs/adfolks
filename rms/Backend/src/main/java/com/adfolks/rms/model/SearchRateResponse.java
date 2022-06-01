package com.adfolks.rms.model;

public class SearchRateResponse {
	private Integer statusCode;
	private String description;
	private ChargeData data;
	
	
	public SearchRateResponse(Integer statusCode, String description, ChargeData data) {
		super();
		this.statusCode = statusCode;
		this.description = description;
		this.data = data;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ChargeData getData() {
		return data;
	}
	public void setData(ChargeData data) {
		this.data = data;
	}
	

}
