
package core.driver;

import core.attachment.Attachment;
import core.config.Configuration;
import cucumber.api.Scenario;
import support.dates.DatePicker;

import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Collection;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
    public static final Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
    public static Collection<Attachment> attachments;
    private static String startTime;
    
    public static String getStartTime() {
		return startTime;
	}

	public static WebDriver getDriver() {
        return  driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static ThreadLocal<Scenario> getScenario() {
        return scenario;

    }

    public static void setScenario(Scenario scenario) {
        DriverManager.scenario.set(scenario);
    }

    public static void quit(Scenario scenario) {
        if (scenario.isFailed()) {
            attachments.add(new Attachment("png","Evidencia do erro apresentado na execução", scenario));
        }
        DriverManager.driver.get().quit();
    }

    public static String getInfo() {
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatform().toString();
        String version = cap.getVersion();
        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
    }
    
    public static void startTime() {
        DatePicker.setTypeOfFormat("yyyy-MM-dd HH-mm");
        startTime = String.format("%s_%s",
                DatePicker.getCurrentDate().replace("/", ""),
                DatePicker.getCurrentTime().replace(":", ""));
        DatePicker.setTypeOfFormat("dd/MM/yyyy HH:mm:ss");
    }
}
