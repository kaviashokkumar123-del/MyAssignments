package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElement {

	public static void main(String[] args) {
		// Array literals
		// 0 1 2 3 4 5 6
		int[] a = { 1, 2, 3, 4, 10, 6, 8 };
		// Create empty List interface
		List<Integer> list = new ArrayList<Integer>();
		for (int a1 : a) {
			list.add(a1);
		}
		System.out.print("The Missing numbers are: ");
		Collections.sort(list);
		int a1 = list.size();// 7
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < a1 - 1; i++) {
			
			if (list.get(i) != list.get(i + 1) - 1) {
				list2.add(list.get(i + 1) - 1);
			} else {
				continue;
			}

		}
		System.out.println(list2);
	}

}
