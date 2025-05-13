package testcases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Signin_Existinguser {

	WebDriver driver = Instance.getInstance();
    Properties prop = PropertiesFile.readPropertyFile("Signin_Existinguser.properties");
    Logger logger = LogManager.getLogger(Signin_Existinguser.class);
	@Test
    public void login() throws InterruptedException {
    	
    	driver.manage().window().maximize();
		driver.get(prop.getProperty("dg_url"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("user_Id"))).sendKeys(prop.getProperty("Enter_UserId"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("Enter_Password"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Login_Button"))).click();
		logger.info("SignIn successfully");
}}
