package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	
	User findByID(int id);
	User findByEmail(String eMail);
	User findByEmailPassword(String eMail, String password);
	
	
	List<User> getAll();
	

}
