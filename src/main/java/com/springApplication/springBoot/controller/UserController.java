package com.springApplication.springBoot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springApplication.springBoot.entity.Address;
import com.springApplication.springBoot.entity.Idenitification;
import com.springApplication.springBoot.entity.UserEntity;
import com.springApplication.springBoot.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/createUser", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
	  Idenitification idenitification = userEntity.getIdenitification(); 
	  List<Address> address = userEntity.getAddress(); 
	  Address userAddress = new Address();
	  userAddress.setUserEntity(userEntity);
	  idenitification.setUserEntity(userEntity);
	  System.out.println("Identification"+idenitification.getAdharNumber());
	  userEntity.setAddress(address);
	  userEntity.setIdenitification(idenitification);
	  UserEntity entity =userService.createUser(userEntity);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/updateUser", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateUser(@RequestBody UserEntity userEntity) {
		UserEntity entity = userService.updateUser(userEntity);
		return new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
	}
}
