package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void setUp() {
		BaseClass.initDriver(); // MUST run or driver/wait will be null
	}

	@After
	public void tearDown() {
		BaseClass.driver.quit();
	}
}
