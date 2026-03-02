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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class sectionwithmedia {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("sectionwithmedia.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
	@Test(priority = 4, enabled = true)
	public void stepaction() throws InterruptedException, AWTException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//td[@class='notSelectedField ng-star-inserted selectedCol']")).click();
		Thread.sleep(5000);
        WebElement source = driver.findElement(By.xpath(prop.getProperty("mediasingle")));
        WebElement target = driver.findElement(By.xpath(prop.getProperty(
                "section")));
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
	
}
