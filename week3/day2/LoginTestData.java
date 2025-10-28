package week3.day2;

public class LoginTestData extends TestData {

	public void enterUsername() {
		System.out.println("Enter the UserName from the LoginTestData class");

	}

	public void enterPassword() {
		System.out.println("Enter the PassWord from the LoginTestData class");
	}

	public static void main(String[] args) {
		LoginTestData ld = new LoginTestData();
		ld.enterCredentials();
		ld.navigateToHomePage();
		ld.enterUsername();
		ld.enterPassword();

	}

}
