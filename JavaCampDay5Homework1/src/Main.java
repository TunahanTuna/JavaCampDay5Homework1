import entities.*;
import bussiness.abstracts.UserService;
import bussiness.concretes.AuthenticationManager;
import bussiness.concretes.EmailManager;
import bussiness.concretes.UserManager;
import bussiness.concretes.ValidationManager;
import core.abstracts.AuthenticationService;
import core.concretes.GoogleAuthenticationAdapter;
import dataAccess.concretes.MemUserDao;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new MemUserDao());
		AuthenticationService authenticationService = new AuthenticationManager(new ValidationManager(), userService, new EmailManager());
		
		authenticationService.register(1, "tunahan@gmail.com", "123123123", "Tunahan", "Tuna");
		authenticationService.register(2, "basarisiz.dasdaf", "1231", "Deneme", "Kisisi");
		authenticationService.register(3, "info@gmail.com", "t", "Ali", "Tuna");
		authenticationService.register(4, "info@gmail.com", "blabla", "L", "T");
		authenticationService.register(5, "tunahan@gmail.com", "denemeSifre", "Mustafa", "Tuna");
		
		authenticationService.login("tunahan@gmail.com", "123123123");
		userService.verifyUser(1);
		
		authenticationService.login("tunahan@gmail.com", "12123123");
		
		authenticationService.login("tunahan@gmail.com", "123123123");
		
		authenticationService.login("", "");
		
		
		AuthenticationService googleAuth = new GoogleAuthenticationAdapter();
		googleAuth.register(6, "mehmet@gmail.com", "mehmet123", "Mehmet", "Teoman");
		googleAuth.login("mehmet@gmail.com", "mehmet123");
		
		
	}

}
