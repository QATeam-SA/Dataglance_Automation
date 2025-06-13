package testcases;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class executor {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("executor.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	@Test(priority = 1, enabled = true)
	public void Closebutton() throws InterruptedException, Exception {
	Thread.sleep(9000);
	
	driver.findElement(By.xpath(prop.getProperty("Close"))).click();

}}
