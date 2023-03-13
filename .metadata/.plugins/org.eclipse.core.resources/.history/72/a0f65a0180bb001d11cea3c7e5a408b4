package com.example.practice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.practice.model.RequestManager;

public interface RequestManagerRepositry  extends JpaRepository<RequestManager, Integer> {

	public List<RequestManager> findByproviderId(String providerid);
}
