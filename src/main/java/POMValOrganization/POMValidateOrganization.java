package POMValOrganization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class POMValidateOrganization {

	public POMValidateOrganization(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement valOrgPage;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement valOrgtxt;
	
	@FindBy(id="dtlview_Phone")
	private WebElement valPhntxt;
	
	@FindBy(id="dtlview_Email")
	private WebElement valEmailtxt;


	public WebElement getValPhntxt() {
		return valPhntxt;
	}

	public WebElement getValEmailtxt() {
		return valEmailtxt;
	}

	public WebElement getValOrgPage() {
		return valOrgPage;
	}
	
	public WebElement getValOrgtxt() {
		return valOrgtxt;
	}
	
	//buisness Logics
	public void assertOrgtextbox(String expData) {
		String actData = valOrgtxt.getText();
		Assert.assertEquals(actData, expData);
		
	}
	public void assertPhntextbox(String expData) {
	String actData = valPhntxt.getText();
	Assert.assertEquals(actData, expData);

		}
	public void assertEmailtxtbox(String expData) {
	
		String actData = valEmailtxt.getText();
		Assert.assertEquals(actData, expData);

	}


}
