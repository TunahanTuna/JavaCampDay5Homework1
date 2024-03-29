package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class MemUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(x-> x.getId()==user.getId());
		
	}

	@Override
	public User findByID(int id) {
		for(User user : users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}

	@Override
	public User findByEmail(String eMail) {
		for(User user: users) {
			if(user.geteMail() == eMail)
				return user;
		}
		return null;
	}

	@Override
	public User findByEmailPassword(String eMail, String password) {
		for(User user: users) {
			if(user.geteMail()==eMail && user.getPassword()==password) 
				return user;
			
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

}
