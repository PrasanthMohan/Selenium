package testClasses;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterPatientClass;

public class RegisterPatientTestClass extends BaseClass {

	public HomePageClass hp;
	public LoginPageClass lp;
	public RegisterPatientClass rp;
	
	@Test(groups = {"group1"})
	public void verifyToRegisterPatient() throws IOException {
		hp = new HomePageClass(driver);
		lp = new LoginPageClass(driver);
		rp = new RegisterPatientClass(driver);
		
		lp.login("admin", "Admin123");
		hp.clickOnRegisterPatient();
		
		rp.registerPatient(rp.readStringData(6, 1),
				rp.readStringData(7, 1),rp.readStringData(8, 1),"M", rp.readIntegerData(9, 1), rp.readIntegerData(10, 1), "Address1", "Address2", "City", "State", "Country", "Postal Code", "987654321", "Parent", "Manu" );
		String actualResult = rp.getTextOfGivenName();
		String expectedResult = "Jose";
		//Assert.assertEquals(actualResult, expectedResult);
		Assert.assertTrue(actualResult.contains("Jose"));
	}
	
}
