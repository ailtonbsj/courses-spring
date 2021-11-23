package io.github.ailtonbsj.inversaoDeControle;

public class Order {
	private SendEmails send = SendEmails.getEmailData();
	
	public static void main(String[] args) {
		Order order = new Order();
		order.record();
	}
	
	public void record() {
		this.send.showMessage("Order created!");
	}
}
 