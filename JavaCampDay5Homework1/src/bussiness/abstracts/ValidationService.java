package bussiness.abstracts;

import entities.concretes.User;

public interface ValidationService {
	
	 boolean validate(User user);
}
