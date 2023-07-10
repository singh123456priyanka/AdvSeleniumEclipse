package POMOrganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Initialization
	//Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	@FindBy(name="user_password")
	private WebElement passwordTextField;	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	//Getter methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
		
	//Buisness logics
	public void loginApp(String username, String password) throws InterruptedException {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);
	}
	
	
	

}
