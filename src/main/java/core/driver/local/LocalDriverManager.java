
package core.driver.local;

import core.driver.IDriver;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LocalDriverManager implements IDriver {

	private Logger log = LogManager.getLogger(getClass().getName());
	 
    @Override
    public WebDriver createInstance(String browser) {
         WebDriver driver = null;

        try {
            DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
            Class<?> driverClass = Class.forName(driverManagerType.browserClass());
            WebDriverManager.getInstance(driverManagerType).setup();
            driver = (WebDriver) driverClass.newInstance();
        } catch (IllegalAccessException | ClassNotFoundException e) {
            log.error("The class could not be found", e);
        } catch (InstantiationException e) {
            log.error("Problem during driver instantiation", e);
        }
        return driver;
    }
}
