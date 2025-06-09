package testcases;

import java.awt.dnd.Autoscroll;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.sl.draw.geom.AdjustHandle;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class Basiccontrol {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Basiccontrol.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// Helper method to scroll and click via JavaScript
	private void scrollAndClick(String xpath) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	// Helper method to wait and type
	private void waitAndType(String xpath, String text) {
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		input.clear();
		input.sendKeys(text);
	}

	@Test(priority = 1, enabled = true)
	public void section() throws InterruptedException {
		try {
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

	}

	@Test(priority = 4, enabled = true)
	public void stepaction() throws InterruptedException {
		Thread.sleep(8000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Stepaction1")))).click();
		waitAndType(prop.getProperty("Stepaction11"), "Step action");

		/*
		 * WebElement sectionElement = wait
		 * .until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(
		 * "Section")))); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
		 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		 * sectionElement); System.out.println("Print successfully");
		 * 
		 * Thread.sleep(5000); WebDriverWait wait1 = new WebDriverWait(driver,
		 * Duration.ofSeconds(30)); WebElement section = wait1
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
		 * "Section")))); section.click();
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//textarea[@id='step1'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2500);

		driver.findElement(By.xpath(prop.getProperty("Section"))).click();
	}

	
	  @Test(priority = 5, enabled = true) public void signaturestep() throws
	  InterruptedException { try { // Signature step
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
	  "signaturestep")))).click();
	  
	  WebElement signatureInput = wait
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
	  getProperty("signaturestep1")))); signatureInput.sendKeys("signaturestep12",
	  Keys.TAB);
	  
	  scrollAndClick(prop.getProperty("Section"));
	  
	  WebElement sectionElement1 = wait
	  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(
	  "Section")))); ((JavascriptExecutor)
	  driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement1);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	  sectionElement1);
	  
	  Thread.sleep(2500);
	  
	  driver.findElement(By.xpath(prop.getProperty("Section"))).click();
	  
	  } catch (Exception e) {
	  logger.error("Error occurred in signaturestep method: ", e); throw e; //
	  } }
	  
	  @Test(priority = 6, enabled = true)
	  public void stepinfo() throws InterruptedException {
	      try {
	          // Step info
	          scrollAndClick(prop.getProperty("stepinfo"));
	          waitAndType(prop.getProperty("stepinfo1"), "stepinfo12");

	          scrollAndClick(prop.getProperty("Section"));

	          WebElement sectionElement11 = wait.until(
	              ExpectedConditions.presenceOfElementLocated(
	                  By.xpath(prop.getProperty("Section"))
	              )
	          );

	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement11);
	          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement11);

	          driver.findElement(By.xpath(prop.getProperty("Section"))).click();

	      } catch (Exception e) {
	          logger.error("Error occurred in stepinfo method: ", e);
	          throw e;
	      }
	  }

	  @Test(priority = 7, enabled = true)
	  public void Delaystep() throws InterruptedException {
	      try {
	          // Delay step
	          scrollAndClick(prop.getProperty("Delaystep"));
	          waitAndType(prop.getProperty("Delaystep1"), "Delaystep12");

	          scrollAndClick(prop.getProperty("Section"));

	          WebElement sectionElement111 = wait.until(
	              ExpectedConditions.presenceOfElementLocated(
	                  By.xpath(prop.getProperty("Section"))
	              )
	          );

	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement111);
	          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement111);

	          driver.findElement(By.xpath(prop.getProperty("Section"))).click();

	      } catch (Exception e) {
	          logger.error("Error occurred in Delaystep method: ", e);
	          throw e;
	      }
	  }


	  @Test(priority = 8, enabled = true) public void Timedstep() throws
	  InterruptedException { try { // Timed step
	  scrollAndClick(prop.getProperty("Timedstep"));
	  waitAndType(prop.getProperty("Timedstep1"), "Timedstep12");
	  
	  scrollAndClick(prop.getProperty("Section"));
	  
	  WebElement sectionElement1111 = wait
	  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(
	  "Section")))); ((JavascriptExecutor)
	  driver).executeScript("arguments[0].scrollIntoView(true);",
	  sectionElement1111); ((JavascriptExecutor)
	  driver).executeScript("arguments[0].click();", sectionElement1111);
	  
	  driver.findElement(By.xpath(prop.getProperty("Section"))).click();
	  
	  } catch (Exception e) { logger.error("Error occurred in Timedstep method: ",
	  e); throw e; } }
	  
	  @Test(priority = 9, enabled = true)
	  public void Repeatstep() throws InterruptedException {
	      try {
	          // Repeat step - fixed XPath
	          String repeatStepXPath = "//span[normalize-space()='Repeat Step' and contains(@class, 'btn') and contains(@class, 'drag-copy')]";
	          System.out.println("Looking for XPath: " + repeatStepXPath);

	          // Scroll and click the repeat step button
	          ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
	          scrollAndClick(repeatStepXPath);

	          // Repeat step input
	          waitAndType(prop.getProperty("Repeatstep1"), "Repeatstep12");

	          // Locate and interact with the Section element
	          WebElement sectionElement = wait.until(
	              ExpectedConditions.presenceOfElementLocated(
	                  By.xpath(prop.getProperty("Section"))
	              )
	          );

	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
	          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);

	          driver.findElement(By.xpath(prop.getProperty("Section"))).click();

	      } catch (Exception e) {
	          logger.error("Error occurred in Repeatstep method: ", e);
	          throw e;
	      }
	  }

	  @Test(priority = 10, enabled = true)
	  public void Holdstep() throws InterruptedException {
	      try {
	          // Click on Holdstep button
	          driver.findElement(By.xpath(prop.getProperty("Holdstep"))).click();

	          // Enter text into Holdstep input
	          waitAndType(prop.getProperty("Holdstep1"), "Holdstep12");

	          // Locate and interact with the Section element
	          WebElement sectionElement = wait.until(
	              ExpectedConditions.presenceOfElementLocated(
	                  By.xpath(prop.getProperty("Section"))
	              )
	          );

	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
	          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);

	          // Final click (possibly redundant if JS click already worked)
	          driver.findElement(By.xpath(prop.getProperty("Section"))).click();

	      } catch (Exception e) {
	          logger.error("Error occurred in Holdstep method: ", e);
	          throw e;
	      }
	  }

	  
	  @Test(priority = 11, enabled = true)
	  public void Proceduresnippet() throws InterruptedException {
	      try {
	          // Wait and click Proceduresnippet button
	          WebElement procBtn = wait.until(
	              ExpectedConditions.elementToBeClickable(
	                  By.xpath(prop.getProperty("Proceduresnippet"))
	              )
	          );
	          procBtn.click();

	          // Wait for input to render
	          wait.until(
	              ExpectedConditions.presenceOfElementLocated(
	                  By.xpath(prop.getProperty("Proceduresnippet1"))
	              )
	          );

	          // Optional: Fill input field
	          waitAndType(prop.getProperty("Proceduresnippet1"), "Proceduresnippet12");

	          // Wait for 25 seconds (consider replacing this with dynamic wait if possible)
	          Thread.sleep(25000);

	          // Locate and click on Section element
	          WebElement sectionElement111 = wait.until(
	              ExpectedConditions.presenceOfElementLocated(
	                  By.xpath(prop.getProperty("Section"))
	              )
	          );

	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement111);
	          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement111);

	          driver.findElement(By.xpath(prop.getProperty("Section"))).click();

	          // Scroll to top
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          js.executeScript("window.scrollTo(0, 0);");

	          // Tab through section (if needed)
	          driver.findElement(By.xpath(prop.getProperty("Section"))).sendKeys(Keys.TAB);

	          // Hover over "Add" element
	          WebElement ele = driver.findElement(By.xpath(prop.getProperty("Add")));
	          Actions action = new Actions(driver);
	          action.moveToElement(ele).perform();

	          // Click on dropdown "Warning" item (corrected XPath)
	          driver.findElement(By.xpath("//a[contains(@class, 'dropdown-item') and text()='Warning']")).click();

	      } catch (Exception e) {
	          logger.error("Error occurred in Proceduresnippet method: ", e);
	          throw e;
	      }
	  }

		/*
		 * @Test(priority = 12, enabled = true) public void Add() throws
		 * InterruptedException { try { WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(30));
		 * 
		 * // Optional: you can remove the Thread.sleep and rely on wait if possible
		 * Thread.sleep(30000);
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
		 * "Add")))).click();
		 * 
		 * } catch (Exception e) { logger.error("Error occurred in Add method: ", e);
		 * throw e; } }
		 */
/*
 * @Test(priority = 13, enabled = true) public void Warning() throws
 * InterruptedException { try { Thread.sleep(25000);
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Warning")))).click(); } catch (Exception e) {
 * logger.error("Error occurred in Warning method: ", e); throw e; } }
 */
/*
 * @Test(priority = 14, enabled = true) public void Caution() throws
 * InterruptedException { try {
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Caution")))).click(); } catch (Exception e) {
 * logger.error("Error occurred in Caution method: ", e); throw e; } }
 */
/*
 * @Test(priority = 15, enabled = true) public void Note() throws
 * InterruptedException { try {
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Note")))).click(); } catch (Exception e) {
 * logger.error("Error occurred in Note method: ", e); throw e; } }
 */
/*
 * @Test(priority = 16, enabled = true) public void Alara() throws
 * InterruptedException { try {
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Alara")))).click(); Thread.sleep(1000); } catch (Exception e) {
 * logger.error("Error occurred in Alara method: ", e); throw e; } }
 */
/*
 * @Test(priority = 17, enabled = true) public void Paragrapgh() throws
 * InterruptedException { try {
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Paragrapgh")))).click(); } catch (Exception e) {
 * logger.error("Error occurred in Paragrapgh method: ", e); throw e; } }
 */
/*
 * @Test(priority = 18, enabled = true) public void Label() throws
 * InterruptedException { try { Thread.sleep(5000);
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Label")))).click(); } catch (Exception e) {
 * logger.error("Error occurred in Label method: ", e); throw e; } }
 */
/*
 * @Test(priority = 19, enabled = true) public void Formula() throws
 * InterruptedException { try { JavascriptExecutor js = (JavascriptExecutor)
 * driver; js.executeScript("window.scrollBy(0,1000)"); Thread.sleep(5000);
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Formula")))).click(); } catch (Exception e) {
 * logger.error("Error occurred in Formula method: ", e); throw e; } }
 */
/*
 * @Test(priority = 20, enabled = true) public void Dataentry() throws
 * InterruptedException { try { Thread.sleep(30000);
 * driver.findElement(By.xpath(prop.getProperty("Dataentry"))).click(); } catch
 * (Exception e) { logger.error("Error occurred in Dataentry method: ", e);
 * throw e; } }
 */
/*
 * @Test(priority = 21, enabled = true) public void Table() throws
 * InterruptedException { try { Thread.sleep(2000);
 * driver.findElement(By.xpath(prop.getProperty("Table"))).click(); } catch
 * (Exception e) { logger.error("Error occurred in Table method: ", e); throw e;
 * } }
 */
	/*
	 * @Test(priority = 22, enabled = true) public void Column() throws
	 * InterruptedException { try {
	 * 
	 * Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Column"))).clear();
	 * Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Column"))).sendKeys("5"); }
	 * catch (Exception e) { logger.error("Error occurred in Column method: ", e);
	 * throw e; } }
	 */
/*
 * @Test(priority = 23, enabled = true) public void Row() throws
 * InterruptedException { try { Thread.sleep(2000);
 * driver.findElement(By.xpath(prop.getProperty("Row"))).clear();
 * Thread.sleep(2000);
 * driver.findElement(By.xpath(prop.getProperty("Row"))).sendKeys("5"); } catch
 * (Exception e) { logger.error("Error occurred in Row method: ", e); throw e; }
 * }
 */
		/*
		 * @Test(priority = 24, enabled = true) public void Ok() throws
		 * InterruptedException { try { Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("Ok"))).click(); } catch
		 * (Exception e) { logger.error("Error occurred in Ok method: ", e); throw e; }
		 * }
		 */
		/*
		 * @Test(priority = 25, enabled = true) public void Columnbutton() throws
		 * InterruptedException { try { Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("Columnbutton"))).click(); }
		 * catch (Exception e) { logger.error("Error occurred in Columnbutton method: ",
		 * e); throw e; } }
		 */
	/*
	 * @Test(priority = 26, enabled = true) public void Datatypedropdown() throws
	 * InterruptedException { try { Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))).click(); }
	 * catch (Exception e) {
	 * logger.error("Error occurred in Datatypedropdown method: ", e); throw e; } }
	 */
/*
 * @Test(priority = 27, enabled = true) public void Textdataentry() throws
 * InterruptedException { try { Thread.sleep(2000); WebElement e
 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(0); } catch
 * (Exception e) { logger.error("Error occurred in Textdataentry method: ", e);
 * throw e; } }
 */
/*
 * @Test(priority = 28, enabled = true) public void Column2() throws
 * InterruptedException {
 * 
 * Thread.sleep(4000);
 * driver.findElement(By.xpath(prop.getProperty("Column2"))).click();
 * Thread.sleep(2000); WebElement e
 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(1);
 * }
 */
	  
		/*
		 * @Test(priority = 29, enabled = true) public void Datatypedropdown12() throws
		 * InterruptedException { try { Thread.sleep(10000); WebElement e
		 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
		 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(2); } catch
		 * (Exception e) { logger.error("Error occurred in Datatypedropdown1 method: ",
		 * e); throw e; } }
		 */
	/*
	 * @Test(priority = 30, enabled = true) public void Textareadataentry() throws
	 * InterruptedException { try { Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Textareadataentry"))).click();
	 * } catch (Exception e) {
	 * logger.error("Error occurred in Textareadataentry method: ", e); throw e; } }
	 */
/*
 * @Test(priority = 31, enabled = true) public void Column3() throws
 * InterruptedException {
 * 
 * Thread.sleep(2000);
 * driver.findElement(By.xpath(prop.getProperty("Column3"))).click();
 * Thread.sleep(2000); WebElement e
 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(2);
 * 
 * }
 */
	  
	  
		/*
		 * @Test(priority = 32, enabled = true) public void Numberdataentry() throws
		 * InterruptedException { try { Thread.sleep(2000);
		 * driver.findElement(By.xpath(prop.getProperty("Numberdataentry"))).click(); }
		 * catch (Exception e) {
		 * logger.error("Error occurred in Numberdataentry method: ", e); throw e; } }
		 */
	  
	  
/*
 * @Test(priority = 33, enabled = true) public void Column4() throws
 * InterruptedException { try {
 * driver.findElement(By.xpath(prop.getProperty("Column4"))).click();
 * Thread.sleep(2000); WebElement e
 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(3); } catch
 * (Exception e) { logger.error("Error occurred in Column4 method: ", e); throw
 * e; }}
 */
	  
/*
 * @Test(priority = 34, enabled = true) public void Datatypedropdown2() throws
 * InterruptedException { try { Thread.sleep(7000);WebElement e
 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(3); } catch
 * (Exception e) { logger.error("Error occurred in Datatypedropdown3 method: ",
 * e); throw e; } }
 */
	  
	  
	  
	/*
	 * @Test(priority = 35, enabled = true) public void Datedataentry() throws
	 * InterruptedException { try { Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Datedataentry"))).click(); }
	 * catch (Exception e) {
	 * 
	 * logger.error("Error occurred in Datedataentry method: ", e); throw e; } }
	 */
	  
	  
/*
 * @Test(priority = 36, enabled = true) public void Column5() throws
 * InterruptedException { try { Thread.sleep(8000);
 * driver.findElement(By.xpath(prop.getProperty("Column5"))).click(); WebElement
 * e = driver.findElement(By.xpath(prop.getProperty("Datatypedropdown")));
 * Select ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(4); } catch
 * (Exception e) { logger.error("Error occurred in Column5 method: ", e); throw
 * e; }}
 */
	  
	  
/*
 * @Test(priority = 38, enabled = true) public void Datatypedropdown4() throws
 * InterruptedException { try { WebElement e
 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(4); } catch
 * (Exception e) { logger.error("Error occurred in Datatypedropdown4 method: ",
 * e); throw e; }}
 */
	  
	  
	/*
	 * @Test(priority = 39, enabled = true) public void Datedataentry1() throws
	 * InterruptedException { try { Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Column5"))).click();
	 * Thread.sleep(2000); WebElement e
	 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(4); } catch
	 * (Exception e) { logger.error("Error occurred in Datedataentry method: ", e);
	 * throw e; } }
	 */
	  
	  
	  
	  
/*
 * @Test(priority = 37, enabled = true) public void Ok1() throws
 * InterruptedException { try { Thread.sleep(2000);
 * driver.findElement(By.xpath(prop.getProperty("Ok1"))).click(); } catch
 * (Exception e) { logger.error("Error occurred in Ok1 method: ", e); throw e; }
 * }
 */
}	  
	 


/*
 * @Test(priority = 35, enabled = true) public void stepaction11() throws
 * InterruptedException { try {
 * driver.findElement(By.xpath(prop.getProperty("Section"))).click();
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
 * "Stepaction1")))).click(); Thread.sleep(5000); driver.findElement(By.
 * xpath("(//button[normalize-space(text())='Data Entry'])[1]")).click();
 * Thread.sleep(5000); //driver.findElement(By.
 * xpath("//span[@data-type='textarea' and contains(text(), 'Text')]"));
 * //driver.findElement(By.
 * xpath("//div[contains(text(), 'Step Action')]/following::div[1]"));
 * WebElement source = driver.findElement(By.
 * xpath("//span[@data-type='textarea' and contains(text(), 'Text')]"));
 * //WebElement target = driver.findElement(By.
 * xpath("//div[contains(text(), 'Step Action')]/following::div[1]"));
 * WebElement target =
 * driver.findElement(By.xpath("//textarea[@placeholder='StepAction HEADER']"));
 * Actions actions = new Actions(driver); actions.clickAndHold(source)
 * .moveToElement(target) .pause(Duration.ofSeconds(1)) .release() .build()
 * .perform(); Thread.sleep(5000); WebElement sourcetextarea =
 * driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'TextArea')]"
 * )); //WebElement target1 = driver.findElement(By.
 * xpath("//div[contains(@class, 'step-action-container')]"));
 * actions.dragAndDrop(sourcetextarea, target).perform(); Thread.sleep(5000);
 * WebElement sourcenumberElement = driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Number')]"
 * )); actions.dragAndDrop(sourcenumberElement, target).perform();
 * Thread.sleep(5000); WebElement sourcedateElement = driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Date')]"
 * )); actions.dragAndDrop(sourcedateElement, target).perform();
 * Thread.sleep(5000); WebElement sourcebooleanElement = driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Boolean')]"
 * )); actions.dragAndDrop(sourcebooleanElement, target).perform();
 * Thread.sleep(5000); WebElement sourcecheckboxElement = driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Check Box')]"
 * )); actions.dragAndDrop(sourcecheckboxElement, target).perform();
 * Thread.sleep(5000); WebElement sourcedropdownElement = driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Drop Down')]"
 * )); actions.dragAndDrop(sourcedropdownElement, target).perform();
 * Thread.sleep(5000); WebElement sourcetableElement = driver.findElement(By.
 * xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Table')]"
 * )); actions.dragAndDrop(sourcetableElement, target).perform();
 * 
 * } catch (Exception e) { logger.error("Error occurred in stepaction method: ",
 * e); throw e; // Optional: re-throw or custom error handling
 * 
 * }
 */

/*
 * ((JavascriptExecutor)
 * driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); By
 * locator = By.
 * xpath("(//button[@class='ng-tns-c229-0 btn btn-block builder-group-button collapsed'])[3]"
 * ); WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
 * .until(ExpectedConditions.elementToBeClickable(locator)); element.click();
 */
/*
 * By buttonLocator = By.xpath("//button[@type='submit']"); WebElement button =
 * wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
 * button.click();
 */
/*
 * Thread.sleep(20000);
 * driver.findElement(By.xpath(prop.getProperty("References"))).click();
 */
