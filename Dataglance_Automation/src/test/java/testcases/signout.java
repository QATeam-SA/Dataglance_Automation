package testcases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class signout {
	WebDriver driver = Instance.getInstance();
    Properties prop = PropertiesFile.readPropertyFile("signout.properties");
    Logger logger = LogManager.getLogger(Signin.class);
    @Test(priority = 40, enabled = true)
	public void signout1() throws InterruptedException {
    Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("(//img[contains(@src,'assets/emedia/images/user-small.png')])[1]"))).click();

}
}