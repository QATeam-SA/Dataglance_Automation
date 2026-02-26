package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class stepactionwithdataentries {

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("stepactionwithdataentries.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	
	@Test(priority = 39, enabled = true)
	public void textdataentry() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath(prop.getProperty("Stepaction1"))
	    ));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    element.sendKeys("1");

	    Thread.sleep(9000); // Optional: use proper waits instead

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Dataentry")))).click();

	    By sourceLocator = By.xpath(prop.getProperty("Text")); // ✅ Avoid using [54] here
	    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

	    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
	    wait.until(ExpectedConditions.visibilityOf(source));

	    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
	    new Actions(driver).dragAndDrop(source, target).perform();
	}



	
	  @Test(priority = 40, enabled = true) public void Textareadataentry() throws
	  InterruptedException { Thread.sleep(6000); WebDriverWait wait = new
	  WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  wait.until(ExpectedConditions.elementToBeClickable(
	  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
	  By sourceLocator = By.xpath(prop.getProperty("TextArea")); 
	    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

	    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
	    wait.until(ExpectedConditions.visibilityOf(source));

	    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
	    new Actions(driver).dragAndDrop(source, target).perform();
	}
	  
	  @Test(priority = 41, enabled = true) public void Numberdataentry() throws
	  InterruptedException {  wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Number")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); }
	  
	  @Test(priority = 42, enabled = true) public void Datedataentry() throws
	  InterruptedException { wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Date")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); }
	  
	  @Test(priority = 43, enabled = true) public void Booleandataentry() throws
	  InterruptedException { wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Boolean")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); }
	  @Test(priority = 44, enabled = true) public void Radiobuttondataentry()
	  throws InterruptedException { wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Radiobutton")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); }
	  @Test(priority = 45, enabled = true) public void Checkboxgroupdataentry()
	  throws InterruptedException { wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Checkboxgroup")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); 
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 1500)"); }
	  
	  @Test(priority = 46, enabled = true) public void Checkboxdataentry() throws
	  InterruptedException { wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Checkbox")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); }
	  
	  @Test(priority = 47, enabled = true) public void Buttondataentry() throws
	  InterruptedException { Thread.sleep(6000); wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("(//div/textarea[@name='header'])[3]"))).click();
	  
			  By sourceLocator = By.xpath(prop.getProperty("Button")); 
			    By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

			    WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(sourceLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
			    wait.until(ExpectedConditions.visibilityOf(source));

			    WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			    new Actions(driver).dragAndDrop(source, target).perform(); 
				/*
				 * private void performDragAndDrop(String string, String string2) { // TODO
				 * Auto-generated method stub
				 */
	  }
	  
	  
	  @Test(priority = 48, enabled = true) public void Dropdowndataentry() throws
	  InterruptedException { Thread.sleep(6000); WebDriverWait wait = new
	  WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
	  By.xpath(prop.getProperty("Dropdown")))); WebElement target =
	  wait.until(ExpectedConditions.visibilityOfElementLocated(
	  By.xpath(prop.getProperty("Stepaction1"))));
	  
	  ((JavascriptExecutor)
	  driver).executeScript("arguments[0].scrollIntoView(true);", source);
	  ((JavascriptExecutor)
	  driver).executeScript("arguments[0].scrollIntoView(true);", target);
	  
	  new Actions(driver) .moveToElement(source).clickAndHold()
	  .moveToElement(target).release().build().perform();
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 500);"); // Scroll down 500 pixels
	  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 500);"); // Scroll down 500 pixels
	  
	  }
	 
	/*
	 * @Test(priority = 49, enabled = true) public void Add() throws
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
	 * 
	 * @Test(priority = 50, enabled = true) public void Dataentry() throws
	 * InterruptedException { try { Thread.sleep(30000);
	 * driver.findElement(By.xpath(prop.getProperty("Dataentry"))).click(); } catch
	 * (Exception e) { logger.error("Error occurred in Dataentry method: ", e);
	 * throw e; } }
	 * 
	 * 
	 * @Test(priority = 51, enabled = true) public void Table() throws
	 * InterruptedException { try { Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("Table"))).click(); } catch
	 * (Exception e) { logger.error("Error occurred in Table method: ", e); throw e;
	 * } }
	 */

	
	
	  @Test(priority = 49, enabled = true)
	  public void Table() throws InterruptedException {
	      // Allow initial page load delay if needed
	      Thread.sleep(6000);

	      // Maximize the window
	      driver.manage().window().maximize();

	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	      // Get locators from properties file
	      By sourceLocator = By.xpath(prop.getProperty("Table"));
	      By targetLocator = By.xpath(prop.getProperty("Stepaction1"));

	      // Scroll to source element
	      WebElement sourceElement = driver.findElement(sourceLocator);
	      ((JavascriptExecutor) driver).executeScript(
	          "arguments[0].scrollIntoView({block: 'center'});", sourceElement);

	      // Scroll to target element
	      WebElement targetElement = driver.findElement(targetLocator);
	      ((JavascriptExecutor) driver).executeScript(
	          "arguments[0].scrollIntoView({block: 'center'});", targetElement);

	      // Wait for both elements to be clickable
	      WebElement source = wait.until(ExpectedConditions.elementToBeClickable(sourceLocator));
	      WebElement target = wait.until(ExpectedConditions.elementToBeClickable(targetLocator));

	      // Validate that target element is within the viewport
	      int windowHeight = driver.manage().window().getSize().getHeight();
	      int targetY = target.getLocation().getY();

	      if (targetY > windowHeight || targetY < 0) {
	          throw new RuntimeException("Target element is out of visible bounds: Y=" + targetY);
	      }

	      // Perform drag-and-drop action
	      new Actions(driver)
	          .moveToElement(source)
	          .clickAndHold()
	          .pause(Duration.ofMillis(300))
	          .moveToElement(target)
	          .pause(Duration.ofMillis(300))
	          .release()
	          .build()
	          .perform();
	  }

	  
	  
	  
	  @Test(priority = 50, enabled = true) public void Column() throws
	  InterruptedException { try { Thread.sleep(6000);
	  driver.findElement(By.xpath(prop.getProperty("Column"))).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Column"))).sendKeys("6"); }
	  catch (Exception e) { logger.error("Error occurred in Column method: ", e);
	  throw e; } }
	  
	  @Test(priority = 51, enabled = true) public void Row() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Row"))).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Row"))).sendKeys("6"); } catch
	  (Exception e) { logger.error("Error occurred in Row method: ", e); throw e; }
	  }
	  
	  @Test(priority = 52, enabled = true) public void Ok() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Ok"))).click(); } catch
	  (Exception e) { logger.error("Error occurred in Ok method: ", e); throw e; }
	  }
	  
	  @Test(priority = 53, enabled = true) public void Columnbutton() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Columnbutton"))).click(); }
	  catch (Exception e) { logger.error("Error occurred in Columnbutton method: ",
	  e); throw e; } }
	  
	/*
	 * @Test(priority = 54, enabled = true) public void Datatypedropdown() throws
	 * InterruptedException { try { Thread.sleep(2000);
	 * driver.findElement(By.xpath(prop.getProperty("column1"))).click();
	 * driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))).click(); }
	 * catch (Exception e) {
	 * logger.error("Error occurred in Datatypedropdown method: ", e); throw e; } }
	 */
	/*
	 * @Test(priority = 55, enabled = true) public void Textdataentry() throws
	 * InterruptedException { try { Thread.sleep(2000); WebElement e
	 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(0); } catch
	 * (Exception e) { logger.error("Error occurred in Textdataentry method: ", e);
	 * throw e; } }
	 * 
	 * @Test(priority = 56, enabled = true) public void Column2() throws
	 * InterruptedException {
	 * 
	 * Thread.sleep(4000);
	 * driver.findElement(By.xpath(prop.getProperty("Column2"))).click();
	 * Thread.sleep(2000); WebElement e
	 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(1);
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 57, enabled = true) public void Datatypedropdown12() throws
	 * InterruptedException { try { Thread.sleep(10000); WebElement e
	 * =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	 * ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(2); } catch
	 * (Exception e) { logger.error("Error occurred in Datatypedropdown1 method: ",
	 * e); throw e; } }
	 */ 
	  @Test(priority = 58, enabled = true) public void Textareadataentry2() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Textareadataentry"))).click();
	  } catch (Exception e) {
	  logger.error("Error occurred in Textareadataentry method: ", e); throw e; } }
	  
	  @Test(priority = 59, enabled = true) public void Column3() throws
	  InterruptedException {
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Column3"))).click();
	  Thread.sleep(2000); WebElement e
	  =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	  ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(2);
	  
	  }
	  
	  
	  
	  @Test(priority = 60, enabled = true) public void Numberdataentry2() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Numberdataentry"))).click(); }
	  catch (Exception e) {
	  logger.error("Error occurred in Numberdataentry method: ", e); throw e; } }
	  
	  
	  
	  @Test(priority = 61, enabled = true) public void Column4() throws
	  InterruptedException { try {
	  driver.findElement(By.xpath(prop.getProperty("Column4"))).click();
	  Thread.sleep(2000); WebElement e
	  =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	  ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(3); } catch
	  (Exception e) { logger.error("Error occurred in Column4 method: ", e); throw
	  e; }}
	  
	  
	  @Test(priority = 62, enabled = true) public void Datatypedropdown2() throws
	  InterruptedException { try { Thread.sleep(7000);WebElement e
	  =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	  ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(3); } catch
	  (Exception e) { logger.error("Error occurred in Datatypedropdown3 method: ",
	  e); throw e; } }
	  
	  @Test(priority = 63, enabled = true) public void Datedataentry2() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Datedataentry"))).click(); }
	  catch (Exception e) {
	  
	  logger.error("Error occurred in Datedataentry method: ", e); throw e; } }
	  
	  
	  
	  @Test(priority = 64, enabled = true) public void Column5() throws
	  InterruptedException { try { Thread.sleep(8000);
	  driver.findElement(By.xpath(prop.getProperty("Column5"))).click(); WebElement
	  e = driver.findElement(By.xpath(prop.getProperty("Datatypedropdown")));
	  Select ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(4); } catch
	  (Exception e) { logger.error("Error occurred in Column5 method: ", e); throw
	  e; }}
	  
	  
	  
	  @Test(priority = 65, enabled = true) public void Datatypedropdown4() throws
	  InterruptedException { try { WebElement e
	  =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	  ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(4); } catch
	  (Exception e) { logger.error("Error occurred in Datatypedropdown4 method: ",
	  e); throw e; }}
	  
	  
	  
	  @Test(priority = 66, enabled = true) public void Datedataentry1() throws
	  InterruptedException { try { Thread.sleep(2000);
	  driver.findElement(By.xpath(prop.getProperty("Column5"))).click();
	  Thread.sleep(2000); WebElement e
	  =driver.findElement(By.xpath(prop.getProperty("Datatypedropdown"))); Select
	  ss = new Select(e); Thread.sleep(2000); ss.selectByIndex(4); } catch
	  (Exception e) { logger.error("Error occurred in Datedataentry method: ", e);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)"); // Scroll down by 500 pixels
	

	  throw e; } }
	  
	  
	  @Test(priority = 67, enabled = true)
	  public void Ok1() throws InterruptedException {
	      try {
	          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	          
	          WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Ok1"))));
	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", okButton);
	          okButton.click();

	          // Scroll after clicking if needed
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          js.executeScript("window.scrollBy(0, 500)");

	      } catch (Exception e) {
	          logger.error("Error occurred in Ok1 method: ", e);
	          throw e;
	      }	  }
	 
	private void waitAndType(String property, String string) {
		// TODO Auto-generated method stub

	}
	// div[@class='col-md-3 col-lg-3-viewProp col-xs-3 col-sm-3 formcomponents pl-0
	// pr-2 MobileDispalyNone ng-tns-c230-0
	// ng-star-inserted']//span[@class='ng-tns-c230-0 btn btn-primary btn-sm
	// btn-block formcomponent drag-copy drag-handle
	// ng-star-inserted'][normalize-space()='Date']
}
