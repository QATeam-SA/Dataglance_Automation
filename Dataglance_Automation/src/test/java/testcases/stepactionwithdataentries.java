package testcases;

import java.time.Duration;
import java.util.List;
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

public class stepactionwithdataentries{

	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("stepactionwithdataentries.properties");
	Logger logger = LogManager.getLogger(Basiccontrol.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@Test(priority = 39, enabled = true)
	public void section1() throws InterruptedException {
		Thread.sleep(8000);  // Consider using WebDriverWait instead of Thread.sleep

		/*
		 * String xpath = prop.getProperty("Stepaction1");
		 * System.out.println("Using XPath: " + xpath);
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * WebElement element =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		 * element.click();
		 */
		driver.findElement(By.xpath(prop.getProperty("Stepaction1"))).sendKeys("123");
		Thread.sleep(10000);
        driver.findElement(By.xpath(prop.getProperty("Dataentry"))).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");  // Scroll down 500 pixels

        
		/*
		 * WebElement target =
		 * driver.findElement(By.xpath(prop.getProperty("Stepaction1"))); WebElement
		 * source = null; source =
		 * driver.findElement(By.xpath(prop.getProperty("Text"))); Actions actions = new
		 * Actions(driver);
		 * 
		 * actions .clickAndHold(source) .moveToElement(target) .release() .build()
		 * .perform();
		 */
      
        
        
        
        
    
        WebElement source =wait
	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-type='textarea' and contains(text(), 'Text')]")));
       
        //WebElement target = driver.findElement(By.xpath("//div[contains(text(), 'Step Action')]/following::div[1]"));
        WebElement target = driver.findElement(By.xpath("//textarea[@placeholder='StepAction HEADER']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source)
               .moveToElement(target)
               .pause(Duration.ofSeconds(1)) 
               .release()
               .build()
               .perform();
      
        
        
        Thread.sleep(10000);
        WebElement sourcetextarea = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'TextArea')]"));
        //WebElement target1 = driver.findElement(By.xpath("//div[contains(@class, 'step-action-container')]"));
        actions.dragAndDrop(sourcetextarea, target).perform();
        Thread.sleep(5000);
        WebElement sourcenumberElement = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Number')]"));
        actions.dragAndDrop(sourcenumberElement, target).perform();
        Thread.sleep(5000);
        WebElement sourcedateElement = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Date')]"));
        actions.dragAndDrop(sourcedateElement, target).perform();
        Thread.sleep(5000);
        WebElement sourcebooleanElement = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Boolean')]"));
        actions.dragAndDrop(sourcebooleanElement, target).perform();
        Thread.sleep(5000);
        WebElement sourcecheckboxElement = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Check Box')]"));
        actions.dragAndDrop(sourcecheckboxElement, target).perform();
        Thread.sleep(5000);
        WebElement sourcedropdownElement = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Drop Down')]"));
        actions.dragAndDrop(sourcedropdownElement, target).perform();
        Thread.sleep(5000);
        WebElement sourcetableElement = driver.findElement(By.xpath("//span[contains(@class, 'formcomponent') and contains(text(), 'Table')]"));
        actions.dragAndDrop(sourcetableElement, target).perform();
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
		 * "Stepaction1")))).click();
		 */
		/*
		 * Thread.sleep(8000);
		 * driver.findElement(By.xpath(prop.getProperty("Section"))).click();
		 * Thread.sleep(10000);
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
		 * "Section2")))).sendKeys("Section1");
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollTo(0, 0);");
		 * 
		 * Thread.sleep(5000); driver.findElement(By.xpath(prop.
		 * getProperty("//span[contains(text(), 'Step Action')]"))).click();
		 */
/*//
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
 * WebElement element =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.
 * getProperty("Section2")))); element.click();
 */
	    	   }
	

	 
	    

	
	/*
	 * @Test(priority = 40, enabled = true) public void stepaction() throws
	 * InterruptedException { Thread.sleep(8000);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(
	 * "Stepaction1")))).click(); waitAndType(prop.getProperty("Stepaction11"),
	 * "Stepaction"); JavascriptExecutor js = (JavascriptExecutor) driver;
	 * WebElement element =
	 * driver.findElement(By.xpath("(//textarea[@id='step1'])[1]"));
	 * js.executeScript("arguments[0].scrollIntoView(true);", element);
	 * element.click(); Thread.sleep(2500);
	 */
	






	private void waitAndType(String property, String string) {
		// TODO Auto-generated method stub
		
	}
}


