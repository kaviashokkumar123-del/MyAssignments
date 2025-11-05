package week4.day1;

public interface Payments {

	public void ashOnDelivery();
	public void upiPayments();
	public void cardPayments();
	public void internetBanking();
	
	default void newTest()
	{
	System.out.println("Default Method from Interface");	
	}
	public static void newTestOne()
	{
		System.out.println("Static Method from Interface");
	}
	//if the editor is not saved give ctrl+shift+s to save the script
}
