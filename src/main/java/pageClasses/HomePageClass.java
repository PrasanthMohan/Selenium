package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePageClass {
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']//child::h4")
	WebElement loggedInAsSuperAdmin;

	@FindBy(xpath = "//a[@type='button']")
	List<WebElement> adminHomePageTiles;

	@FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	WebElement registerPatientLink;

	@FindBy(id = "appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")
	WebElement appointmentSchedulingLink;;

	public void clickOnRegisterPatient() {
		guObj.clickOnAnElement(registerPatientLink);
	}

	public void clickOnAppointmentSchedulingLink() {
		guObj.clickOnAnElement(appointmentSchedulingLink);
	}

	public String[] verifyAllTilesAreDisplayedInHomePage() {
		String adminPageTilesArray[] = new String[9];
		// System.out.println(adminHomePageTiles);
		int i = 0;
		for (WebElement adminHomePageTile : adminHomePageTiles) {
			System.out.println(guObj.getTextOfElement(adminHomePageTile));
			adminPageTilesArray[i] = guObj.getTextOfElement(adminHomePageTile);
			i++;
		}
		return adminPageTilesArray;
	}

	public String getTextOfSuperAdminText() {
		return guObj.getTextOfElement(loggedInAsSuperAdmin);

	}
}
