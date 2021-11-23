package io.github.ailtonbsj.inversaoDeControle;

public class SendEmails {

	public SendEmails(String type, String address, String password) {
		
	}
	
	public static SendEmails getEmailData() {
		return new SendEmails("stmp", "contact@mail.com", "key");
	}
	
	public void showMessage(String message) {
		System.out.println("Email has sended!");
	}
	
}
