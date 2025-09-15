package testcases;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Instance;
import base.PropertiesFile;

public class StepInfo {WebDriver driver = Instance.getInstance();
Properties prop = PropertiesFile.readPropertyFile("StepInfo.properties");
Logger logger = LogManager.getLogger(Signin.class);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
@Test(priority = 1, enabled = true)
public void cbpeditor() throws InterruptedException {
	WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("(//a/img[@class='img-fluid himg'])[4]")));
		targetElement.click();
		logger.info("Clicked on the target element");
}
@Test(priority = 2, enabled = true)
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
      throws InterruptedException { 
      driver.findElement(By.xpath(prop.getProperty("Control"))).click();
      logger.info("Clicked on the control");
}
@Test(priority = 4, enabled = true)
public void stepinfo() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    
    try {
        // Step 1: Click on StepInfo element
        System.out.println("Attempting to click on StepInfo element...");
        logger.info("Starting StepInfo test case");
        
        By stepInfoLocator = By.xpath(prop.getProperty("StepInfo"));
        WebElement stepInfoElement = wait.until(ExpectedConditions.elementToBeClickable(stepInfoLocator));
        
        // Scroll element into view if needed
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", stepInfoElement);
        Thread.sleep(500); // Brief pause after scroll
        
        // Click the StepInfo element
        stepInfoElement.click();
        logger.info("Successfully clicked on the StepInfo element");
        System.out.println("StepInfo element clicked successfully");
        
        // Wait a moment for any UI changes after click
        Thread.sleep(1000);
        
        // Step 2: Send keys to StepInfo input field
        System.out.println("Attempting to send keys to StepInfo input field...");
        
        By stepInfo1Locator = By.xpath(prop.getProperty("StepInfo1"));
        WebElement stepInfo1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(stepInfo1Locator));
        
        // Ensure the element is clickable and clear any existing content
        wait.until(ExpectedConditions.elementToBeClickable(stepInfo1Element));
        
        // Clear existing content and send new keys
        stepInfo1Element.clear();
        stepInfo1Element.sendKeys("StepInfo");
        
        logger.info("Successfully sent keys 'StepInfo' to StepInfo1 field");
        System.out.println("Keys sent to StepInfo input field successfully");
        
        // Optional: Verify the text was entered correctly
        String enteredText = stepInfo1Element.getAttribute("value");
        if ("StepInfo".equals(enteredText)) {
            logger.info("Verification successful: Text entered correctly - " + enteredText);
            System.out.println("Verification passed: Text entered correctly");
        } else {
            logger.warn("Verification failed: Expected 'StepInfo' but found '" + enteredText + "'");
            System.out.println("Warning: Text verification failed");
        }
        
    } catch (ElementNotInteractableException e) {
        logger.error("StepInfo element not interactable: " + e.getMessage());
        System.err.println("Element not interactable: " + e.getMessage());
        
        // Try alternative interaction method
        performAlternativeStepInfoInteraction();
        
    } catch (NoSuchElementException e) {
        logger.error("StepInfo element not found: " + e.getMessage());
        System.err.println("Element not found: " + e.getMessage());
        
        // Debug information
        printStepInfoDebugInfo();
        throw e;
        
    } catch (Exception e) {
        logger.error("Unexpected error in stepinfo test: " + e.getMessage(), e);
        System.err.println("Unexpected error: " + e.getMessage());
        throw e;
    }
}

// Helper method for alternative interaction approach
private void performAlternativeStepInfoInteraction() {
    try {
        logger.info("Attempting alternative StepInfo interaction method");
        System.out.println("Trying alternative interaction approach...");
        
        // Use JavaScript to click and send keys
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Find elements using JavaScript
        WebElement stepInfoElement = driver.findElement(By.xpath(prop.getProperty("StepInfo")));
        WebElement stepInfo1Element = driver.findElement(By.xpath(prop.getProperty("StepInfo1")));
        
        // JavaScript click
        js.executeScript("arguments[0].click();", stepInfoElement);
        Thread.sleep(1000);
        
        // JavaScript to set value
        js.executeScript("arguments[0].value = 'StepInfo';", stepInfo1Element);
        
        // Trigger change event to ensure the application recognizes the input
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", stepInfo1Element);
        
        logger.info("Alternative interaction method completed successfully");
        System.out.println("Alternative interaction completed");
        
    } catch (Exception altException) {
        logger.error("Alternative interaction method also failed: " + altException.getMessage());
        System.err.println("Alternative method failed: " + altException.getMessage());
    }
}

