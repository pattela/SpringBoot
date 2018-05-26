package com.springApplication.springBoot.service;

import org.springframework.http.ResponseEntity;

import com.springApplication.springBoot.entity.UserEntity;

public interface UserService {

	UserEntity createUser(UserEntity userEntity);

	UserEntity updateUser(UserEntity userEntity);

}
