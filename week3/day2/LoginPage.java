package week3.day2;

public class LoginPage extends BasePage{
	@Override
	public void performCommonTasks()
	{
		//In order to call the super class method use super Keyword
		super.performCommonTasks();
		System.out.println("Perform Common Tasks method from SubClass");
	}

	public static void main(String[] args) {
		//Instantiate the Object for the subclass
		LoginPage lp = new LoginPage();
		lp.performCommonTasks();
	}

}
