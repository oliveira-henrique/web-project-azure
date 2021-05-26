package pages;


import core.attachment.Attachment;
import core.driver.DriverManager;
import lombok.extern.log4j.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import support.selenium.Verifications;

@Log4j2
public class CommonPage extends DriverManager implements CommonTestingType {

    private By lblLogo = By.xpath("tricentis_logo");

    private Logger log = LogManager.getLogger(getClass().getName());
	
    @Override
    public boolean isPresent() {
        return  Verifications.verifyElementIsClickable(lblLogo);
    }

    public void acessaAplicacao(){
        getDriver().get(configuration.url());
        attachments.add(new Attachment("png",null,scenario.get()));
        log.info("Acesso a aplicacao efetuado com sucesso");
    }
}
