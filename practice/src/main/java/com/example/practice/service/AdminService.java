package com.example.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.model.TiffinProvider;
import com.example.practice.repositories.TiffinProviderRepositry;

@Service
public class AdminService {

	@Autowired
	private TiffinProviderRepositry providerRepositry;
	
	public TiffinProvider approveOrRject(TiffinProvider provider,String status) {
		provider.setIsApproved("Y");
		return providerRepositry.save(null);
	}
}
