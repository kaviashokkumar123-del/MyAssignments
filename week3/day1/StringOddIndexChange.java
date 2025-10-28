package week3.day1;

public class StringOddIndexChange {

	public static void main(String[] args) {
		// String literals
		// 01234567
		String test = "changeme";
		// Convert character to char array
		char[] c = test.toCharArray();
		String st1 = "", st2 = "";
		// loop to find the odd index and convert it to uppercase
		// 1,3,5,7,9 are odd index
		for (int i = 0; i < c.length; i++) {
			if (i % 2 == 0) {
				st1 = (st1 + c[i]);
			}

			if (i % 2 != 0) {
				st2 = (st2 + c[i]).toUpperCase();
			}
		}
		char[] k = st1.toCharArray();
		char[] f = st2.toCharArray();
		String st3 = "";
		for (int i = 0; i < st1.length(); i++) {
			for (int j = 0; j < st2.length(); j++) {
				if (i == j) {
					st3 = st3 + k[i] + f[j];
				}
			}
		}
		System.out.println(st3);
	}

}
