package testClasses;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class HomePageTestClass extends BaseClass {

	public HomePageClass hp;
	LoginPageClass lp;
	
	@Test
	public void verifyAllTilesAreDisplayedInHomePage() {
		hp = new HomePageClass(driver);
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");
		String[] actualResult = hp.verifyAllTilesAreDisplayedInHomePage();
		//System.out.println(Arrays.toString(actualResult));
		String[] expectedResult = {"Find Patient Record", 
				"Active Visits", 
				"Capture Vitals",
				"Register a patient",
				"Appointment Scheduling",
				"Reports",
				"Data Management",
				"Configure Metadata",
				"System Administration"
				};
		Assert.assertEquals(actualResult, expectedResult);
	}
	
}
