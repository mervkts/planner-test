package dpUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public abstract class Driver {
	 protected WebDriver driver;
	    private static String osName = System.getProperty("os.name").toLowerCase();

	    public Driver() {
	        ChromeOptions chromeOptions = new ChromeOptions(); 

	        if(osName.contains("windows")) {
	            System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	        }
	        else {
	            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	            chromeOptions.addArguments("--headless");
	            chromeOptions.addArguments("--no-sandbox");
	        }

	       // driver = new ChromeDriver(chromeOptions);
	       
	        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	      //  driver.get("https://www.dynamicplanner.com/");
	    }


}
