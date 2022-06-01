package com.adfolks.rms.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adfolks.rms.domain.RateEntity;
import com.adfolks.rms.model.ChargeData;
import com.adfolks.rms.model.ChargeResponse;
import com.adfolks.rms.repo.RateRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RateManagementSystemService {

	@Autowired
	RateRepo rateRepo;
	@Autowired
	RestTemplate restTemplate;

	private String url = "https://adfolks.free.beeceptor.com/charge";

	@HystrixCommand(fallbackMethod = "defaultSearchRate")
	public ChargeData searchRate(Long RateId) {
		ChargeResponse chargeResponse = restTemplate.getForObject(url, ChargeResponse.class);
		Optional<RateEntity> rateEntity = rateRepo.findById(RateId);
		if (rateEntity.isPresent())
			return new ChargeData(rateEntity.get(), chargeResponse);
		else
			return null;
	}
	
	public ChargeData defaultSearchRate(Long RateId) {
		return null;
	}

	@HystrixCommand(fallbackMethod = "defaultAddRate")
	public void addRate(RateEntity rateDetails) {
		rateRepo.save(rateDetails);
	}
	
	public void defaultAddRate(RateEntity rateDetails) throws Exception {
		throw new Exception();
	}

	@HystrixCommand(fallbackMethod = "defaultDeleteRate")
	public boolean deleteRate(Long rateId) {
		if (rateRepo.existsById(rateId))
			rateRepo.deleteById(rateId);
		else
			return false;
		return true;
	}
	
	public boolean defaultDeleteRate(Long rateId) {
		return false;
	}

}
