package bussiness.concretes;


import java.util.regex.Pattern;

import bussiness.abstracts.ValidationService;
import core.utils.ValidationRule;
import entities.concretes.User;

public class ValidationManager implements ValidationService {

	// Kaynak : https://stackoverflow.com/
		public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
	@Override
	public boolean validate(User user) {
		boolean result = ValidationRule.run(isFirstNameLengthValid(user.getFirstName()),
				isLastNameLengthValid(user.getLastName()),
				isEmailFormatValid(user.geteMail()),
				isPasswordLengthValid(user.getPassword()),
				isAllFieldsFilled(user.getFirstName(), user.getLastName(), user.geteMail(), user.getPassword()));
		return result;
	}

	
	private boolean isEmailFormatValid(String eMail) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(eMail).find();
	}
	
	private boolean isPasswordLengthValid(String password) {
		return password.length() > 6;
	}
	private boolean isFirstNameLengthValid(String firstName) {
		return firstName.length() > 2;
	}
	private boolean isLastNameLengthValid(String lastName) {
		return lastName.length() > 2;
	}
	private boolean isAllFieldsFilled(String firstName,String lastName,String eMail, String password) {
		if(firstName.length() <= 0 || lastName.length() <= 0 || eMail.length() <= 0 || password.length() <= 0) {
			return false;
		}
		return true;
	}
}
