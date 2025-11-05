package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManipulationCollectionElement {

	public static void main(String[] args) {
		// String literals
		String[] array = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
//		
		List<String> list2 = new ArrayList<String>();
		Collections.sort(list);
		for (int j = list.size() - 1; j >= 0; j--) {
			list2.add(list.get(j));
		}
		System.out.println(list2);
	}

}
