package week3.day1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		// Array Literals.
		int[] num = { 1, 4, 3, 2, 8, 6, 7 };
		// Array class to sort the elements.
		Arrays.sort(num);// after sort -> {1,2,3,4,6,7,8}
		for (int i = 0; i <= num.length; i++) {// 1
			if ((i + 1) != num[i])// 1!=1
			{
				System.out.println(i + 1);
				break;
			}

		}

	}

}
