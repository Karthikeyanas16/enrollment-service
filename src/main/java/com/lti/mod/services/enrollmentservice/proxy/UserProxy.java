package com.lti.mod.services.enrollmentservice.proxy;

import java.math.BigInteger;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lti.mod.services.enrollmentservice.model.Technology;
import com.lti.mod.services.enrollmentservice.model.User;

@FeignClient(name="search-services", url="${feign.client.default-config}")
public interface UserProxy {

	@GetMapping("/user/{id}")
	public User findUserbyId(@PathVariable("id") BigInteger id);
	
	@GetMapping("/technology/{id}")
	public Technology findTechnologybyId(@PathVariable("id") BigInteger id);

}
