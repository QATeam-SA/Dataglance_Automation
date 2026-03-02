package testcases;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Signaturestep {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Signaturestep.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// Helper method to scroll and click via JavaScript
	private void scrollAndClick(String xpath) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	// Enhanced helper method
	private void waitAndType(String xpath, String text) {
	    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	    // Scroll into view before typing
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);

	    input.clear(); // Optional: clear before typing
	    input.sendKeys(text);
	}

	@Test(priority = 1, enabled = true)
	public void section() throws InterruptedException {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("CBP_Editor")))).click();

			Thread.sleep(2000);
			waitAndType(prop.getProperty("Section"), "Section1");
		} catch (Exception e) {
			e.printStackTrace(); // or handle the exception as needed
		}
	}

	// Control & Subsection
	@Test(priority = 2, enabled = true)
	public void control() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Control")))).click();
		} catch (Exception e) {
			e.printStackTrace(); // You can replace this with your custom error handling
		}
	}

	@Test(priority = 3, enabled = true)

	public void subsection() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Subsection")))).click();

		// Subsection input
		WebElement subsectionInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Subsection11"))));
		subsectionInput.sendKeys("Subsection1", Keys.TAB);

		// Scroll to and click the section element
		WebElement sectionElement = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Section"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);

		logger.info("Section process completed successfully.");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//textarea[@id='step1'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2500);
		
		driver.findElement(By.xpath(prop.getProperty("Section"))).click();
		driver.findElement(By.xpath(prop.getProperty("Signaturestep"))).click();
		driver.findElement(By.xpath(prop.getProperty("sign"))).sendKeys("Signature step");
		   By sourceLocator = By.xpath(prop.getProperty("Label")); // ✅ Avoid using [54] here
		    By targetLocator = By.xpath(prop.getProperty("sign"));

		    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
		    wait.until(ExpectedConditions.visibilityOf(source));

		    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
		    new Actions(driver).dragAndDrop(source, target).perform();

	}

}
