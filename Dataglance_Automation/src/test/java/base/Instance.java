package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instance {

	public static WebDriver driver;

    public static WebDriver getInstance()       {
        if (driver == null) 
         {ChromeOptions options = new ChromeOptions();
         options.addArguments("--headless=new");  // Or "--headless"

         // Initialize driver with options
         driver = new ChromeDriver(options);
                WebDriverManager.chromedriver().setup();  
                 ChromeOptions options1 = new ChromeOptions();
                 driver = new ChromeDriver(options1);
         }
         return driver;
       }
}