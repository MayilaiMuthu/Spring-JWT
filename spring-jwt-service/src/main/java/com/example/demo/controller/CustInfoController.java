package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerInfoRequest;

/**
 * @author MayilaiMuthu
 * @since 08-Aug-2023
 *
 */
@RestController
@RequestMapping("/customer-info")
public class CustInfoController {
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck(){
		return new ResponseEntity<>("hi....",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerInfoRequest request){
		return new ResponseEntity<>("hi....",HttpStatus.CREATED);
	}

}
