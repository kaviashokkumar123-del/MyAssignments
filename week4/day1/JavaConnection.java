package week4.day1;

public class JavaConnection implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("connect() method implemented at the concrete class");

	}

	@Override
	public void disconnect() {
		System.out.println("disconnect() method implemented at the concrete class");

	}

	@Override
	public void executeUpdate() {
		System.out.println("executeUpdate() method implemented at the concrete class");

	}

	public static void main(String[] args) {
		//Instantiate the concrete class
		JavaConnection jc = new JavaConnection();
		jc.connect();
		jc.disconnect();
		jc.executeUpdate();

	}


}
