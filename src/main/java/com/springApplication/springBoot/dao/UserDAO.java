package com.springApplication.springBoot.dao;

import com.springApplication.springBoot.entity.UserEntity;

public interface UserDAO {

	UserEntity getUserDetails(String emailAddress);

	UserEntity createUser(UserEntity userEntity);

	UserEntity updateUser(UserEntity entityDetails);

}
