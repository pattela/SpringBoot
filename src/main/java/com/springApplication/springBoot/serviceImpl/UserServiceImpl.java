package com.springApplication.springBoot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApplication.springBoot.dao.UserDAO;
import com.springApplication.springBoot.entity.Idenitification;
import com.springApplication.springBoot.entity.UserEntity;
import com.springApplication.springBoot.service.UserService;
import com.springApplication.springBoot.serviceException.UserException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	
	@Override
	public UserEntity createUser(UserEntity userEntity) {
		UserEntity userDetails = null; 
		userDetails =userDAO.getUserDetails(userEntity.getEmailAddress());
		if(userDetails != null) {
			if(userDetails.getEmailAddress().equalsIgnoreCase(userEntity.getEmailAddress())) {
				try {
					throw new UserException("Err000", "User alredy exist");
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			
			userDetails = userDAO.createUser(userEntity);
		}
		return userDetails;
	}


	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		UserEntity entityDetails = null;
		entityDetails = userDAO.getUserDetails(userEntity.getEmailAddress());
		if(entityDetails != null) {
			entityDetails.setFirstName(userEntity.getFirstName());
			entityDetails.setLastName(userEntity.getLastName());
			entityDetails = userDAO.updateUser(entityDetails);
			if(entityDetails != null) {
				return entityDetails;
			} else {
				try {
					throw new UserException("Err001", "Unable to update the userDetails1");
				} catch (UserException e) {
					e.printStackTrace();
				}
			}
		}
		return entityDetails;
	}

}
