package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int fiboNumRange = 8;
		int firstVal = 0;
		int secVal = 1;
		for (int i = 0; i <fiboNumRange; i++) {
			System.out.print(firstVal + ",");
			int nextVal = firstVal + secVal;
			firstVal = secVal;
			secVal = nextVal;
		}

	}

}
