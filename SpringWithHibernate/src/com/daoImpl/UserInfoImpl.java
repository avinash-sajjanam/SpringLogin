package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.config.HibernateConfig;
import com.dao.UserInfo;
import com.model.User;

@Repository

public class UserInfoImpl implements UserInfo {

	@Override
	public void save(User user) {
		Session session = HibernateConfig.getSessionFactory();
		System.out.println(user.getUsername());
		try {
			session.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void checkUser(User user) {

		Session session = HibernateConfig.getSessionFactory();
		user.getUsername();
		user.getPassword();
		try {
			session.beginTransaction();
			@SuppressWarnings({ "deprecation" })

			List<?> userObjs = session.createNamedQuery("CheckUser").setProperties(user).list();
			for (int i = 0; i < userObjs.size(); i++) {
				System.out.println(userObjs.get(i));
			}
			if (userObjs.size() != 0) {
				
				System.out.println("success");
				

			} else {
				System.out.println("invalid credentials");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
