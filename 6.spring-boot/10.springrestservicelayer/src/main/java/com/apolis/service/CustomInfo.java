package com.apolis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfo implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String,Integer> details = new HashMap<String,Integer>();
		details.put("active users",34);
		details.put("inactive users", 21);
		builder.withDetail("user datails", details);
	}

}
