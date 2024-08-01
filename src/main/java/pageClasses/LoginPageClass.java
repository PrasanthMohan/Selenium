package pageClasses;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.checkerframework.checker.index.qual.IndexFor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	public LoginPageClass(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement userNameTextBox;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy(id="Registration Desk")
	WebElement registrationDesk;
	
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='logo']//child::img")
	WebElement loginPageLogo;
	
	@FindBy(id="error-message")
	WebElement loginErrorMessage;
	
	@FindBy(xpath="//ul[@id='sessionLocation']//child::li")
	List<WebElement> loginPageSessionLocations;
	
	
	public void login(String username, String password) {
		guObj.typeOnElement(userNameTextBox, username);
		guObj.typeOnElement(userPassword, password);	
		guObj.clickOnAnElement(registrationDesk);
		guObj.clickOnAnElement(loginButton);	
	}
	
	public void loginFailure(String username, String password) {
		guObj.typeOnElement(userNameTextBox, username);
		guObj.typeOnElement(userPassword, password);	
		guObj.clickOnAnElement(registrationDesk);
		guObj.clickOnAnElement(loginButton);	
	}
	
	public String getErrorMessageOnLoginFailure() {
		return guObj.getTextOfElement(loginErrorMessage);
	}
	
	public String getHomePageURL() {
		return guObj.getCurrentPageUrl(driver);
	}
	
	public boolean isLogoDisplayedOrNot() {
		return guObj.isElementDisplayed(loginPageLogo);
	}
	
	public String[] verifyLocationSessions() {
		String loginSessionLocations[]=new String[6];
		int i=0;
		for (WebElement loginPageSessionLocation : loginPageSessionLocations) {
			System.out.println(guObj.getTextOfElement(loginPageSessionLocation));
			loginSessionLocations[i] = guObj.getTextOfElement(loginPageSessionLocation);
			i++;
		}
		return loginSessionLocations;
	}
	
	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.getStringData(row, column);
	}
	
	public String readIntegerData(int row, int column) throws IOException {
		return ExcelReadClass.getIntegerData(row, column);
	}
}
