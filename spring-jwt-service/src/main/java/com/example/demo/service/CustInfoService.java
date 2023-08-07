package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerInfoRequest;
import com.example.demo.entity.CustInfo;
import com.example.demo.repository.CustInfoRepository;

/**
 * @author MayilaiMuthu
 * @since 08-Aug-2023
 *
 */
@Service
public class CustInfoService {

	@Autowired
	private CustInfoRepository infoRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String addCustomer(CustomerInfoRequest request) {
		infoRepository.save(CustInfo.builder().custCrDt(LocalDateTime.now()).custEmailId(request.getCustEmailId())
				.custMobileNo(request.getCustMobileNo()).custName(request.getCustName())
				.custPassword(bCryptPasswordEncoder.encode(request.getCustPassword())).build());
		return request.getCustName() + ", your details Added";
	}

}
