package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumList {

	public static void main(String[] args) {
		// Array Literals
		int[] a = { 3, 2, 11, 4, 6, 7 };
		// create a List
		List<Integer> list = new ArrayList<Integer>();
		// get all the array element in the list.
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
//		System.out.println(list);
		// Collection Interface to sort the list - {2,3,4,6,7,11}
		Collections.sort(list);
		int size = list.size();
		// To get the second largest number from the last.
		int sec_LargetNum = list.get(size - 2);
		System.out.println("The Second largest number from the last " + sec_LargetNum);

	}

}
