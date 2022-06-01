package com.adfolks.rms.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adfolks.rms.business.JwtUserDetailsService;
import com.adfolks.rms.business.RateManagementSystemService;
import com.adfolks.rms.config.JwtTokenUtil;
import com.adfolks.rms.domain.RateEntity;
import com.adfolks.rms.model.ChargeData;
import com.adfolks.rms.model.LoginRequest;
import com.adfolks.rms.model.LoginResponse;
import com.adfolks.rms.model.SearchRateResponse;


@RestController
public class RateManagementSystemController {
	@Autowired
	RateManagementSystemService rateService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	Logger logger = LoggerFactory.getLogger(RateManagementSystemController.class);
	
	

	@GetMapping("/searchRate")
	public ResponseEntity<Object> searchRate(Long rateId) {

		ChargeData chargeData;
		try {
			chargeData = rateService.searchRate(rateId);
		} catch (Exception e) {
			return ResponseEntity.ok(new SearchRateResponse(404, "Internal server error. Please contact admin", null));
		}

		if (chargeData == null)
			return ResponseEntity.ok(new SearchRateResponse(404, "RateId not found in RMS", null));

		return ResponseEntity.ok(new SearchRateResponse(200, "Data fetched successfully", chargeData));
	}

	@GetMapping("/addRate")
	public ResponseEntity<Object> addRate(RateEntity rateDetails) {
		try {
			rateService.addRate(rateDetails);
		} catch (Exception e) {
			return ResponseEntity.ok(new SearchRateResponse(500, "Internal server error. Please contact admin", null));
		}

		return ResponseEntity.ok(new SearchRateResponse(200, "Data inserted successfully", null));
	}

	@Async
	@GetMapping("/updateRate")
	public ResponseEntity<Object> updateRate(RateEntity rateDetails) {
		try {
			// reusing same add rate method for updation
			rateService.addRate(rateDetails);
		} catch (Exception e) {
			return ResponseEntity.ok(new SearchRateResponse(500, "Internal server error. Please contact admin", null));
		}

		return ResponseEntity.ok(new SearchRateResponse(200, "Data inserted successfully", null));
	}

	@GetMapping("/deleteRate")
	public ResponseEntity<Object> deleteRate(Long rateId) {
		try {
			if (!rateService.deleteRate(rateId))
				return ResponseEntity.ok(new SearchRateResponse(404, "Rate not found in RMS", null));
		} catch (Exception e) {
			return ResponseEntity.ok(new SearchRateResponse(500, "Internal server error. Please contact admin", null));
		}

		return ResponseEntity.ok(new SearchRateResponse(200, "Data deleted successfully", null));
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(LoginRequest request) {
		try {
			authenticate(request.getUsername(), request.getPassword());
		} catch (Exception e) {
			return ResponseEntity.ok(null);
		}

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(request.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}


}
