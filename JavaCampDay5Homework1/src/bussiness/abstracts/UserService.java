package bussiness.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	
	void add(User user);
	void remove(User user);
	void verifyUser(int id);
	User find(int id);
	User findByEmail(String email);
	User findByEmailPassword(String email,String password);
	List<User> getAll();

}