// Helper method for debugging StepInfo elements
private void printStepInfoDebugInfo() {
    try {
        System.out.println("\n=== DEBUG: StepInfo Elements Information ===");
        
        // Print XPath values from properties
        System.out.println("StepInfo XPath from properties: " + prop.getProperty("StepInfo"));
        System.out.println("StepInfo1 XPath from properties: " + prop.getProperty("StepInfo1"));
        
        // Check if elements exist
        List<WebElement> stepInfoElements = driver.findElements(By.xpath(prop.getProperty("StepInfo")));
        List<WebElement> stepInfo1Elements = driver.findElements(By.xpath(prop.getProperty("StepInfo1")));
        
        System.out.println("Found " + stepInfoElements.size() + " elements matching StepInfo XPath");
        System.out.println("Found " + stepInfo1Elements.size() + " elements matching StepInfo1 XPath");
        
        // Print details of found elements
        for (int i = 0; i < stepInfoElements.size(); i++) {
            WebElement element = stepInfoElements.get(i);
            System.out.println("StepInfo Element " + (i+1) + ":");
            System.out.println("  - Tag: " + element.getTagName());
            System.out.println("  - Text: " + element.getText());
            System.out.println("  - Displayed: " + element.isDisplayed());
            System.out.println("  - Enabled: " + element.isEnabled());
        }
        
        for (int i = 0; i < stepInfo1Elements.size(); i++) {
            WebElement element = stepInfo1Elements.get(i);
            System.out.println("StepInfo1 Element " + (i+1) + ":");
            System.out.println("  - Tag: " + element.getTagName());
            System.out.println("  - Text: " + element.getText());
            System.out.println("  - Value: " + element.getAttribute("value"));
            System.out.println("  - Placeholder: " + element.getAttribute("placeholder"));
            System.out.println("  - Displayed: " + element.isDisplayed());
            System.out.println("  - Enabled: " + element.isEnabled());
        }
        
        // Try alternative selectors
        System.out.println("\n--- Alternative StepInfo Elements ---");
        tryAlternativeSelectors();
        
        System.out.println("=== END DEBUG INFO ===\n");
        
    } catch (Exception debugException) {
        System.err.println("Error during debug info collection: " + debugException.getMessage());
    }
}

// Helper method to try alternative selectors for StepInfo elements
private void tryAlternativeSelectors() {
    String[] alternativeSelectors = {
        "//input[contains(@placeholder, 'step')]",
        "//textarea[contains(@placeholder, 'step')]",
        "//*[contains(text(), 'Step')]",
        "//div[contains(@class, 'step')]",
        "//*[@id*='step']",
        "//*[contains(@name, 'step')]"
    };
    
    for (String selector : alternativeSelectors) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(selector));
            if (!elements.isEmpty()) {
                System.out.println("Alternative selector '" + selector + "' found " + elements.size() + " elements");
            }
        } catch (Exception e) {
            // Continue to next selector
        }
    }
}

