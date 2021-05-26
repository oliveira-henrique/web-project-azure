package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import core.attachment.Attachment;
import core.driver.DriverManager;
import support.selenium.Action;
import support.selenium.Verifications;

public class EnterInsurantData extends DriverManager implements CommonTestingType  {
	
	private By lblMenuEnterInsurantData = By.xpath("enterinsurantdata");
	private By txtFirstName = By.id("firstname");
	private By txtLastName = By.id("lastname");
	private By txtDateOfBirth = By.id("birthdate");
	private By ckbGenderMale = By.xpath("//*[@id='gendermale']//following-sibling::span");
	private By ckbGenderFemale = By.xpath("//*[@id='genderfemale']//following-sibling::span");
	private By txtStreetAddress = By.id("streetaddress");
	private By cbbCountry = By.id("country");
	private By txtZipCode = By.id("zipcode");
	private By txtCity = By.id("city");
	private By cbbOccupation = By.id("occupation");
	private By ckbHobbiesSpeeding = By.id("//*[@id='speeding']//following-sibling::span");
	private By ckbHobbiesBungeeJumping = By.id("//*[@id='bungeejumping']//following-sibling::span");
	private By ckbHobbiesCliffDiving = By.xpath("//*[@id='cliffdiving']//following-sibling::span");
	private By ckbHobbiesSkydiving = By.id("//*[@id='skydiving']//following-sibling::span");
	private By ckbHobbiesOther = By.id("//*[@id='other']//following-sibling::span");
	private By txtWebsite = By.id("website");
	private By txtPicture = By.id("picture");
	private By btnNextEnterProductData = By.id("nextenterproductdata");
	private By btnPrevEnterVehicleData = By.id("preventervehicledata");
	
    @Override
    public boolean isPresent() {
        attachments.add(new Attachment("png",null,scenario.get()));
        return Verifications.verifyElementIsVisible(lblMenuEnterInsurantData) 
        		&& Verifications.verifyElementIsVisible(txtFirstName);
    }
    
    public void insertData(HashMap data) {
    	attachments.add(new Attachment("png",null,scenario.get()));
		Action.setText(txtFirstName, data.get("first_name").toString());
		Action.setText(txtLastName, data.get("last_name").toString());
		Action.setText(txtDateOfBirth, data.get("date_of_birth").toString());
		if(data.get("gender").toString().contentEquals("Male"))
			Action.clickOnElement(ckbGenderMale);
		else if(data.get("gender").toString().contentEquals("Female"))
			Action.clickOnElement(ckbGenderFemale);
		Action.setText(txtStreetAddress, data.get("street_address").toString());
		Action.selectComboOptionByValue(cbbCountry, data.get("country").toString());
		Action.setText(txtZipCode, data.get("zip_code").toString());
		Action.setText(txtCity, data.get("city").toString());
		Action.selectComboOptionByValue(cbbOccupation, data.get("occupation").toString());
		if(data.get("hobbies").toString().contentEquals("Speeding"))
			Action.clickOnElement(ckbHobbiesSpeeding);
		else if(data.get("hobbies").toString().contentEquals("Bungee Jumping"))
			Action.clickOnElement(ckbHobbiesBungeeJumping);
		else if(data.get("hobbies").toString().contentEquals("Cliff Diving"))
			Action.clickOnElement(ckbHobbiesCliffDiving);
		else if(data.get("hobbies").toString().contentEquals("Skydiving"))
			Action.clickOnElement(ckbHobbiesSkydiving);
		else if(data.get("hobbies").toString().contentEquals("Other"))
			Action.clickOnElement(ckbHobbiesOther);
		Action.setText(txtWebsite, data.get("website").toString());
		Action.setText(txtPicture, data.get("picture").toString());
		attachments.add(new Attachment("png",null,scenario.get()));
		Action.clickOnElement(btnNextEnterProductData);
	}
}
