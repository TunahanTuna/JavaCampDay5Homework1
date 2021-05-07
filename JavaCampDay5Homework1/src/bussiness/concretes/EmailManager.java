package bussiness.concretes;

import bussiness.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public void sendTo(String info, String address) {
		System.out.println("E-posta : " + info + " mesajý " + address + " adresine gönderildi.");		
	}

}
