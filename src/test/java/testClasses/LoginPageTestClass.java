package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 3, groups = {"group1"}, retryAnalyzer = RetryAnalyzer.class)
	public void verfySuccesfullLogin() throws IOException {
		lp = new LoginPageClass(driver);
		//lp.login("admin", "Admin123");
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp = new HomePageClass(driver);
		String actualResult = hp.getTextOfSuperAdminText();
		//String expectedResult = "Logged in as Super User (admin) at Registration Desk.";
		String expectedResult = lp.readStringData(1, 2);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "unsuccessfullLogin", priority = 4, groups = {"group1"})
	public void verifyUnsuccessfulLogin(String uname, String pass) throws IOException {
		lp = new LoginPageClass(driver);
		//lp.loginFailure("admin123", "Admin1234");
		//lp.loginFailure(lp.readStringData(2, 0), lp.readStringData(1, 2));
		lp.login(uname, pass);
		String actualResult = lp.getErrorMessageOnLoginFailure();
		//String expectedResult = "Invalid username/password. Please try again.";
		String expectedResult = lp.readStringData(2, 3);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 1, groups = {"group2"})
	public void verifyTheExpectedPageisOpensWhileHittingTheUrl() {
		lp = new LoginPageClass(driver);
		String actualResult = lp.getHomePageURL();
		String expectedResult = "https://demo.openmrs.org/openmrs/login.htm";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, groups = {"group2"})
	public void veryfyLogoIsDisplayedOrNotInLoginPage() {
		lp = new LoginPageClass(driver);
		boolean actualResult = lp.isLogoDisplayedOrNot();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 5, groups = "group2")
	public void verifyAllLocationSessionsAreDisplayedOrNotInLoginPage() {
		lp = new LoginPageClass(driver);
		String[] actualResult = lp.verifyLocationSessions();
		String[] expectedResult = { "Inpatient Ward", "Isolation Ward", "Laboratory", "Outpatient Clinic", "Pharmacy",
				"Registration Desk" };
		Assert.assertEquals(actualResult, expectedResult);
	}

	
}
