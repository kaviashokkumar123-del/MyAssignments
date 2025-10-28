package week3.day2;

public class Elements extends Button {

	public static void main(String[] args) {
		Elements e = new Elements();
		e.click();
		e.setText("Inheritance Concept");
		e.submit();
		RadioButton rb = new RadioButton();
		rb.electRadioButton();
		rb.click();
		CheckBoxButton cb = new CheckBoxButton();
		cb.clickCheckButton();
		cb.click();
	}

}
