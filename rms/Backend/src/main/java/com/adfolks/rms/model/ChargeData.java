package com.adfolks.rms.model;

import com.adfolks.rms.domain.RateEntity;

public class ChargeData {
	private RateEntity rateDetails;
	private ChargeResponse chargeDetails;
	
	public ChargeData(RateEntity rateDetails, ChargeResponse chargeDetails) {
		super();
		this.rateDetails = rateDetails;
		this.chargeDetails = chargeDetails;
	}
	public RateEntity getRateDetails() {
		return rateDetails;
	}
	public void setRateDetails(RateEntity rateDetails) {
		this.rateDetails = rateDetails;
	}
	public ChargeResponse getChargeDetails() {
		return chargeDetails;
	}
	public void setChargeDetails(ChargeResponse chargeDetails) {
		this.chargeDetails = chargeDetails;
	}
	
	

}
