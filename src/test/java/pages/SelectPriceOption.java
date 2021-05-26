package pages;

import org.openqa.selenium.By;

import core.attachment.Attachment;
import core.driver.DriverManager;
import support.selenium.Action;
import support.selenium.Verifications;

public class SelectPriceOption extends DriverManager implements CommonTestingType {

	private By lblMenuSelectPriceOption = By.id("selectpriceoption");
	private By ckbSelectOption = By.xpath("//*[@id='selectplatinum']//following-sibling::span");
	private By btnNext = By.id("nextsendquote");
	
    @Override
    public boolean isPresent() {
    	attachments.add(new Attachment("png",null,scenario.get()));
        return Verifications.verifyElementIsVisible(lblMenuSelectPriceOption) 
        		&& Verifications.verifyElementIsVisible(ckbSelectOption);
    }
    
    
    public void insertData() {
    	attachments.add(new Attachment("png",null,scenario.get()));
  		Action.clickOnElement(ckbSelectOption);
  		attachments.add(new Attachment("png",null,scenario.get()));
  		Action.clickOnElement(btnNext);
  	}
}
