package POMOrganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class HomePage {
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(xpath="//a[text()='Organizations'][1]")
	private WebElement organizationButton;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreButton;
	
	@FindBy(xpath="//a[@class='drop_downnew' and text()='Campaigns']")
	private WebElement campaignButton;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productButton;
	
	@FindBy(xpath="//td[@class=\"small\"]//td/following-sibling::td/img[@src='themes/softed/images/user.PNG']")
	private WebElement gotoimgforsignoutButton;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutButton;
	
	@FindBy (xpath="//a[contains(@href,'index.php?module=Co')]")
	private WebElement contactButton;
	
	
	//getter methods
	public WebElement getOrganizationButton() {
		return organizationButton;
	}
	public WebElement getMoreButton() {
		return moreButton;
	}
	public WebElement getCampaignButton() {
		return campaignButton;
	}
	public WebElement getProductButton() {
		return productButton;
	}
	public WebElement getGotoimgforsignoutButton() {
		return gotoimgforsignoutButton;
	}
	public WebElement getSignoutButton() {
		return signoutButton;
	}
	public WebElement getContactButton() {
		return contactButton;
	}
	//buisness logics
	public void organizationButtonClick() {
		organizationButton.click();
	}
	
	public void moreButtonClick() throws InterruptedException {
	moreButton.click();
	Thread.sleep(2000);

	}
	public void campaignButtonClick() {
		campaignButton.click();
	}
	public void productButtonClick() {
		 productButton.click();
	}
//	public void gotoimgforsignoutButtonClick() {
//	 gotoimgforsignoutButton.click();
//	}
	public void signoutButtonClick(WebDriver driver) {
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.moveMouseTo(driver, gotoimgforsignoutButton);
		signoutButton.click();
	}	
	public void Contact() {
		contactButton.click();
	}
	

}
