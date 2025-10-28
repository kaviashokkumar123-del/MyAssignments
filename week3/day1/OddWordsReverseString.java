package week3.day1;


public class OddWordsReverseString {

    public static void main(String[] args) {
    	//String literals
        String test = "I am a software tester";
        //split function to spilt the string
        String[] words = test.split(" ");
        //string variables with empty value.
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (i % 2 != 0) { // Reverse words at odd positions
                String reversed = "";
                char[] ch = words[i].toCharArray();
                for (int j = ch.length - 1; j >= 0; j--) {
                    reversed = reversed + ch[j];
                }
                result = result + reversed;
            } else {
                result = result + words[i];
            }

            // Add space between words except after the last one
            if (i < words.length - 1) {
                result = result + " ";
            }
        }

        System.out.println(result);
    }
}