package testcases;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @Test
    public void section() throws InterruptedException {
        try {
                 	
        	        // CBP Editor
        	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("CBP_Editor")))).click();

        	        // Section name
        	        waitAndType(prop.getProperty("Section"), "Section1");

        	        // Control & Subsection
        	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Control")))).click();
        	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Subsection")))).click();

        	        // Subsection input
        	        WebElement subsectionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
        	                By.xpath(prop.getProperty("Subsection11"))));
        	        subsectionInput.sendKeys("Subsection1", Keys.TAB);

        	        // Scroll to and click the section element
        	        WebElement sectionElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        	                By.xpath(prop.getProperty("Section"))));
        	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
        	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);

        	        logger.info("Section process completed successfully.");

        	    } catch (Exception e) {
        	        logger.error("Error occurred in section method: ", e);
        	        throw e;  
        	        //Optional: re-throw or handle differently
        	    }
        	

        driver.findElement(By.xpath(prop.getProperty("Section"))).click();

            // Step action
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Stepaction1")))).click();
           waitAndType(prop.getProperty("Stepaction11"), "Stepaction");
           WebElement sectionElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);

           driver.findElement(By.xpath(prop.getProperty("Section"))).click();
           
           // Signature step
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("signaturestep")))).click();
            WebElement signatureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(prop.getProperty("signaturestep1"))));
            signatureInput.sendKeys("signaturestep12", Keys.TAB);
            scrollAndClick(prop.getProperty("Section"));
            WebElement sectionElement1 = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement1);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement1);

           driver.findElement(By.xpath(prop.getProperty("Section"))).click();
            // Step info
            scrollAndClick(prop.getProperty("stepinfo"));
            waitAndType(prop.getProperty("stepinfo1"), "stepinfo12");
            scrollAndClick(prop.getProperty("Section"));
            WebElement sectionElement11 = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement11);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement11);

           driver.findElement(By.xpath(prop.getProperty("Section"))).click();
            // Delay step
            scrollAndClick(prop.getProperty("Delaystep"));
            waitAndType(prop.getProperty("Delaystep1"), "Delaystep12");
            scrollAndClick(prop.getProperty("Section"));
            WebElement sectionElement111 = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement111);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement111);

           driver.findElement(By.xpath(prop.getProperty("Section"))).click();
            // Timed step
           scrollAndClick(prop.getProperty("Timedstep"));
           waitAndType(prop.getProperty("Timedstep1"), "Timedstep12");
           scrollAndClick(prop.getProperty("Section"));
           WebElement sectionElement1111 = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement1111);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement1111);

          driver.findElement(By.xpath(prop.getProperty("Section"))).click();
            // Repeat step - fixed XPath
            String repeatStepXPath = "//span[normalize-space()='Repeat Step' and contains(@class, 'btn') and contains(@class, 'drag-copy')]";
            System.out.println("Looking for XPath: " + repeatStepXPath);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
            scrollAndClick(repeatStepXPath);

           // Repeat step input
            waitAndType(prop.getProperty("Repeatstep1"), "Repeatstep12");

          //  logger.info("✅ Test case executed successfully.");
       //} catch (Exception e) {
        //    logger.error("❌ Test case failed: ", e);
      //     throw e;
            WebElement sectionElement4 = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);

	        driver.findElement(By.xpath(prop.getProperty("Section"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Holdstep"))).click();
	        waitAndType(prop.getProperty("Holdstep1"), "Holdstep12");
	       
	        WebElement sectionElement5 = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath(prop.getProperty("Section"))));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sectionElement);
	      
	        driver.findElement(By.xpath(prop.getProperty("Section"))).click();
	        //driver.findElement(By.xpath(prop.getProperty("Proceduresnippet"))).click();
	        
	        WebElement procBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Proceduresnippet"))));
	        procBtn.click();

	        // Add delay/wait for input to render
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Proceduresnippet1"))));

	        // Now type
	       // waitAndType(prop.getProperty("Proceduresnippet1"), "Proceduresnippet12");
			/*
			 * WebElement sectionElement6 =
			 * wait.until(ExpectedConditions.presenceOfElementLocated(
			 * By.xpath(prop.getProperty("Section")))); ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
			 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			 * sectionElement); 
			 * 
			 */
	        
	        WebElement section = driver.findElement(By.xpath(prop.getProperty("Section")));
	        section.click();
	        section.sendKeys("1");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 0);");

	     //   driver.findElement(By.xpath(prop.getProperty("Section"))).sendKeys(Keys.TAB);
			/*
			 * WebElement ele = driver.findElement(By.xpath(prop.getProperty("Add")));
			 * 
			 * //Creating object of an Actions class Actions action = new Actions(driver);
			 * 
			 * //Performing the mouse hover action on the target element.
			 * action.moveToElement(ele).perform(); Thread.sleep(1000);
			 * driver.findElement(By.
			 * xpath("(////a[contains(@class, 'dropdown-item') and text()='Warning']")).
			 * click();
			 */
	        driver.findElement(By.xpath("(//span[@class='fa fa-caret-down mg-l ng-tns-c229-0'])[4]")).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//a[contains(@class, 'dropdown-item') and text()='Warning']")).click();
        }
   }