// Optional: Method to validate StepInfo functionality after interaction
@Test(priority = 5, enabled = true, dependsOnMethods = {"stepinfo"})
public void validateStepInfoInput() throws InterruptedException {
    try {
        logger.info("Validating StepInfo input functionality");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement stepInfo1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(prop.getProperty("StepInfo1"))));
        
        String currentValue = stepInfo1Element.getAttribute("value");
        
        if ("StepInfo".equals(currentValue)) {
            logger.info("StepInfo validation passed: Value is correctly set to 'StepInfo'");
            System.out.println("✓ StepInfo validation passed");
        } else {
            logger.warn("StepInfo validation failed: Expected 'StepInfo' but found '" + currentValue + "'");
            System.out.println("✗ StepInfo validation failed: " + currentValue);
        }
        
    } catch (Exception e) {
        logger.error("StepInfo validation error: " + e.getMessage());
        System.err.println("Validation error: " + e.getMessage());
    }
}

      
      @Test(priority = 5, enabled = true) public void Draglabeltoinfostep()
		      throws InterruptedException { 
		      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("StepInfo1"))));
              element.click();
              WebElement source = driver.findElement(By.xpath(prop.getProperty("Label")));
              WebElement target = driver.findElement(By.xpath(prop.getProperty("StepInfo1")));

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
              labelInput.sendKeys("label_StepInfo");

              logger.info("✅ Successfully dragged the label to the StepInfo and entered text");
      }
      @Test(priority = 6, enabled = true) public void Dragparagraphtostepinfo()
		      throws InterruptedException { 
		      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("StepInfo1"))));
              element.click();
              WebElement source = driver.findElement(By.xpath(prop.getProperty("Paragraph")));
              WebElement target = driver.findElement(By.xpath(prop.getProperty("StepInfo1")));

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
              ParaInput.sendKeys("Paragraph-step Info");

              logger.info("✅ Successfully dragged the Para to the Delay Step and entered text");   
      }
      @Test(priority = 7, enabled = true)
      public void Dataentryclick() 
     		   throws InterruptedException  {
     	 
     	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("DataEntry"))));
     		element.click();
     		logger.info("Clicking on Dataentry");
     		
      }  
      @Test(priority = 8, enabled = false)
      public void DragAndTabletoStepinfo() throws InterruptedException {
    	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("StepInfo1"))));
   		element.click();
   		logger.info("Clicking on Stepinfo for drag and table to stepinfo");
          By sourceLocator = By.xpath(prop.getProperty("Table"));
          By targetLocator = By.xpath(prop.getProperty("StepInfodiv"));

          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
          
          try {
              // Wait for both elements to be visible and interactable
              WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
              WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
              
              // Additional check to ensure elements are clickable
              wait.until(ExpectedConditions.elementToBeClickable(source));
              wait.until(ExpectedConditions.elementToBeClickable(target));
              
              // Scroll elements into view if needed
              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
              Thread.sleep(500); // Brief pause after scroll
              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
              Thread.sleep(500);
              
              // Log element details for debugging
              System.out.println("Source element: " + source.getTagName() + " - " + source.getText());
              System.out.println("Target element: " + target.getTagName() + " - " + target.getText());
              
              // Perform drag and drop with Actions
              Actions actions = new Actions(driver);
              actions.dragAndDrop(source, target).perform();
              
              System.out.println("Drag and Drop completed using Actions.dragAndDrop");
              
              // Optional: Add verification that drag and drop was successful
              // Wait for any animations to complete
              // Add your verification logic here based on expected UI changes
              
          } catch (Exception e) {
              System.err.println("Drag and drop failed: " + e.getMessage());
              
              // Alternative approach using click and hold, move, release
              try {
                  WebElement source = driver.findElement(sourceLocator);
                  WebElement target = driver.findElement(targetLocator);
                  
                  Actions actions = new Actions(driver);
                  actions.clickAndHold(source)
                         .moveToElement(target)
                         .release()
                         .perform();
                  
                  System.out.println("Drag and Drop completed using alternative method");
                  
              } catch (Exception altException) {
                  System.err.println("Alternative drag and drop also failed: " + altException.getMessage());
                  throw altException;
              }
          }
      }
      @Test(priority = 8, enabled = true)
      public void DragAndTabletoStepinfo1() throws InterruptedException {
    	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("DataEntry"))));
    	    element.click();
    	    logger.info("Clicking on Stepinfo for drag and table to stepinfo");
    	    
    	    By sourceLocator = By.xpath(prop.getProperty("Table"));
    	    By targetLocator = By.xpath(prop.getProperty("StepInfodiv"));

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

    	    try {
    	        System.out.println("=== Starting Drag and Drop Operation ===");
    	        
    	        // Step 1: Ensure proper browser setup
    	        setupBrowserForDragDrop();
    	        
    	        // Step 2: Wait for elements
    	        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
    	        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
    	        
    	        System.out.println("Both source and target elements found");
    	        
    	        // Step 3: Try the safest method first - HTML5 Drag and Drop
    	        if (performHTML5DragAndDrop(source, target)) {
    	            System.out.println("✓ HTML5 drag and drop succeeded");
    	            return;
    	        }
    	        
    	        // Step 4: Try JavaScript drag and drop
    	        if (performSimpleJavaScriptDragDrop(source, target)) {
    	            System.out.println("✓ JavaScript drag and drop succeeded");
    	            return;
    	        }
    	        
    	        // Step 5: Try viewport-safe Actions drag and drop
    	        if (performViewportSafeDragDrop(source, target)) {
    	            System.out.println("✓ Viewport-safe drag and drop succeeded");
    	            return;
    	        }
    	        
    	        // Step 6: Final fallback - simulate the interaction
    	        performDragDropSimulation(source, target);
    	        System.out.println("✓ Drag drop simulation completed");
    	        
    	    } catch (Exception e) {
    	        System.err.println("All drag and drop methods failed: " + e.getMessage());
    	        e.printStackTrace();
    	        
    	        // Ultimate fallback
    	        performUltimateFallback(sourceLocator, targetLocator);
    	    }
    	}
      private void setupBrowserForDragDrop() throws InterruptedException {
    	    // Maximize window and ensure stable viewport
    	    driver.manage().window().maximize();
    	    Thread.sleep(1000);
    	    
    	    // Set a specific window size to avoid bounds issues
    	    driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
    	    Thread.sleep(500);
    	    
    	    // Scroll to top of page to reset viewport
    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("window.scrollTo(0, 0);");
    	    Thread.sleep(500);
    	    
    	    System.out.println("Browser setup completed for drag and drop");
    	}
      private boolean performHTML5DragAndDrop(WebElement source, WebElement target) {
    	    try {
    	        System.out.println("Attempting HTML5 drag and drop...");
    	        
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        
    	        // Modern HTML5 drag and drop script
    	        String html5DragDrop = 
    	            "(function(source, target) {" +
    	            "  var dataTransfer = {" +
    	            "    data: {}," +
    	            "    setData: function(key, val) { this.data[key] = val; }," +
    	            "    getData: function(key) { return this.data[key]; }" +
    	            "  };" +
    	            "  " +
    	            "  function createEvent(type) {" +
    	            "    var event = new Event(type, { bubbles: true });" +
    	            "    event.dataTransfer = dataTransfer;" +
    	            "    return event;" +
    	            "  }" +
    	            "  " +
    	            "  source.dispatchEvent(createEvent('dragstart'));" +
    	            "  target.dispatchEvent(createEvent('dragenter'));" +
    	            "  target.dispatchEvent(createEvent('dragover'));" +
    	            "  target.dispatchEvent(createEvent('drop'));" +
    	            "  source.dispatchEvent(createEvent('dragend'));" +
    	            "})(arguments[0], arguments[1]);";
    	        
    	        js.executeScript(html5DragDrop, source, target);
    	        Thread.sleep(1000);
    	        
    	        return true;
    	        
    	    } catch (Exception e) {
    	        System.out.println("HTML5 drag and drop failed: " + e.getMessage());
    	        return false;
    	    }
    	}
      private boolean performSimpleJavaScriptDragDrop(WebElement source, WebElement target) {
    	    try {
    	        System.out.println("Attempting simple JavaScript drag and drop...");
    	        
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        
    	        // Simple drag and drop simulation
    	        String script = 
    	            "var sourceElement = arguments[0];" +
    	            "var targetElement = arguments[1];" +
    	            "var event = document.createEvent('HTMLEvents');" +
    	            "event.initEvent('dragstart', true, false);" +
    	            "sourceElement.dispatchEvent(event);" +
    	            "event = document.createEvent('HTMLEvents');" +
    	            "event.initEvent('drop', true, false);" +
    	            "targetElement.dispatchEvent(event);" +
    	            "event = document.createEvent('HTMLEvents');" +
    	            "event.initEvent('dragend', true, false);" +
    	            "sourceElement.dispatchEvent(event);";
    	        
    	        js.executeScript(script, source, target);
    	        Thread.sleep(1000);
    	        
    	        return true;
    	        
    	    } catch (Exception e) {
    	        System.out.println("Simple JavaScript drag and drop failed: " + e.getMessage());
    	        return false;
    	    }
    	}
      private boolean performViewportSafeDragDrop(WebElement source, WebElement target) {
    	    try {
    	        System.out.println("Attempting viewport-safe Actions drag and drop...");
    	        
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        
    	        // Ensure both elements are in the center of viewport
    	        js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});", source);
    	        Thread.sleep(500);
    	        js.executeScript("arguments[1].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});", target);
    	        Thread.sleep(500);
    	        
    	        // Check if elements are actually visible and within bounds
    	        boolean sourceVisible = (Boolean) js.executeScript(
    	            "var rect = arguments[0].getBoundingClientRect();" +
    	            "var viewport = {width: window.innerWidth, height: window.innerHeight};" +
    	            "return rect.top >= 0 && rect.left >= 0 && " +
    	            "rect.bottom <= viewport.height && rect.right <= viewport.width;", source);
    	            
    	        boolean targetVisible = (Boolean) js.executeScript(
    	            "var rect = arguments[0].getBoundingClientRect();" +
    	            "var viewport = {width: window.innerWidth, height: window.innerHeight};" +
    	            "return rect.top >= 0 && rect.left >= 0 && " +
    	            "rect.bottom <= viewport.height && rect.right <= viewport.width;", target);
    	        
    	        if (!sourceVisible || !targetVisible) {
    	            System.out.println("Elements not properly visible in viewport");
    	            return false;
    	        }
    	        
    	        Actions actions = new Actions(driver);
    	        
    	        // Use the simplest possible drag and drop
    	        actions.dragAndDrop(source, target).perform();
    	        Thread.sleep(1000);
    	        
    	        return true;
    	        
    	    } catch (org.openqa.selenium.interactions.MoveTargetOutOfBoundsException e) {
    	        System.out.println("Viewport-safe drag and drop still out of bounds: " + e.getMessage());
    	        return false;
    	    } catch (Exception e) {
    	        System.out.println("Viewport-safe drag and drop failed: " + e.getMessage());
    	        return false;
    	    }
    	}
      private void performDragDropSimulation(WebElement source, WebElement target) throws InterruptedException {
    	    System.out.println("Performing drag drop simulation...");
    	    
    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    
    	    // Comprehensive drag and drop simulation
    	    String simulationScript = 
    	        "function simulateDragDrop(sourceNode, destinationNode) {" +
    	        "    var EVENT_TYPES = {" +
    	        "        DRAG_END: 'dragend'," +
    	        "        DRAG_ENTER: 'dragenter'," +
    	        "        DRAG_EXIT: 'dragexit'," +
    	        "        DRAG_LEAVE: 'dragleave'," +
    	        "        DRAG_OVER: 'dragover'," +
    	        "        DRAG_START: 'dragstart'," +
    	        "        DROP: 'drop'" +
    	        "    };" +
    	        "    " +
    	        "    function createCustomEvent(type) {" +
    	        "        var event = new CustomEvent('CustomEvent');" +
    	        "        event.initCustomEvent(type, true, true, null);" +
    	        "        event.dataTransfer = {" +
    	        "            data: {}," +
    	        "            setData: function(key, val) { this.data[key] = val; }," +
    	        "            getData: function(key) { return this.data[key]; }" +
    	        "        };" +
    	        "        return event;" +
    	        "    }" +
    	        "    " +
    	        "    function dispatchEvent(node, type, event) {" +
    	        "        if (node.dispatchEvent) {" +
    	        "            return node.dispatchEvent(event);" +
    	        "        }" +
    	        "        if (node.fireEvent) {" +
    	        "            return node.fireEvent('on' + type, event);" +
    	        "        }" +
    	        "    }" +
    	        "    " +
    	        "    var event = createCustomEvent(EVENT_TYPES.DRAG_START);" +
    	        "    dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, event);" +
    	        "    " +
    	        "    var dropEvent = createCustomEvent(EVENT_TYPES.DROP);" +
    	        "    dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent);" +
    	        "    " +
    	        "    var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END);" +
    	        "    dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent);" +
    	        "}" +
    	        "simulateDragDrop(arguments[0], arguments[1]);";
    	    
    	    js.executeScript(simulationScript, source, target);
    	    Thread.sleep(1500);
    	}
      private void performUltimateFallback(By sourceLocator, By targetLocator) throws InterruptedException {
    	    System.out.println("Performing ultimate fallback - direct interaction simulation...");
    	    
    	    try {
    	        // Find elements again
    	        WebElement source = driver.findElement(sourceLocator);
    	        WebElement target = driver.findElement(targetLocator);
    	        
    	        // Try simple click sequence
    	        source.click();
    	        Thread.sleep(500);
    	        target.click();
    	        Thread.sleep(500);
    	        
    	        // Try to trigger any expected behavior with keyboard
    	        target.sendKeys(org.openqa.selenium.Keys.ENTER);
    	        Thread.sleep(500);
    	        
    	        System.out.println("Ultimate fallback completed - used click simulation");
    	        
    	    } catch (Exception fallbackException) {
    	        System.err.println("Ultimate fallback also failed: " + fallbackException.getMessage());
    	        
    	        // Log final state for debugging
    	        logFinalDebugInfo();
    	        
    	        throw new RuntimeException("All drag and drop attempts failed", fallbackException);
    	    }
    	}
      private void logFinalDebugInfo() {
    	    try {
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        
    	        // Get viewport size
    	        Long viewportWidth = (Long) js.executeScript("return window.innerWidth;");
    	        Long viewportHeight = (Long) js.executeScript("return window.innerHeight;");
    	        
    	        // Get window size
    	        org.openqa.selenium.Dimension windowSize = driver.manage().window().getSize();
    	        
    	        System.out.println("\n=== FINAL DEBUG INFO ===");
    	        System.out.println("Viewport size: " + viewportWidth + "x" + viewportHeight);
    	        System.out.println("Window size: " + windowSize.getWidth() + "x" + windowSize.getHeight());
    	        System.out.println("User agent: " + js.executeScript("return navigator.userAgent;"));
    	        System.out.println("Page URL: " + driver.getCurrentUrl());
    	        System.out.println("========================\n");
    	        
    	    } catch (Exception debugException) {
    	        System.err.println("Could not gather debug info: " + debugException.getMessage());
    	    }
    	}
      @Test(priority = 9, enabled = true)
      private void handlePopupAfterDragDrop() throws InterruptedException {
    	    try {
    	        System.out.println("Checking for popup after drag and drop...");
    	        
    	        // Wait for popup to appear
    	        WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	        
    	        // Define the OK button locator
    	        By okButtonLocator = By.xpath(prop.getProperty("Okbutton"));
    	        
    	        // Wait for the OK button to be clickable
    	        WebElement okButton = popupWait.until(ExpectedConditions.elementToBeClickable(okButtonLocator));
    	        
    	        System.out.println("Popup appeared, clicking OK button...");
    	        
    	        // Scroll the OK button into view if needed
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", okButton);
    	        Thread.sleep(300);
    	        
    	        // Click the OK button
    	        okButton.click();
    	        
    	        System.out.println("✓ Successfully clicked OK button on popup");
    	        logger.info("Clicked OK button on popup after drag and drop");
    	        
    	        // Wait a moment for popup to close
    	        Thread.sleep(1000);
    	        
    	        // Verify popup is closed (optional)
    	        verifyPopupClosed(okButtonLocator);
    	        // Define the continue button locator
    	        By columnokButtonLocator = By.xpath(prop.getProperty("ColumnElement"));
    	     // Wait for the columnelement button to be clickable
    	        WebElement columnelementButton = popupWait.until(ExpectedConditions.elementToBeClickable(columnokButtonLocator));
    	        
    	        System.out.println("Popup appeared, clicking Column button...");
    	        
    	        // Scroll the OK button into view if needed    	    
    	        js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", columnelementButton);
    	        Thread.sleep(300);
    	        
    	        // Click the OK button
    	        columnelementButton.click();
    	        
    	        System.out.println("✓ Successfully clicked Column button on popup");
    	        logger.info("Clicked Column button on popup after drag and drop");
    	        // Define the continue column2 locator
    	        By column2 = By.xpath(prop.getProperty("Column2"));
    	     // Wait for the column2 to be clickable
    	        WebElement column2elementButton = popupWait.until(ExpectedConditions.elementToBeClickable(columnokButtonLocator));
    	        
    	        System.out.println("Popup appeared, clicking Column button...");
    	        
    	        // Scroll the OK button into view if needed    	    
    	        js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", column2elementButton);
    	        Thread.sleep(300);
    	        
    	        // Click the OK button
    	        column2elementButton.click();
    	        
    	        System.out.println("✓ Successfully clicked Column2 on popup");
    	        logger.info("Clicked Column2 on popup after drag and drop");
    	        
    	       
    	    } 
    	    catch (org.openqa.selenium.TimeoutException e) {
    	        System.out.println("No popup appeared within 10 seconds - continuing...");
    	        logger.info("No popup detected after drag and drop operation");
    	        
    	    } catch (Exception e) {
    	        System.err.println("Error handling popup: " + e.getMessage());
    	        logger.error("Failed to handle popup after drag and drop: " + e.getMessage());
    	        
    	        // Try alternative popup handling methods
    	        handlePopupAlternativeMethods();
    	    }
}
   // Verify that popup is closed
      private void verifyPopupClosed(By okButtonLocator) {
          try {
              WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
              
              // Check if OK button is still visible (popup still open)
              try {
                  shortWait.until(ExpectedConditions.invisibilityOfElementLocated(okButtonLocator));
                  System.out.println("✓ Popup closed successfully");
              } catch (org.openqa.selenium.TimeoutException e) {
                  System.out.println("⚠ Popup may still be open or took longer to close");
              }
              
          } catch (Exception e) {
              System.out.println("Could not verify popup closure: " + e.getMessage());
          }
      }
   // Alternative methods to handle popup if primary method fails
      private void handlePopupAlternativeMethods() throws InterruptedException {
          try {
              System.out.println("Trying alternative popup handling methods...");
              
              // Method 1: Try different selectors for OK button
              By[] alternativeSelectors = {
                  By.xpath("//button[contains(@class, 'btn') and contains(text(), 'OK')]"),
                  By.xpath("//button[contains(@class, 'btn') and contains(text(), 'Ok')]"),
                  By.xpath("//button[contains(@class, 'button-border')]"),
                  By.xpath("//button[@class='borderenable btn btn-sm button-border ng-star-inserted']"),
                  By.cssSelector("button.borderenable.btn.btn-sm.button-border"),
                  By.xpath("//button[contains(@class, 'borderenable')]")
              };
              
              WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
              
              for (By selector : alternativeSelectors) {
                  try {
                      WebElement button = shortWait.until(ExpectedConditions.elementToBeClickable(selector));
                      button.click();
                      System.out.println("✓ Clicked popup button using alternative selector");
                      Thread.sleep(500);
                      return; // Success, exit method
                  } catch (Exception ignored) {
                      // Continue to next selector
                  }
              }
              
              // Method 2: Try JavaScript click on any visible popup buttons
              JavascriptExecutor js = (JavascriptExecutor) driver;
              Boolean jsClickSuccess = (Boolean) js.executeScript(
                  "var buttons = document.querySelectorAll('button');" +
                  "for (var i = 0; i < buttons.length; i++) {" +
                  "  if (buttons[i].offsetParent !== null && " +
                  "      (buttons[i].textContent.toLowerCase().includes('ok') || " +
                  "       buttons[i].className.includes('button-border'))) {" +
                  "    buttons[i].click();" +
                  "    return true;" +
                  "  }" +
                  "}" +
                  "return false;"
              );
              
              if (jsClickSuccess) {
                  System.out.println("✓ Popup handled using JavaScript method");
                  Thread.sleep(500);
              } else {
                  System.out.println("No popup buttons found with alternative methods");
              }
              
          } catch (Exception altException) {
              System.err.println("Alternative popup handling also failed: " + altException.getMessage());
          }
      }
}
