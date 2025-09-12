package testcases;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;


public class DelayStep {WebDriver driver = Instance.getInstance();
Properties prop = PropertiesFile.readPropertyFile("DelayStep.properties");
Logger logger = LogManager.getLogger(Signin.class);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
@Test(priority = 1, enabled = true)
public void cbpeditor() throws InterruptedException {
   
	Thread.sleep(8000);
	driver.findElement(By.xpath(prop.getProperty("CBPeditor"))).click();
	logger.info("Clicked on CBP Editor");
	
}

@Test(priority = 2, enabled = true)
//public void section() throws InterruptedException {
//Thread.sleep(10000);
//driver.findElement(By.xpath(prop.getProperty("section"))).click();
//logger.info("Clicked on Section");
//@Test(priority = 1, enabled = true)
public void sectionHeaderTest() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

    // Try multiple possible XPaths for Section HEADER
    WebElement sectionHeader = findElementWithFallback(driver, wait,
        "//textarea[@placeholder='Section HEADER']",
        "//textarea[@id='step1']",
        "//textarea[@name='header']",
        "//textarea[contains(@class,'stepSectionStyle')]",
        "//textarea[@data-id='1_s_stephead']"
    );

    sectionHeader.clear();
    sectionHeader.sendKeys("This is a Section Header");
    System.out.println("✅ Successfully entered Section Header");
}

/**
 * Utility method to try multiple XPaths until one succeeds
 */
public WebElement findElementWithFallback(WebDriver driver, WebDriverWait wait, String... xpaths) {
    for (String xpath : xpaths) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            System.out.println("✅ Found element using XPath: " + xpath);
            return element;
        } catch (Exception e) {
            System.out.println("❌ Not found with: " + xpath);
        }
    }
    throw new NoSuchElementException("Element not found with any provided XPath");
}


@Test(priority = 3, enabled = true) public void control()
      throws InterruptedException { Thread.sleep(7000); 
      driver.findElement(By.xpath(prop.getProperty("Control"))).click();
      logger.info("Clicked on Control");
}
      @Test(priority = 4, enabled = true) public void Delay()
		      throws InterruptedException { Thread.sleep(8000); 
		      driver.findElement(By.xpath(prop.getProperty("Delaystep"))).click();
		      logger.info("Clicked on Delay Step");
		      //driver.findElement(By.xpath(prop.getProperty("Delaystep1"))).click();
		      driver.findElement(By.xpath(prop.getProperty("Delaystep1"))).sendKeys("Delaystepaction");
		      logger.info("Entered text into Delay Step action");
		      
      }
      @Test(priority = 5, enabled = true)
      public void signaturestep() 
              throws InterruptedException { Thread.sleep(7000); 
		      driver.findElement(By.xpath(prop.getProperty("signaturestep"))).click();
		      logger.info("Clicked on signature  Step");
		      //driver.findElement(By.xpath(prop.getProperty("signaturestep1"))).click();
		      driver.findElement(By.xpath(prop.getProperty("signaturestep1"))).sendKeys("signature_step");
		      logger.info("Entered text into signature Step action");
		      
      }
		      
		      @Test(priority = 6, enabled = true)
		      public void Holdstep() 
                      throws InterruptedException { Thread.sleep(9000); 
                      //JavascriptExecutor js = (JavascriptExecutor) driver;

                      //js.executeScript("window.scrollBy(0,-500)"); // Scroll up by 500 pixels

                      //driver.findElement(By.xpath(prop.getProperty("Delaystep1"))).click();
                      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
                      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Delaystep1"))));
                      element.click();
                      logger.info("Clicked on Hold Step");
				      driver.findElement(By.xpath(prop.getProperty("Holdstep"))).click();
				      //driver.findElement(By.xpath(prop.getProperty("signaturestep1"))).click();
				      driver.findElement(By.xpath(prop.getProperty("Holdstep1"))).sendKeys("Hold_step");
				      logger.info("Entered text into Hold Step action");
				      Actions actions = new Actions(driver);
				      actions.sendKeys(Keys.PAGE_UP).perform();
				      logger.info("Performed Page Up action");

				      // Wait a moment for scroll to complete
				    

				      // Move mouse and click to ensure proper focus
				      actions.moveByOffset(100, 100).click().perform();
				      logger.info("Clicked to refocus after scroll");
				      
		      }		      

		      @Test(priority = 7, enabled = true) public void label()
				      throws InterruptedException { 
				      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Delaystep1"))));
                      element.click();
				     // WebElement source =
				      //driver.findElement(By.xpath(prop.getProperty("Label"))); WebElement
				      //target = driver.findElement(By.xpath(prop.getProperty("Delaystep1")));
				      //Actions actions = new Actions(driver);
				     // actions.moveToElement(source).clickAndHold().moveByOffset(10,
				      //10).moveToElement(source).release(target).build() .perform();
				      
				      //WebElement labelInput = driver.findElement(By.xpath("label1"));
				      //labelInput.clear();
				      //labelInput.sendKeys("label_1");
				      //driver.findElement(By.xpath(prop.getProperty("label1"))).sendKeys("label_1");
				      //logger.info("Succesfully draged the label to the delay step");
                      WebElement source = driver.findElement(By.xpath(prop.getProperty("Label")));
                      WebElement target = driver.findElement(By.xpath(prop.getProperty("Delaystep1")));

                      Actions actions = new Actions(driver);

                      // Correct drag and drop
                      actions.moveToElement(source)
                             .clickAndHold(source)
                             .moveToElement(target)
                             .release(target)
                             .build()
                             .perform();

                      // Now type into the label input
                      WebElement labelInput = driver.findElement(By.xpath(prop.getProperty("label1")));
                      labelInput.clear();
                      labelInput.sendKeys("label_1");

                      logger.info("✅ Successfully dragged the label to the Delay Step and entered text");

		      }
				      
				      @Test(priority = 8, enabled = true) public void paragraph()
						      throws InterruptedException { 
						      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Delaystep1"))));
		                      element.click();
						      //WebElement source =
						     // driver.findElement(By.xpath(prop.getProperty("Paragraph"))); WebElement
						     // target = driver.findElement(By.xpath(prop.getProperty("Delaystep1")));
						      //Actions actions = new Actions(driver);
						      //actions.moveToElement(source).clickAndHold().moveByOffset(10,
						      //10).moveToElement(source).release(target).build() .perform();
						      
						      //WebElement labelInput = driver.findElement(By.xpath("label1"));
						      //labelInput.clear();
						      //labelInput.sendKeys("Paragraph_1");
						      //driver.findElement(By.xpath(prop.getProperty("Paragraph1"))).sendKeys("Paragraph_1");
						      //logger.info("Succesfully draged the para to the delay step");
		                      WebElement source = driver.findElement(By.xpath(prop.getProperty("Paragraph")));
		                      WebElement target = driver.findElement(By.xpath(prop.getProperty("Delaystep1")));

		                      Actions actions = new Actions(driver);

		                      // Correct drag and drop
		                      actions.moveToElement(source)
		                             .clickAndHold(source)
		                             .moveToElement(target)
		                             .release(target)
		                             .build()
		                             .perform();

		                      // Now type into the label input
		                      WebElement ParaInput = driver.findElement(By.xpath(prop.getProperty("Paragraph1")));
		                      ParaInput.clear();
		                      ParaInput.sendKeys("Paragraph-Delay step");

		                      logger.info("✅ Successfully dragged the Para to the Delay Step and entered text");   
				      }
						      

}
