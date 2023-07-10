package POMScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMCreateProduct {

	public POMCreateProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[contains(@src,'themes/softed/images/btnL3A')]") 
	private WebElement clickOnImgPlusProduct;
	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="(//td[@class='dvtCellLabel'])[11]/following-sibling :: td/img")
	private WebElement addPlusVendorImg; 
	
	

}
