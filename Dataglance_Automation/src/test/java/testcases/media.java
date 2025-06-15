package testcases;

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
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	@Test(priority = 1, enabled = true)
	public void section() throws InterruptedException, Exception {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//textarea[@id='step1']")).click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		
		  driver.findElement(By.xpath(prop.getProperty("Basic"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(prop.getProperty("Section2"))).click();
			Thread.sleep(10000); /*
									 * //Scroll and click the clickable parent (often a button or div) WebElement
									 * sectionSpan = driver .findElement(By.
									 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Section')]/.."
									 * ) // click // parent ); ((JavascriptExecutor)
									 * driver).executeScript("arguments[0].scrollIntoView(true);", sectionSpan);
									 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
									 * sectionSpan);
									 */
			//driver.findElement(By.xpath("//textarea[contains(@class,'form-control stepSectionStyle bordernone customrSpace ng-tns-c233-11 ng-untouched ng-pristine ng-valid ng-star-inserted width-97')]")).sendKeys("SectionwithMedia");

//Wait after clicking before interacting with form
		Thread.sleep(4000);

//Enter text in Section1

		driver.findElement(By.xpath(prop.getProperty("Section1"))).sendKeys("SectionwithMedia");
		Thread.sleep(4000);

//Click on stepaction button
		driver.findElement(By.xpath(prop.getProperty("stepaction"))).click();
		Thread.sleep(4000);

//Enter Stepaction
		driver.findElement(By.xpath(prop.getProperty("stepaction1"))).sendKeys("Step action");
		Thread.sleep(12000);
		driver.findElement(By.xpath(
				"//body[1]/app-root[1]/app-home[1]/app-cbp[1]/lib-app-formbuild[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/h5[1]/button[1]"))
				.click();
		Thread.sleep(4000);
		WebElement source = driver.findElement(By.xpath(prop.getProperty("mediasingle")));
		WebElement target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));

// Wait until elements are visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(source));
		wait.until(ExpectedConditions.visibilityOf(target));

// Perform drag and drop
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

		Thread.sleep(5000);

		Robot rb = new Robot();
		rb.delay(2000);

		StringSelection ss = new StringSelection(prop.getProperty("path4"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/*
	 * @Test(priority = 2, enabled = true) public void media() throws
	 * InterruptedException, Exception { driver.findElement(By.xpath(
	 * "//body[1]/app-root[1]/app-home[1]/app-cbp[1]/lib-app-formbuild[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/h5[1]/button[1]"
	 * )).click(); Thread.sleep(4000); WebElement source =
	 * driver.findElement(By.xpath(prop.getProperty("mediasingle"))); WebElement
	 * target = driver.findElement(By.xpath(prop.getProperty("stepaction1")));
	 * 
	 * // Wait until elements are visible WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOf(source));
	 * wait.until(ExpectedConditions.visibilityOf(target));
	 * 
	 * // Perform drag and drop Actions actions = new Actions(driver);
	 * actions.dragAndDrop(source, target).perform(); Robot rb = new Robot();
	 * rb.delay(2000);
	 * 
	 * StringSelection ss = new StringSelection(prop.getProperty("path3"));
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	 * rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V); rb.delay(2000);
	 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_V);
	 * rb.delay(2000); rb.keyPress(KeyEvent.VK_ENTER);
	 * rb.keyRelease(KeyEvent.VK_ENTER); }
	 */

	@Test(priority = 3, enabled = true)
	public void mediagallery() throws InterruptedException, Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("stepaction1"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(prop.getProperty("Basic"))).click();
		// Click on stepaction button
		driver.findElement(By.xpath(prop.getProperty("stepaction2"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//textarea[@data-id='1_s_stephead'])[12]")).sendKeys("step action");
		//Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement refelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@type,'button')])[7]")));
		refelement.click();
		/*
		 * // Click the button using a more robust locator if possible
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 * 
		 * // Use a better, meaningful XPath WebElement button =
		 * wait.until(ExpectedConditions.elementToBeClickable(
		 * By.xpath("//button[contains(text(), 'Upload')]") // Replace with your
		 * button's text ));
		 * 
		 * // Scroll and click via JS JavascriptExecutor js = (JavascriptExecutor)
		 * driver; js.executeScript("arguments[0].scrollIntoView(true);", button);
		 * Thread.sleep(500);
		 * 
		 * js.executeScript("arguments[0].click();", button);
		 */

		// Wait for the media gallery to be visible
		 WebElement sectionElement1111 = wait
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(
				  "Section")))); ((JavascriptExecutor)
				  driver).executeScript("arguments[0].scrollIntoView(true);",
				  sectionElement1111); ((JavascriptExecutor)
				  driver).executeScript("arguments[0].click();", sectionElement1111);
		Thread.sleep(4000);
		WebElement source = driver.findElement(By.xpath(prop.getProperty("mediagallery")));
		WebElement target = driver.findElement(By.xpath("(//textarea[@name='header'])[12]"));

		// Wait until elements are visible
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait1.until(ExpectedConditions.visibilityOf(source));
		wait1.until(ExpectedConditions.visibilityOf(target));

		// Perform drag and drop
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

//		Thread.sleep(5000);
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
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);"); // scroll up

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


