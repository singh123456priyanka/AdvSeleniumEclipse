package POMCampaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class POMCampaignCreation {
	SoftAssert soft = new SoftAssert();

	public POMCampaignCreation(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement createCampPageVal;

@FindBy(id="dtlview_Campaign Name")
private WebElement campNameTxt;



public WebElement getCreateCampPageVal() {
	return createCampPageVal;
}
public WebElement getCampNameTxt() {
	return campNameTxt;
}

 
public void campCreatePageValSoftAssert(String expTitle)
{	String actTitle = createCampPageVal.getText();
	//SoftAssert soft = new SoftAssert();
	soft.assertTrue(actTitle.contains(expTitle),"::Title unmatched::");
}
 
public void campNameTxt(String expData) {
	String actData = campNameTxt.getText();
	soft.assertEquals( actData,expData);	
}

public void doAllAssert() {
	soft.assertAll();
}


}

