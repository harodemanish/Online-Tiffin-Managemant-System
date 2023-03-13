package com.example.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.model.TiffinProvider;

public interface TiffinProviderRepositry  extends JpaRepository<TiffinProvider, Integer> {

}
