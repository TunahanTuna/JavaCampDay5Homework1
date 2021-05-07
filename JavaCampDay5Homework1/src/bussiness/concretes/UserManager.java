package bussiness.concretes;

import java.util.List;

import bussiness.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	
	//Constructor
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void remove(User user) {
		userDao.delete(user);
		
	}

	

	@Override
	public void verifyUser(int id) {
		User user = userDao.findByID(id);
		user.setCheck(true);
		System.out.println("Dogrulama islemi gerceklesti.");
		
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return userDao.findByID(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	public User findByEmailPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.findByEmailPassword(email, password);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
	
	
}
