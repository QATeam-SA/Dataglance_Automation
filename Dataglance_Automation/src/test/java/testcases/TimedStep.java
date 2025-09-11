package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.Robot;


import base.Instance;
import base.PropertiesFile;
public class TimedStep {
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Timedstep.properties");
	Logger logger = LogManager.getLogger(Signin.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	

@Test(priority = 1, enabled = true)
public void cbpeditor() throws InterruptedException {
 
	Thread.sleep(10000);
	driver.findElement(By.xpath(prop.getProperty("CBPeditor"))).click();
	
	logger.info("Clicking on cbpeditor module.");
}
@Test(priority = 2, enabled = true)
public void section() throws InterruptedException {
	//Thread.sleep(10000);
//driver.findElement(By.xpath(prop.getProperty("section"))).click();
	
	WebElement sectionElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("section")))
	    );
	logger.info("Clicking on section element.");
}
@Test(priority = 3, enabled = true) 
public void control() throws InterruptedException 
{ 
	WebElement controlElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Control")))
	    );
    controlElement.click();
}
@Test(priority = 4, enabled = true)
public void Timedstep() throws InterruptedException {
      
WebElement TimedstepElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Timedstep"))));
TimedstepElement.click();
logger.info("Clicked on timedstep element.");
WebElement Timedstep1Element = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Timedstep1"))));
Timedstep1Element.sendKeys("Timedstep_1");
logger.info("sendkeys to timedstep");
    
}
@Test(priority = 5, enabled = true)
public void stepaction() 
	 throws InterruptedException   {
//driver.findElement(By.xpath(prop.getProperty("stepaction"))).click();
        WebElement stepactionElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("stepaction"))));
stepactionElement.click();
logger.info("Clicking on stepaction element.");

}

