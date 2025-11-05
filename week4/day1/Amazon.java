package week4.day1;

public class Amazon extends CanaraBank {

	@Override
	public void ashOnDelivery() {
		System.out.println("Unimplemented method ashOnDelivery from Payments interface");

	}
	@Override
	public void upiPayments() {
		System.out.println("Unimplemented method upiPayments from Payments interface");

	}
	@Override
	public void cardPayments() {
		System.out.println("Unimplemented method cardPayments from Payments interface");

	}
	@Override
	public void internetBanking() {
		System.out.println("Unimplemented method internetBanking from Payments interface");

	}
	public static void main(String[] args) {
		Amazon a = new Amazon();
		//all the implemented methods from Interface are used here.
		a.ashOnDelivery();
		a.upiPayments();
		a.cardPayments();
		a.internetBanking();
		//The method from CanaraBank is used here.
		a.recordPaymentDetails();
		a.newTest();

	}

}
