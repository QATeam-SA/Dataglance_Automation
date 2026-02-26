package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class media {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("media.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	@Test(priority = 1, enabled = true)
	public void mediasingle() throws InterruptedException, AWTException {
	    // Wait for page to load
	    Thread.sleep(8000);

	    // Click on step text area
	    driver.findElement(By.xpath("//textarea[@id='step1']")).click();
	    Thread.sleep(8000);

	    // Navigate through UI
	    driver.findElement(By.xpath(prop.getProperty("Basic"))).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(prop.getProperty("Section2"))).click();
	    Thread.sleep(4000);

	    // Enter text in Section1
	    driver.findElement(By.xpath(prop.getProperty("Section1"))).sendKeys("SectionwithMedia");
	    Thread.sleep(4000);

	    // Click step action button
	    driver.findElement(By.xpath(prop.getProperty("stepaction"))).click();
	    Thread.sleep(4000);

	    // Enter step action text
	    driver.findElement(By.xpath(prop.getProperty("stepaction1"))).sendKeys("Step action");
	    Thread.sleep(13000);

	    // Click to open media upload option
	    driver.findElement(By.xpath(
	        "//body/app-root/app-home/app-cbp/lib-app-formbuild/div/div/div/div[2]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/h5/button"))
	        .click();
	    Thread.sleep(5000);
        WebElement source = driver.findElement(By.xpath(prop.getProperty("mediasingle")));
        WebElement target = driver.findElement(By.xpath(prop.getProperty(
                "stepaction1")));
        Actions actions = new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveByOffset(10, 10).moveToElement(target).release().build()
                .perform();
	    Thread.sleep(5000);

	    // Use Robot to simulate file selection via clipboard
	    Robot rb = new Robot();
	    rb.delay(2000);

	    // Set image file path to system clipboard
	    String imagePath = prop.getProperty("path4"); // Ensure this is an absolute path
	    StringSelection ss = new StringSelection(imagePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	    // Simulate Ctrl+V and Enter
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.delay(1000);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.delay(1000);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	}

	@Test(priority = 3, enabled = true)
	public void mediagallery() throws Exception {
		 driver.findElement(By.xpath(prop.getProperty("Basic"))).click();
		 driver.findElement(By.xpath(prop.getProperty("stepaction2"))).click();
		 driver.findElement(By.xpath(prop.getProperty("stepaction3"))).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement textarea = wait.until(
		     ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='step214']"))
		 );
		 textarea.click();
		 driver.findElement(By.xpath(prop.getProperty("stepaction4"))).sendKeys("stepaction");
		 driver.findElement(By.xpath(
			        "//body/app-root/app-home/app-cbp/lib-app-formbuild/div/div/div/div[2]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/h5/button"))
			        .click();
		 Thread.sleep(5000);
	        WebElement source = driver.findElement(By.xpath(prop.getProperty("mediagallery")));
	        WebElement target = driver.findElement(By.xpath(prop.getProperty(
	                "mediagalleryselect")));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(source).clickAndHold().moveByOffset(10, 10).moveToElement(target).release().build()
	                .perform();

			/*
			 * // Wait until elements are visible WebDriverWait wait1 = new
			 * WebDriverWait(driver, Duration.ofSeconds(90));
			 * wait1.until(ExpectedConditions.visibilityOf(source));
			 * wait1.until(ExpectedConditions.visibilityOf(target));
			 * 
			 * // Perform drag and drop Actions actions1 = new Actions(driver);
			 * actions1.dragAndDrop(source, target).perform();
			 */

//			Thread.sleep(5000);
	//driver.findElement(By.xpath("//input[@class='input-upload']")).click();


			// Avoid Thread.sleep; if needed, use another explicit wait
			Thread.sleep(6000); // Optional, avoid if possible

			WebElement uploadInput = driver.findElement(By.xpath("//input[@class='input-upload']"));
			uploadInput.sendKeys("C:\\Users\\vsrikanth\\Pictures\\\\test.jpeg");
			Thread.sleep(6000);
			WebElement uploadInput1 = driver.findElement(By.xpath("//input[@class='input-upload']"));
			uploadInput.sendKeys("C:\\Users\\vsrikanth\\Pictures\\software.jpg");
			Thread.sleep(5000);
			WebElement uploadInput2 = driver.findElement(By.xpath("//input[@class='input-upload']"));
			uploadInput.sendKeys("C:\\Users\\vsrikanth\\Pictures\\\\jpeg7.jpg");
			Thread.sleep(5000);
			WebElement uploadInput3 = driver.findElement(By.xpath("//input[@class='input-upload']"));
			uploadInput.sendKeys("C:\\Users\\vsrikanth\\Pictures\\\\test.jpeg");
			Robot rb = new Robot();
			rb.delay(2000);

			StringSelection ss = new StringSelection(prop.getProperty("path3"));
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.delay(2000);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			//((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);"); // scroll down
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1000);"); // scroll up

			
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
	}

	
	
	/*
	 * @Test(priority = 3, enabled = true) public void Link() throws
	 * InterruptedException, Exception { Thread.sleep(10000);
	 * 
	 * WebElement source = driver.findElement(By.xpath(prop.getProperty("Link")));
	 * WebElement target =
	 * driver.findElement(By.xpath("//span[@id='cbp_editor_Link']")); // Wait until
	 * elements are visible WebDriverWait wait1 = new WebDriverWait(driver,
	 * Duration.ofSeconds(90));
	 * wait1.until(ExpectedConditions.visibilityOf(source));
	 * wait1.until(ExpectedConditions.visibilityOf(target));
	 * 
	 * // Perform drag and drop Actions actions = new Actions(driver);
	 * actions.dragAndDrop(source, target).perform();
	 * 
	 * }
	 */
	 
	}



