package testcases;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class stepactionwithdataentries {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("stepactionwithdataentries.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	@Test(priority = 39, enabled = true)
	public void section1() throws InterruptedException {
		Thread.sleep(8000); // Consider using WebDriverWait instead of Thread.sleep

	
		driver.findElement(By.xpath(prop.getProperty("Stepaction1"))).sendKeys("123");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("Dataentry"))).click();
		
		Thread.sleep(4000);
		  WebElement source = driver.findElement(By.xpath(prop.getProperty("Text")));
          WebElement target = driver.findElement(By.xpath(prop.getProperty("Stepaction1")));

          // Wait until elements are visible
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOf(source));
          wait.until(ExpectedConditions.visibilityOf(target));

          // Perform drag and drop
          Actions actions = new Actions(driver);
          actions.dragAndDrop(source, target).perform();

          // Optional: check if dropped successfully
          String textAfterDrop = target.getText();
          System.out.println("Target text after drop: " + textAfterDrop);
          Thread.sleep(6000);
          WebElement source1 = driver.findElement(By.xpath(prop.getProperty("TextArea")));
          WebElement target1 = driver.findElement(By.xpath(prop.getProperty("Stepaction1")));
	}
		

	
	private void waitAndType(String property, String string) {
		// TODO Auto-generated method stub

	}
	
}