@Test(priority = 6, enabled = true)
public void signaturestep() 
	 throws InterruptedException   {
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep1"))));
	element.click();
	logger.info("Clicking on timedstep element.");
	 WebElement signatureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("signaturestep")))
		    );
	 signatureElement.click();
		logger.info("Clicking on signaturestep element.");
}
     @Test(priority = 7, enabled = true)
     public void StepInfo() 
     	 throws InterruptedException   {
    	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep1"))));
    		element.click();
    		
    		logger.info("selecting on timed step");
    		
		WebElement stepinfoElement = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Stepinfo")))
		    );
		stepinfoElement.click();
		logger.info("Clicking on stepinfo element.");
     }
          @Test(priority = 8, enabled = true)
          public void Holdstep() 
          	 throws InterruptedException   {
        	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep1"))));
         	element.click();
        	logger.info("Clicking on timedstep element.");
        	 WebElement HoldstepElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Holdstep")))
        		    );
        	 HoldstepElement.click();
        		logger.info("Clicking on Holdstep element.");
          	 
          	
          }
               
           @Test(priority = 9, enabled = true)
                   public void testDragAndDropWarningToTimeStep1() 
                		   throws InterruptedException  {
        	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep1"))));
            	element.click();
           	logger.info("Clicking on timedstep element.");
        	   
        	   WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
        		   
                               By.xpath(prop.getProperty("Warning"))));
                       
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));
                       
                       logger.info("testDragAndDropWarningToTimeStep1");
                       
                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();
                       logger.info("testDragAndDropWarningToTimeStep1 completed");
               }
                   @Test(priority = 10, enabled = true)
                   public void testDragAndDropCautionToTimeStep1() 
                		   throws InterruptedException  {
                       WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Caution"))));
                       
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));
                       
                       logger.info("testDragAndDropCautionToTimeStep1");
                       
                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();
                       logger.info("testDragAndDropCautionToTimeStep1 completed");
               }
                   
                   @Test(priority = 11, enabled = true)
                   public void testDragAndDropNoteToTimeStep1() 
                		   throws InterruptedException  {
                       WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Note"))));
                       
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));
                       
                       logger.info("testDragAndDropNoteToTimeStep1");
                       
                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();
                       
                       logger.info("testDragAndDropNoteToTimeStep1 completed");
}
                   @Test(priority = 12, enabled = true)
                   public void testDragAndDropAlaraToTimeStep1() 
                		   throws InterruptedException  {
                       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

                       WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Alara"))));
                       
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));
                       
                       logger.info("testDragAndDropAlaraToTimeStep1");

                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();        
                       
                       logger.info("testDragAndDropAlaraToTimeStep1 completed");
}
                   @Test(priority = 13, enabled = true)
                   public void testDragAndDropLabelToTimeStep1() 
                		   throws InterruptedException  {
                      WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Label"))));
                      
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));
                       
                       logger.info("testDragAndDropLabelToTimeStep1");
                       
                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();                  
                       
                       logger.info("testDragAndDropLabelToTimeStep1 completed");
}
                   @Test(priority = 14, enabled = true)
                   public void testDragAndDropParaToTimeStep1() 
                		   throws InterruptedException  {
                	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep1"))));
                   	element.click();
                  	logger.info("Clicking on timedstep element.");
                  	
                      WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Paragraph"))));
                      
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));
                       
                       logger.info("testDragAndDropParaToTimeStep1");
                       
                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();    
                       
                       logger.info("testDragAndDropParaToTimeStep1 completed");
}
                   @Test(priority = 15, enabled = true)
                  public void testDragAndDropFormulaToTimeStep1() 
                		  throws InterruptedException {
                	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep1"))));
                   	element.click();
                  	logger.info("Clicking on timedstep element.");
                	   
                       WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Formula"))));
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath(prop.getProperty("Timedstep1"))));

                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();  

                       

                      logger.info("testDragAndDropFormulaToTimeStep1 completed");

                   }
                   
                   @Test(priority = 16, enabled = true)
                   public void section1click() 
                		   throws InterruptedException  {
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Sectionclick"))));
               		element.click();
               		logger.info("Clicking on section1");
               		
                   }
                   @Test(priority = 17, enabled = true)
                   public void section1() 
                  		   throws InterruptedException  {
                    	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Section1"))));
                 		element.click();
                 		logger.info("Clicking on section from basic");
                 		
                     }
                   
                   @Test(priority = 18, enabled = true)
                   public void AddTimedstepsteptosection21() 
                  		   throws InterruptedException  {
                  	 Thread.sleep(8000);
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("section2click"))));
                  		element.click();
                  		logger.info("Clicking on section2");
                  		
                    	 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep2"))));
                 		element1.click();
                 		logger.info("Clicking timedstepstep to section from basic"); 
                 		
                 		
                 		WebElement element2 = wait.until(
                 			    ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Timedstepsend")))
                 			);

                 			element2.sendKeys("Timedstep_data entries");


                   }
                   
                	    

                   @Test(priority = 19, enabled = true)
                   public void Dataentryclick() 
                  		   throws InterruptedException  {
                  	 Thread.sleep(8000);
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("DataEntry"))));
                  		element.click();
                  		logger.info("Clicking on Dataentry");
                  		
                   }
                   @Test(priority = 20, enabled = true)
                   public void DragAndDropTextToTimedStep2() 
                  		 throws InterruptedException  {
                  	       	 
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstepsend"))));
               		element.click(); 
                   logger.info("Clicking on timed step for drag and drop");
                   WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstepsend"))));
            		element1.click(); 
                logger.info("Clicking on timed step for drag and drop");
                   
                   By sourceLocator = By.xpath(prop.getProperty("Text"));
           		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

           		// Wait until both elements are visible
           		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
           		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
           		//WebElement source = wait.until(
           			   // ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@id='cbp_editor_TextDataEntry'])[1]"))
           			//);
           			//element.click(); 
           		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

           		// Perform drag and drop
           		Actions actions = new Actions(driver);
           		actions.dragAndDrop(source, target).perform();
          }
                   @Test(priority = 21, enabled = true)
                   public void DragAndDroptextAreaToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("TextArea"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 22, enabled = true)
                   public void DragAndDropNumberToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Number"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 23, enabled = true)
                   public void DragAndDropdateToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Date"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   
                   @Test(priority = 24, enabled = true)
                   public void DragAndDropBooleanToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Boolean"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 25, enabled = true)
                   public void DragAndDropradiobuttonToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Radiobutton"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 26, enabled = true)
                   public void DragAndDropCheckboxgroupToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Checkboxgroup"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 27, enabled = true)
                   public void DragAndDropCheckboxToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Checkbox"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 28, enabled = true)
                   public void DragAndDropButtonToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Button"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }
                   
                   @Test(priority = 29, enabled = true)
                   public void DragAndDropdropdownToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Dropdown"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                		
                   }
                   
                   @Test(priority = 30, enabled = false)
                   public void DragAndTableToTimedStep2() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Table"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
                		JavascriptExecutor js = (JavascriptExecutor) driver;
                		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", source);
                		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", target);
                		Point sourcePoint = source.getLocation();
                		Point targetPoint = target.getLocation();

                		int xOffset = targetPoint.getX() - sourcePoint.getX();
                		int yOffset = targetPoint.getY() - sourcePoint.getY();

                		Actions actions = new Actions(driver);
                		actions.clickAndHold(source)
                		       .moveByOffset(xOffset, yOffset)
                		       .release()
                		       .build()
                		       .perform();

                		// Perform drag and drop
                		//Actions actions = new Actions(driver);
                		//actions.dragAndDrop(source, target).perform();
                   }
                   @Test(priority = 30, enabled = true)
                   public void DragAndTable2ToTimedStep2() throws InterruptedException {
                       By sourceLocator = By.xpath(prop.getProperty("Table"));
                       By targetLocator = By.xpath(prop.getProperty("Timedstep2div"));

                       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

                       // Step 1: Wait for source and target
                       WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                       WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                       // Step 2: Scroll into view
                       JavascriptExecutor js = (JavascriptExecutor) driver;
                       js.executeScript("arguments[0].scrollIntoView({block: 'center'});", source);
                       js.executeScript("arguments[0].scrollIntoView({block: 'center'});", target);

                       try {
                           // Step 3: First try  dragAndDrop
                           Actions actions = new Actions(driver);
                           actions.dragAndDrop(source, target).perform();
                           System.out.println("Drag and Drop done using Actions.dragAndDrop");
                       } catch (Exception e1) {
                           System.out.println("Standard dragAndDrop failed, trying offset method: " + e1.getMessage());

                           try {
                               // Step 4: Offset approach
                               Point sourcePoint = source.getLocation();
                               Point targetPoint = target.getLocation();

                               int xOffset = targetPoint.getX() - sourcePoint.getX();
                               int yOffset = targetPoint.getY() - sourcePoint.getY();

                               Actions actions = new Actions(driver);
                               actions.clickAndHold(source)
                                      .moveByOffset(xOffset, yOffset)
                                      .release()
                                      .build()
                                      .perform();
                               System.out.println("Drag and Drop done using offset method");
                           } catch (Exception e2) {
                               System.out.println("Offset dragAndDrop failed, using JavaScript fallback: " + e2.getMessage());

                               // Step 5: JavaScript fallback for HTML5 drag-drop
                               String script = "function createEvent(typeOfEvent) {"
                                       + "var event = document.createEvent('CustomEvent');"
                                       + "event.initCustomEvent(typeOfEvent, true, true, null);"
                                       + "event.dataTransfer = { data: {}, "
                                       + "setData: function(k,v){this.data[k]=v;}, "
                                       + "getData: function(k){return this.data[k];} };"
                                       + "return event; }"
                                       + "function dispatchEvent(el, ev) { if(el.dispatchEvent) el.dispatchEvent(ev); }"
                                       + "function simulateHTML5DragDrop(source, target) {"
                                       + "var dragStartEvent = createEvent('dragstart'); dispatchEvent(source, dragStartEvent);"
                                       + "var dropEvent = createEvent('drop'); dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);"
                                       + "var dragEndEvent = createEvent('dragend'); dispatchEvent(source, dragEndEvent, dropEvent.dataTransfer); }"
                                       + "simulateHTML5DragDrop(arguments[0], arguments[1]);";

                               js.executeScript(script, source, target);
                               System.out.println("Drag and Drop done using JavaScript fallback");
                           }
                       }
                   }
                   
                   @Test(priority = 31, enabled = true) 
                   public void Columntable() throws
              	  InterruptedException { 
              	  //driver.findElement(By.xpath(prop.getProperty("Column"))).clear();
              	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NumberOfColumns"))));
                	element.click();
               	logger.info("Clicking on Column");
              	  Thread.sleep(2000);
              	  //WebElement elementsendkeys = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NumberOfColumns"))));
              	  //elementsendkeys.sendKeys("6");
              	WebElement elementsendkeys = wait.until(
              	        ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("NumberOfColumns")))
              	);

              	// Clear the existing value
              	elementsendkeys.clear();

              	// Send new value
              	elementsendkeys.sendKeys("6");

                 	logger.info("sendkeys to column1");
                   }
                   @Test(priority = 32, enabled = true)
                   public void Rowtable() throws InterruptedException {

                       // Wait for the element to be visible
                       WebElement numberOfRowsInput = wait.until(
                               ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("NumberOfRows")))
                       );

                       logger.info("Located NumberOfRows input");

                       // ✅ Clear the existing value
                       numberOfRowsInput.clear();

                       // ✅ Send the new value
                       numberOfRowsInput.sendKeys("6");
                       logger.info("Entered 6 into NumberOfRows");

                       // (Optional) Small wait if UI needs time to reflect
                       Thread.sleep(1000);

                       // (Optional) Verify value entered
                       String enteredValue = numberOfRowsInput.getAttribute("value");
                       logger.info("Verified value entered: " + enteredValue);
                   }

                   @Test(priority = 33,  enabled=true)
                   public void AddtableElement() 
                		   throws InterruptedException  {
                  	   WebElement AddtableElement = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AddTableOk")))
                          	        );
                          	   
                  	 AddtableElement.click();
                  	logger.info("Clicked on add table ok");
                   }
                   
                   @Test(priority = 34,  enabled=true)
                   public void ColumnElementClick() 
                		   throws InterruptedException  {
                  	   WebElement ColumnElementClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ColumnElement")))
                          	        );
                          	   
                  	 ColumnElementClick.click();     
                  	logger.info("Clicked on column");
                  	 
                   }
                   @Test(priority = 35,  enabled=true)
                   public void DatatypeClick() 
                		   throws InterruptedException  {
                  	   WebElement DatatypeClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Datatypedropdown")))
                          	        );
                          	   
                  	 DatatypeClick.click();     
                  	logger.info("Clicked on Datatypedropdown");
                   
}
                   @Test(priority = 36,  enabled=true)
                   public void textdataentryClick() 
                		   throws InterruptedException  {
                  	   WebElement textdataentryClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Textdataentry")))
                          	        );
                          	   
                  	 textdataentryClick.click();     
                  	logger.info("Clicked on textdataentryClick");
}
                   @Test(priority = 37,  enabled=true)
                   public void Column2Click() 
                		   throws InterruptedException  {
                  	   WebElement Column2Click = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Column2")))
                          	        );
                          	   
                  	 Column2Click.click();     
                  	logger.info("Clicked on Column2");
                   }
                   
                   @Test(priority = 38,  enabled=true)
                   public void textAreadataentryClick() 
                		   throws InterruptedException  {
                  	   WebElement textAreadataentryClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Textareadataentry")))
                          	        );
                          	   
                  	 textAreadataentryClick.click();     
                  	logger.info("Clicked on textAreadataentryClick");            
}
                   @Test(priority = 39,  enabled=true)
                   public void Column3Click() 
                		   throws InterruptedException  {
                  	   WebElement Column3Click = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Column3")))
                          	        );
                          	   
                  	 Column3Click.click();     
                  	logger.info("Clicked on Column3");   
}
                   
                   @Test(priority = 40,  enabled=true)
                   public void NUmberdataentryClick() 
                		   throws InterruptedException  {
                  	   WebElement NUmberdataentryClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Numberdataentry")))
                          	        );
                          	   
                  	 NUmberdataentryClick.click();     
                  	logger.info("Clicked on NumberdataentryClick");                    
                  	
}
                   @Test(priority = 41,  enabled=true)
                   public void Column4Click() 
                		   throws InterruptedException  {
                  	   WebElement Column4Click = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Column4")))
                          	        );
                          	   
                  	 Column4Click.click();     
                  	logger.info("Clicked on Column4"); 
}
                  
                   @Test(priority = 42,  enabled=true)
                   public void DatedataentryClick() 
                		   throws InterruptedException  {
                  	   WebElement DatedataentryClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Datedataentry")))
                          	        );
                          	   
                  	 DatedataentryClick.click();     
                  	logger.info("Clicked on DatedataentryClick");                    
                  	        
}
                   @Test(priority = 43,  enabled=true)
                   public void Column5Click() 
                		   throws InterruptedException  {
                  	   WebElement Column5Click = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Column5")))
                          	        );
                          	   
                  	 Column5Click.click();     
                  	logger.info("Clicked on Column5");           
}
                   
                   @Test(priority = 44,  enabled=true)
                   public void CheckboxdataentryClick() 
                		   throws InterruptedException  {
                  	   WebElement CheckboxdataentryClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Checkboxdataentry")))
                          	        );
                          	   
                  	 CheckboxdataentryClick.click();     
                  	logger.info("Clicked on CheckboxdataentryClick");                    
                  	                
}
                   @Test(priority = 45,  enabled=true)
                   public void Column6Click() 
                		   throws InterruptedException  {
                  	   WebElement Column6Click = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Column6")))
                          	        );
                          	   
                  	 Column6Click.click();     
                  	logger.info("Clicked on Column6");   
}
                   
                   @Test(priority = 46,  enabled=true)
                   public void DropdowndataentryClick() 
                		   throws InterruptedException  {
                  	   WebElement DropdowndataentryClick = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Dropdowndataentry")))
                          	        );
                          	   
                  	 DropdowndataentryClick.click();     
                  	logger.info("Clicked on DropdowndataentryClick");      
}
                   @Test(priority = 47,  enabled=true)
                   public void Tabledataentries() 
                		   throws InterruptedException  {
                  	   WebElement Tabledataentries = wait.until(
                          	        ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Tabledataentries")))
                          	        );
                          	   
                  	 Tabledataentries.click();     
                  	logger.info("Clicked ok on Tabledataentries");    
                   }
                   
                   @Test(priority = 48, enabled = true)
                   public void sectionclick() 
                		   throws InterruptedException  {
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Sectionclick"))));
               		element.click();
               		logger.info("Clicking on section1");
               	
               		
                   }
                   @Test(priority = 49, enabled = true)
                   public void Basicclick() 
                		   throws InterruptedException  {
                   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Basic"))));
              		element.click();
              		logger.info("Clicking on Basic");
                   }
                   
                   @Test(priority = 50, enabled = true)
                   public void section3() 
                  		   throws InterruptedException  {
                    	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Section3Click"))));
                 		element.click();
                 		logger.info("Clicking on section from basic");
                 		
                     }
                   
                   @Test(priority = 51, enabled = true)
                   public void AddTimedsteptosection3() 
                  		   throws InterruptedException  {
                  	 Thread.sleep(8000);
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Section3select"))));
                  		element.click();
                  		logger.info("Clicking on section3");
                  		
                    	 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep3c"))));
                 		element1.click();
                 		logger.info("Clicking timedstep to section from basic"); 
                 		
                 		
                 		WebElement element2 = wait.until(
                 			    ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Timedstep3select")))
                 			);

                 			element2.sendKeys("Timedstep_reference links");


                   }
                   
                   @Test(priority = 52,  enabled=true)
                   public void Referencelinkclick()  
                		   throws InterruptedException  {
              			WebElement Referencelinkelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Referencelink"))));
              			Referencelinkelement.click();   
              			//WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Reference/Link']"));
              			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Referencelinkelement);
              			new WebDriverWait(driver, Duration.ofSeconds(30))
              			    .until(ExpectedConditions.elementToBeClickable(Referencelinkelement))
              			    .click();

              			logger.info("Click on Referencelinkclick "); 
}
                   @Test(priority = 53, enabled = true)
                   public void DragAndDropmediagallerytotimedstep3() 
                  		 throws InterruptedException  {
                  	 By sourceLocator = By.xpath(prop.getProperty("Mediagallery"));
                		By targetLocator = By.xpath(prop.getProperty("Timedstep3div"));

                		// Wait until both elements are visible
                		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
                		
                		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

                		// Perform drag and drop
                		Actions actions = new Actions(driver);
                		actions.dragAndDrop(source, target).perform();
                   }               
                   
                   @Test(priority = 54, enabled = true)
                   public void AddMediaclick2() throws AWTException {
                       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

                       // Click Add Media select button
                       WebElement addMediaElementSelect = wait.until(
                           ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Addmediaselect")))
                       );
                       addMediaElementSelect.click();
                       logger.info("Selecting AddMediaelement");

                       // Wait for file input to be present
                       WebElement fileInput = wait.until(
                           ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='input-upload']"))
                       );
                       logger.info("File input located");

                       // Upload files (make sure these paths exist!)
                       
                       WebElement uploadInput = driver.findElement(By.xpath("//input[@class='input-upload']"));
             			uploadInput.sendKeys("C:\\Users\\janusha\\Pictures\\jpeg2.jfif");
             			
             			WebElement uploadInput1 = driver.findElement(By.xpath("//input[@class='input-upload']"));
             			uploadInput.sendKeys("C:\\Users\\janusha\\Pictures\\building.jfif");
             			
             			WebElement uploadInput2 = driver.findElement(By.xpath("//input[@class='input-upload']"));
             			uploadInput.sendKeys("C:\\Users\\janusha\\Pictures\\human1.jfif");
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

             		logger.info("Files uploaded successfully");
             		
                   }
                   @Test(priority = 55, enabled = true)
                   public void dragAndDropMediaSingle() throws AWTException {
                       // Locate source element (Media Single span)
                       //WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                              // By.xpath("Mediasingle")));
                	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep3select"))));
                  		element.click();
                       By sourceLocator = By.xpath(prop.getProperty("Mediasingle"));
               		By targetLocator = By.xpath(prop.getProperty("Timedstep3div"));

               		// Wait until both elements are visible
               		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
               		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
               		
               		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));

               		// Perform drag and drop
               		Actions actions = new Actions(driver);
               		actions.dragAndDrop(source, target).perform();
                    // Wait until elements are visible
               		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               		//wait.until(ExpectedConditions.visibilityOf(source));
               		//wait.until(ExpectedConditions.visibilityOf(target));

                       // Perform drag and drop using Actions
                       //Actions actions = new Actions(driver);
                       //actions.dragAndDrop(source, target).perform();

                       logger.info("Dragged 'Media Single' and dropped into 'Timed HEADER' successfully.");
                       Robot rb = new Robot();
               		rb.delay(2000);

               		StringSelection ss = new StringSelection(prop.getProperty("Path3"));
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
                   @Test(priority = 56, enabled = true)
                   public void dragAndDropLinkToTimedstep() {

                       // Locate source element (Link span)
                       //WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(
                              // By.xpath("Link")));

                       // Locate target element (Timed HEADER textarea)
                      // WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                              // By.xpath("(//div/textarea[@placeholder='Timed HEADER'])[3]")));

                       // Perform drag and drop using Actions
                	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep3select"))));
                 		element.click();
                      By sourceLocator = By.xpath(prop.getProperty("Link"));
              		By targetLocator = By.xpath(prop.getProperty("Timedstep3div"));

              		// Wait until both elements are visible
              		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
              		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
              		
              		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
                       Actions actions = new Actions(driver);
                       actions.dragAndDrop(source, target).perform();

                       System.out.println("Dragged 'Link' and dropped into 'Timed HEADER' successfully.");
                   }
               
                   @Test(priority = 55, enabled = true)
                   public void sectionclick1() 
                		   throws InterruptedException  {
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Sectionclick"))));
               		element.click();
               		logger.info("Clicking on section1");
               	
               		
                   }
                   @Test(priority = 56, enabled = true)
                   public void Basicclick1() 
                		   throws InterruptedException  {
                   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Basic"))));
              		element.click();
              		logger.info("Clicking on Basic");
                   }
                   
                   @Test(priority = 57, enabled = true)
                   public void section4() 
                  		   throws InterruptedException  {
                    	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("section4click"))));
                 		element.click();
                 		logger.info("Clicking on section from basic");
                 		
                     }
                   
                   @Test(priority = 58, enabled = true)
                   public void AddTimedsteptosection4() 
                  		   throws InterruptedException  {
                  	 Thread.sleep(8000);
                  	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Section4select"))));
                  		element.click();
                  		logger.info("Clicking on section4");
                  		
                    	 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Timedstep4c"))));
                 		element1.click();
                 		logger.info("Clicking timedstep to section from basic"); 
                 		
                 		
                 		WebElement element2 = wait.until(
                 			    ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Timedstep4select")))
                 			);

                 			element2.sendKeys("Timedstep_Verification");
                   }
                   
                   
                   
                   @Test(priority = 59,  enabled=true)
                   public void verificationclick()  
                		   throws InterruptedException  {
                	   //WebElement target = driver.findElement(By.xpath("(//span[@id='cbp_editor_Figures'])[2]"));
                	  // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", verifications);
                	  // verifications.click();
                	   WebElement Referencelinkelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Referencelink"))));
             			Referencelinkelement.click();   
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                			//WebElement verificationclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Verification1"))));
                			//verificationclick.click();       
                			//logger.info("Click on verification"); 
                			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
                			WebElement verificationclick = wait.until(
                			    ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Verification1")))
                			);

                			((JavascriptExecutor) driver).executeScript("arguments[0].click();", verificationclick);
                			logger.info("Clicked on Verification button using JS");


                   Thread.sleep(6000);
               	WebElement source = driver.findElement(By.xpath(prop.getProperty("independent")));
               	WebElement target = driver.findElement(By.xpath(prop.getProperty("Timedstep4div")));

               //Wait until elements are visible
               	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
               	wait.until(ExpectedConditions.visibilityOf(source));
               	wait.until(ExpectedConditions.visibilityOf(target));

               //Perform drag and drop
               	Actions actions = new Actions(driver);
               	actions.dragAndDrop(source, target).perform();
               	}
               	@Test(priority = 60, enabled = true)
               	public void concurrentverification() throws InterruptedException, Exception {
               	Thread.sleep(2000);
               	Thread.sleep(4000);
               	WebElement source = driver.findElement(By.xpath(prop.getProperty("concurrent")));
               	WebElement target = driver.findElement(By.xpath(prop.getProperty("Timedstep4div")));

               //Wait until elements are visible
               	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
               	wait.until(ExpectedConditions.visibilityOf(source));
               	wait.until(ExpectedConditions.visibilityOf(target));

               //Perform drag and drop
               	Actions actions = new Actions(driver);
               	actions.dragAndDrop(source, target).perform();

               }
               	@Test(priority = 61, enabled = true)
               	public void QAverification() throws InterruptedException, Exception {
               	Thread.sleep(2000);
               	Thread.sleep(4000);
               	WebElement source = driver.findElement(By.xpath(prop.getProperty("QA")));
               	WebElement target = driver.findElement(By.xpath(prop.getProperty("Timedstep4div")));

               //Wait until elements are visible
               	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
               	wait.until(ExpectedConditions.visibilityOf(source));
               	wait.until(ExpectedConditions.visibilityOf(target));

               //Perform drag and drop
               	Actions actions = new Actions(driver);
               	actions.dragAndDrop(source, target).perform();

               }
               	@Test(priority = 62, enabled = true)
               	public void peerverification() throws InterruptedException, Exception {
               	Thread.sleep(2000);
               	Thread.sleep(4000);
               	WebElement source = driver.findElement(By.xpath(prop.getProperty("peer")));
               	WebElement target = driver.findElement(By.xpath(prop.getProperty("Timedstep4div")));

               //Wait until elements are visible
               	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
               	wait.until(ExpectedConditions.visibilityOf(source));
               	wait.until(ExpectedConditions.visibilityOf(target));

               //Perform drag and drop
               	Actions actions = new Actions(driver);
               	actions.dragAndDrop(source, target).perform();

               }
               	@Test(priority = 63, enabled = true)
               	public void signatureverification() throws InterruptedException, Exception {
               	Thread.sleep(2000);
               	Thread.sleep(4000);
               	WebElement source = driver.findElement(By.xpath(prop.getProperty("signature")));
               	WebElement target = driver.findElement(By.xpath(prop.getProperty("Timedstep4div")));

               //Wait until elements are visible
               	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
               	wait.until(ExpectedConditions.visibilityOf(source));
               	wait.until(ExpectedConditions.visibilityOf(target));

               //Perform drag and drop
               	Actions actions = new Actions(driver);
               	actions.dragAndDrop(source, target).perform();

               }
               	@Test(priority = 64, enabled = true)
               	public void initialverification() throws InterruptedException, Exception {
               	Thread.sleep(2000);
               	Thread.sleep(4000);
               	WebElement source = driver.findElement(By.xpath(prop.getProperty("initial")));
               	WebElement target = driver.findElement(By.xpath(prop.getProperty("Timedstep4div")));

               //Wait until elements are visible
               	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
               	wait.until(ExpectedConditions.visibilityOf(source));
               	wait.until(ExpectedConditions.visibilityOf(target));

               //Perform drag and drop
               	Actions actions = new Actions(driver);
               	actions.dragAndDrop(source, target).perform();
               	Thread.sleep(2000);

}
}



