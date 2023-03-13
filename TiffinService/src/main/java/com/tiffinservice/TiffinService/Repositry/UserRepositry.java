package com.tiffinservice.TiffinService.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiffinservice.TiffinService.Entities.User;

//@Repository
public interface UserRepositry extends JpaRepository<User, Integer> {

}
