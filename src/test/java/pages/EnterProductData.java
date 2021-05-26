package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import core.attachment.Attachment;
import core.driver.DriverManager;
import support.dates.DatePicker;
import support.selenium.Action;
import support.selenium.Verifications;

public class EnterProductData extends DriverManager implements CommonTestingType  {

	private By lblMenuEnterProductData = By.xpath("enterproductdata");
	private By txtStartDate = By.id("startdate");
	private By cbbInsuranceSum$ = By.id("insurancesum");
	private By cbbMeritRating = By.id("meritrating");
	private By cbbDamageInsurance = By.id("damageinsurance");
	private By ckbOptionalProductsEuroProtection = By.xpath("//*[@id='EuroProtection']//following-sibling::span");
	private By ckbOptionalProductsLegalDefenseInsurance = By.xpath("//*[@id='LegalDefenseInsurance']//following-sibling::span");
	private By cbbCourtesyCarLegalDefenseInsurance = By.id("courtesycar");	
	private By btnPrev = By.id("preventerinsurancedata");
	private By btnNext = By.id("nextselectpriceoption");

	
    @Override
    public boolean isPresent() {
    	attachments.add(new Attachment("png",null,scenario.get()));
        return Verifications.verifyElementIsVisible(lblMenuEnterProductData) 
        		&& Verifications.verifyElementIsVisible(txtStartDate);
    }
    
    public void insertData(HashMap data) {
    	attachments.add(new Attachment("png",null,scenario.get()));
  		Action.setText(txtStartDate, DatePicker.getDateUpOrDown(60));
  		Action.selectComboOptionByValue(cbbInsuranceSum$, data.get("insurance_sum").toString());
  		Action.selectComboOptionByValue(cbbMeritRating, data.get("merit_rating").toString());
  		Action.selectComboOptionByValue(cbbDamageInsurance, data.get("damage_insurance").toString());
  		Action.clickOnElement(ckbOptionalProductsEuroProtection);
  		Action.selectComboOptionByValue(cbbCourtesyCarLegalDefenseInsurance, data.get("courtesy_carLegal_defenseInsurance").toString());	
  		attachments.add(new Attachment("png",null,scenario.get()));
  		Action.clickOnElement(btnNext);
  	}
}
