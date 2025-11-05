package week4.day1;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfNumbers {

	public static void main(String[] args) {
		int[] a1 = {3, 2, 11, 4, 6, 7};
		int[] b1 = {1, 2, 8, 4, 9, 7};
		
		List<Integer> a2 = new ArrayList<Integer>();
		for(int a3 : a1)
		{
			a2.add(a3);
		}
//		System.out.println(a2);
		List<Integer> b2 = new ArrayList<Integer>();
		for(int b3 : b1)
		{
			b2.add(b3);
		}
//		System.out.println(b2);
		System.out.print("The intersecting numbers in the given two array list : ");
		for (int i = 0; i < a2.size(); i++) {
			for (int j = 0; j < b2.size(); j++) {
				if(a2.get(i)==b2.get(j))
				{
					System.out.print(a2.get(i)+",");
				}
				
			}
			
		}
	}

}
