package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DgUrl {

	WebDriver driver = Instance.getInstance();
    
	 Properties prop = PropertiesFile.readPropertyFile("dg_datafile.properties");
	    
	    @Test(priority=1, enabled=true)
	    public void Login() throws InterruptedException {
	        driver.manage().window().maximize();
	        Thread.sleep(3000);
	        driver.get(prop.getProperty("baseUR"));
	        Thread.sleep(4000);
	        System.out.println("Successfully landed  to data glance site ");
	}
}