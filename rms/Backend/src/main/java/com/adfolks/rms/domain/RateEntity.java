package com.adfolks.rms.domain;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RATE")
public class RateEntity {
	
	@Id
	private Long RateId;
	private String RateDescription;
	private Date RateEffectiveDate;
	private Date RateExpirationDate;
	private Integer Amount;
	public Long getRateId() {
		return RateId;
	}
	public void setRateId(Long rateId) {
		RateId = rateId;
	}
	public String getRateDescription() {
		return RateDescription;
	}
	public void setRateDescription(String rateDescription) {
		RateDescription = rateDescription;
	}
	public Date getRateEffectiveDate() {
		return RateEffectiveDate;
	}
	public void setRateEffectiveDate(Date rateEffectiveDate) {
		RateEffectiveDate = rateEffectiveDate;
	}
	public Date getRateExpirationDate() {
		return RateExpirationDate;
	}
	public void setRateExpirationDate(Date rateExpirationDate) {
		RateExpirationDate = rateExpirationDate;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	
	

}
