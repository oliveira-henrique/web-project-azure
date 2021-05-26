package hooks;

import core.driver.DriverFactory;
import core.driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@Log4j2
public class Hook extends DriverManager {

	
    @Before
    public void init(Scenario scenario) {
    	
		Logger log = LogManager.getLogger(Hook.class); 
        DriverManager.setScenario(scenario);
        attachments = new ArrayList<>();
		log.info(String.format("TESTE INICIADO: %s",scenario.getName())); 
        DriverManager.startTime();
        ConfigFactory.setProperty("env", System.getProperty("env"));
        WebDriver driver = DriverFactory.createInstance(System.getProperty("browser"));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);

    }

    @After
    public void end(Scenario scenario){
		Logger log = LogManager.getLogger(Hook.class); 
        DriverManager.quit(scenario);

		
		log.info(String.format("TESTE FINALIZADO: %s",scenario.getName()));
		log.info(String.format("TESTE STATUS: %s",scenario.getStatus()));
		 
    }

}









