package week3.day1;

public class DuplicateWordFromString {

	public static void main(String[] args) {
		// String literals
		String text = "We learn Java basics as part of java sessions in java week1";
		// String array to split the words.
		String[] textSplit = text.split(" ");
		String st3 = "";
		/*
		 * We 0<12 learn 1<12
		 */
		// length is 12
		boolean duplicate = true;
		for (int i = 0; i < textSplit.length; i++) {
			for (int j = 0; j < textSplit.length; j++) {
				if ((i != j) && (textSplit[i].equals(textSplit[j]))) {
					duplicate = true;
					break;
				} else {
					duplicate = false;
				}
			}
			if (duplicate) {
				st3 = st3 + " ";
			} else {
				st3 = st3 + textSplit[i] + " ";
			}
		}
		System.out.println(st3);
	}

}