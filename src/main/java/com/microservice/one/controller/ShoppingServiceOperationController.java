package com.microservice.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.one.component.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationController {
 @Autowired
	private BillingServiceConsumerClient client;
	@GetMapping("/cart")
 public ResponseEntity<String> doShopping(){
		System.out.println("Consumer Method started ");
	 String resultMsg=client.getBillingInfo();
	 return new ResponseEntity<String>(" Load Balancer Shopping the item(shirts,troust)"+resultMsg,HttpStatus.OK);
 }
}
