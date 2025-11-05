package week4.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharacters {

	public static void main(String[] args) {
		// String literals to store value
		String companyName = "google";
		String st1 = "";
		// Char array to store the string as char
		char[] c = companyName.toCharArray();
		// initialize the set.
		Set<Character> set = new LinkedHashSet<Character>();
		for (Character ch : c) {
			set.add(ch);
		}
		for (Character ch1 : set) {
			st1 = st1 + ch1;
		}
		System.out.println(st1);
	}

}
