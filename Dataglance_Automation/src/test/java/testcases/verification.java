package testcases;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class verification {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("verification.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	@Test(priority = 1, enabled = true)
	public void verification() throws InterruptedException, Exception {
	Thread.sleep(6000);
	driver.findElement(By.xpath(prop.getProperty("Basic"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("Section2"))).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath(prop.getProperty("Section3"))).sendKeys("Verification");
	Thread.sleep(4000);
	driver.findElement(By.xpath(prop.getProperty("stepaction"))).click();
	Thread.sleep(6000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	WebElement textArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='step239']")));
	textArea.sendKeys("Verification");
	Thread.sleep(6000);
	driver.findElement(By.xpath(prop.getProperty("Verification1"))).click();
	/*
	 * // Wait and click on the expand/collapse button WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(30)); By buttonLocator = By.
	 * xpath("(//div/h5/button[@class='ng-tns-c231-0 btn btn-block builder-group-button collapsed'])[4]"
	 * );
	 * wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();
	 * 
	 * // Log element properties WebElement element =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
	 * getProperty("Verification1")))); System.out.println("Displayed: " +
	 * element.isDisplayed()); System.out.println("Enabled: " +
	 * element.isEnabled()); System.out.println("Text: " + element.getText());
	 */
	Thread.sleep(6000);
	WebElement source = driver.findElement(By.xpath(prop.getProperty("independent")));
	WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

//Wait until elements are visible
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOf(source));
	wait.until(ExpectedConditions.visibilityOf(target));

//Perform drag and drop
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();
	}
	@Test(priority = 2, enabled = true)
	public void concurrentverification() throws InterruptedException, Exception {
	Thread.sleep(2000);
	Thread.sleep(4000);
	WebElement source = driver.findElement(By.xpath(prop.getProperty("concurrent")));
	WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

//Wait until elements are visible
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(source));
	wait.until(ExpectedConditions.visibilityOf(target));

//Perform drag and drop
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();

}
	@Test(priority = 3, enabled = true)
	public void QAverification() throws InterruptedException, Exception {
	Thread.sleep(2000);
	Thread.sleep(4000);
	WebElement source = driver.findElement(By.xpath(prop.getProperty("QA")));
	WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

//Wait until elements are visible
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(source));
	wait.until(ExpectedConditions.visibilityOf(target));

//Perform drag and drop
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();

}
	@Test(priority = 4, enabled = true)
	public void peerverification() throws InterruptedException, Exception {
	Thread.sleep(2000);
	Thread.sleep(4000);
	WebElement source = driver.findElement(By.xpath(prop.getProperty("peer")));
	WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

//Wait until elements are visible
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(source));
	wait.until(ExpectedConditions.visibilityOf(target));

//Perform drag and drop
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();

}
	@Test(priority = 5, enabled = true)
	public void signatureverification() throws InterruptedException, Exception {
	Thread.sleep(2000);
	Thread.sleep(4000);
	WebElement source = driver.findElement(By.xpath(prop.getProperty("signature")));
	WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

//Wait until elements are visible
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(source));
	wait.until(ExpectedConditions.visibilityOf(target));

//Perform drag and drop
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();

}
	@Test(priority = 6, enabled = true)
	public void initialverification() throws InterruptedException, Exception {
	Thread.sleep(2000);
	Thread.sleep(4000);
	WebElement source = driver.findElement(By.xpath(prop.getProperty("initial")));
	WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

//Wait until elements are visible
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOf(source));
	wait.until(ExpectedConditions.visibilityOf(target));

//Perform drag and drop
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();
	Thread.sleep(2000);

	driver.findElement(By.xpath(prop.getProperty("Repeatstep"))).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath(prop.getProperty("Repeat"))).sendKeys("2");
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("preview"))).click();
}
	
	
}
