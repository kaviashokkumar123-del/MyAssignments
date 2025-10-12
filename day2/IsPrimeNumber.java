package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {

		int num = 5;
		boolean b = false;
		for (int i = 2; i <num; i++) {
			if (num % i == 0) {
				b = false;
			} else {
				b = true;
			}
		}
		if (b == true) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Not a Prime Number");
		}
	}

}
