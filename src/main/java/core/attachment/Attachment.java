package core.attachment;


import core.controller.CucumberController;
import core.config.Configuration;
import cucumber.api.Scenario;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import support.dates.DatePicker;
import support.selenium.Action;
import core.driver.DriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
@Getter
@Setter
public class Attachment {

    private String stream;
    private String fileName;
    private String comment;
    private String attachmentType;
    private File imageFile;
    private FileWriter textFile;
    private String pathName;

    public static final Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
    private static Logger log = LogManager.getLogger(Attachment.class);
    
    public Attachment(String extension,String comment,Scenario scenario) {
        CucumberController tagsCucumber = new CucumberController(scenario);
        TakesScreenshot screenshot = ((TakesScreenshot) DriverManager.getDriver());
        this.imageFile = screenshot.getScreenshotAs(OutputType.FILE);
        this.stream = screenshot.getScreenshotAs(OutputType.BASE64);
        this.fileName = String.format("Evidence_%s_%s.%s",
                DatePicker.getCurrentDate().replace("/", ""),
                DatePicker.getCurrentTime().replace(":", ""), extension);
        this.comment = comment;
        this.attachmentType = "GeneralAttachment";
        try {
            String scenarioId = scenario.getId();
            String featureName = (StringUtils.substringBetween(scenarioId, "features", ".feature"));
                pathName = "C:/qa-testes/evidence" + featureName + "/"
                        + tagsCucumber.getTestId()
                        + "/" + DriverManager.getStartTime() +"/";
                FileUtils.copyFile(this.imageFile, new File(pathName + fileName));
                log.info("Evidência salva no diretório local: " + pathName);
        } catch (IOException e) {
            log.info("Não foi possível salva evidência em diretório local");
        }
    }

    public Attachment(String extension,String value,String comment,Scenario scenario)  {
        CucumberController tagsCucumber = new CucumberController(scenario);
        this.stream = new String(Base64.encodeBase64(value.getBytes()));
        this.fileName = String.format("Evidence_%s_%s.%s",
                DatePicker.getCurrentDate().replace("/",""),
                DatePicker.getCurrentTime().replace(":",""),extension);
        this.comment = comment;
        this.attachmentType = "GeneralAttachment";
        try {
            String scenarioId = scenario.getId();
            String featureName = StringUtils.substringBetween(scenarioId, "features", ".feature");
                pathName = "C:/qa-testes/evidence" + featureName + "/"
                        + tagsCucumber.getTestId()
                        + "/" + DriverManager.getStartTime() +"/";
                this.textFile = new FileWriter(new File(pathName + fileName));
                this.textFile.write(new String(value.getBytes()));
                this.textFile.close();
                log.info("Evidência salva no diretório local: " + pathName);
        } catch(Exception e) {
            log.info("Não foi possível salva evidência em diretório local");
        }
    }
}
