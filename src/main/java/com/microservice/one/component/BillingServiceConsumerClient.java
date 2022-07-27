package com.microservice.one.component;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient {
	@Autowired
	private LoadBalancerClient client;

	public String getBillingInfo() {
		ServiceInstance instance = client.choose("MS-Producer");
		// get details from Service Instance
		URI uri = instance.getUri();
// prepare provider Ms related url to consume method
		String url = uri.toString() + "/billing/api/info";

// create RestTemplate class obj to consumer the provider service
		RestTemplate template = new RestTemplate();
		// consume the provider service
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		// get response content from ResponseEntity Object
		String responseContent = response.getBody();
		return responseContent;
	}
}
