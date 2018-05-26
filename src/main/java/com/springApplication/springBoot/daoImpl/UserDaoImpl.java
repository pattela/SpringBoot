package com.springApplication.springBoot.daoImpl;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springApplication.springBoot.dao.UserDAO;
import com.springApplication.springBoot.entity.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private SessionFactory getsessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public UserEntity createUser(UserEntity userEntity) {
		SessionFactory factory = getsessionFactory();
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Integer save = (Integer) session.save(userEntity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return userEntity;
	}

	@Override
	public UserEntity updateUser(UserEntity entityDetails) {
		SessionFactory factory = getsessionFactory();
		Session session = null;
		try {
			 session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			 session.update(entityDetails);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return entityDetails;
	}
	
	@Override
	public UserEntity getUserDetails(String emailAddress) {
		SessionFactory factory = getsessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		UserEntity entityDetails = (UserEntity) criteria.add(Restrictions.eq("emailAddress", emailAddress)).uniqueResult();
		if(entityDetails != null) {
			return entityDetails;
		}
		return null;
	}

	

}
