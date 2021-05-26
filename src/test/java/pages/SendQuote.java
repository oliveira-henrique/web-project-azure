package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import core.attachment.Attachment;
import core.driver.DriverManager;
import support.selenium.Action;
import support.selenium.Verifications;

public class SendQuote  extends DriverManager implements CommonTestingType {
	
	private By lblMenuSendQuote = By.id("sendquote");
	private By txtEMail = By.id("email");
	private By txtPhone = By.id("phone");
	private By txtUsername = By.id("username");
	private By txtPassword = By.id("password");
	private By txtConfirmPassword = By.id("confirmpassword");
	private By txtComments = By.id("Comments");
	private By btnSend = By.id("sendemail");
	private By btnPrev = By.id("prevselectpriceoption");
	
	private By lblIconSuccess = By.xpath("//*[@class='sweet-alert showSweetAlert visible']//*[@class='sa-icon sa-success animate']");
	private By lblSendMensage = By.xpath("//*[@class='sweet-alert showSweetAlert visible']//h2");
	
	
    @Override
    public boolean isPresent() {
    	attachments.add(new Attachment("png",null,scenario.get()));
        return Verifications.verifyElementIsVisible(lblMenuSendQuote) 
        		&& Verifications.verifyElementIsVisible(txtEMail);
    }
    
    public void insertData(HashMap<?, ?> data) {
    	attachments.add(new Attachment("png",null,scenario.get()));
  		Action.setText(txtEMail, data.get("email").toString());
  		Action.setText(txtPhone, data.get("phone").toString());
  		Action.setText(txtUsername, data.get("username").toString());
  		Action.setText(txtPassword, data.get("password").toString());
  		Action.setText(txtConfirmPassword, data.get("confirm_password").toString());
  		Action.setText(txtComments, data.get("comments").toString());
  		attachments.add(new Attachment("png",null,scenario.get()));
  		Action.clickOnElement(btnSend);
  	}
    
    public boolean validaIconSuccess() {
    	attachments.add(new Attachment("png",null,scenario.get()));
    	return Verifications.verifyElementExists(lblIconSuccess);
  	}
    
    public String validaMensageSuccess() {
    	attachments.add(new Attachment("png",null,scenario.get()));
    	return Action.getText(lblSendMensage);
  	}
}
