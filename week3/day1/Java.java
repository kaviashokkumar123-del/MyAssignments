package week3.day1;

public class Java {

	public void reportStep(String msg, String status) {
		System.out.println("The message from the two argument report is :" + msg + " with the status as " + status);

	}

	public void reportStep(String msg, String status, boolean snap) {
		System.out.println("The message from the three argument report is :" + msg + " with the status as" + status + " and snap indicator is " + snap);
	}

	public static void main(String[] args) {
		Java j = new Java();
		j.reportStep("ReportOne", "Pass");
		j.reportStep("ReportTwo", "Pass", true);

	}

}
