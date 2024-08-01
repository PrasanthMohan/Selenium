package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class RegisterPatientClass {
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWaitClass ewcObj = new ExplicitWaitClass();
	
	public RegisterPatientClass(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(name="givenName")
	WebElement givenName;
	
	@FindBy(name="middleName")
	WebElement middleName;
	
	@FindBy(name="familyName")
	WebElement familyName;
	
	@FindBy(id="next-button")
	WebElement nextBtn;
	
	@FindBy(id="gender-field")
	WebElement gender;
	
	@FindBy(id="birthdateYears-field")
	WebElement birthdateYears;
	
	@FindBy(id="birthdateMonths-field")
	WebElement birthdateMonths;
	
	@FindBy(id="address1")
	WebElement addressLine1;
	
	@FindBy(id="address2")
	WebElement addressLine2;
	
	@FindBy(id="cityVillage")
	WebElement cityVillage;
	
	@FindBy(id="stateProvince")
	WebElement stateProvince;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="postalCode")
	WebElement postalCode;
	
	@FindBy(name="phoneNumber")
	WebElement phoneNo;
	
	@FindBy(id="relationship_type")
	WebElement relationshipType;
	
	@FindBy(xpath="//input[@placeholder='Person Name']")
	WebElement personName;
	
	@FindBy(id="submit")
	WebElement submitBtn;
	
	@FindBy(id="cancelSubmission")
	WebElement cancelBtn;
	
	
	@FindBy(xpath="//h1[@class='mt-0 mb-2 name']")
	WebElement ShownGName;
	
	@FindBy(xpath="//span[@class='PersonName-middleName']")
	WebElement ShownMName;
	
	@FindBy(xpath="//span[@class='PersonName-familyName']")
	WebElement ShownFName;
	
	
	public void registerPatient(String gName, String mName, String fName, String gen, String bYear, String bMonth,
			String address1, String address2, String city, String state, String country, String post, String phone, 
			String relType, String pName) {
		
		
		guObj.typeOnElement(givenName, gName);
		guObj.typeOnElement(middleName, mName);
		guObj.typeOnElement(familyName, fName);
		guObj.clickOnAnElement(nextBtn);
		
		guObj.selectFromDropDownByValue(gender, gen);
		guObj.clickOnAnElement(nextBtn);
		
		guObj.typeOnElement(birthdateYears, bYear);
		guObj.typeOnElement(birthdateMonths, bMonth);
		guObj.clickOnAnElement(nextBtn);
		
		guObj.typeOnElement(addressLine1, address1);
		guObj.typeOnElement(addressLine2, address2);
		guObj.typeOnElement(cityVillage, city);
		guObj.typeOnElement(stateProvince, state);
		guObj.typeOnElement(postalCode, post);
		guObj.clickOnAnElement(nextBtn);
		
		guObj.typeOnElement(phoneNo, phone);
		guObj.clickOnAnElement(nextBtn);
		
		guObj.selectFromDropDownByVisibleText(relationshipType, relType);
		guObj.typeOnElement(personName, pName);
		guObj.clickOnAnElement(nextBtn);
		
		guObj.clickOnAnElement(submitBtn);
		
		
	}
	 public String getTextOfGivenName() {
		 ewcObj.visibitlityOfElementWait(driver, ShownGName);
		 return guObj.getTextOfElement(ShownGName);
				 
	 }
	
	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.getStringData(row, column);
	}
	
	public String readIntegerData(int row, int column) throws IOException {
		return ExcelReadClass.getIntegerData(row, column);
	}
}
