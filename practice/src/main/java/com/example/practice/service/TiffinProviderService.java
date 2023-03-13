package com.example.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.model.TiffinProvider;
import com.example.practice.repositories.TiffinProviderRepositry;

@Service
public class TiffinProviderService {
	
	@Autowired
	private TiffinProviderRepositry providerRepositry;
	
	public List<TiffinProvider> getProvider() {
		return providerRepositry.findAll();
	}
	
	public Optional<TiffinProvider> getProviderById(Integer id) {
		
		Optional<TiffinProvider> kt = providerRepositry.findById(id);
		
		return kt;
		
	}
	public TiffinProvider addProvider(TiffinProvider provider) {
		return providerRepositry.save(provider);
	}
	
}
