package dp.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class LoginUnitTest {

	WebDriver driver;
	final String inCorrectUsername = "test";
	final String inCorrectPassword = "123";
	final String blankUsername = " ";
	final String blankPassword =" ";

	@Test
	public void BlankUsername() {
		System.out.println("ayah"+inCorrectUsername);
		driver.findElement(By.id("Username")).sendKeys(blankUsername);
		driver.findElement(By.id("Password")).sendKeys(blankPassword);
		driver.findElement(By.xpath("//*[@id=\"formHolder\"]/form/div[3]/button")).click();	
		
		
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"formHolder\"]/div/ul/li[1]")); 
		String expectedErrorMessage = "The Username field is required.";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}

	@Test
	public void IncorrectUsername() {
		
		// 4.user login with "<username>" and "<pasword>"

		driver.findElement(By.id("Username")).sendKeys(inCorrectUsername);
		driver.findElement(By.id("Password")).sendKeys(inCorrectPassword);
		driver.findElement(By.xpath("//*[@id=\"formHolder\"]/form/div[3]/button")).click();

		// 5.user get verification

		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"formHolder\"]/div/ul/li[1]"));
		String expectedErrorMessage = "Username / password not found or your account is locked.";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.dynamicplanner.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// 1.title of home page is Dynamic Planner
				String title = driver.getTitle();
				System.out.println(title);
				Assert.assertEquals("Dynamic Planner | Ensuring Investment Suitability", title);

				// 2.user moves to login page and click to try it now button

				driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

				driver.findElement(By.xpath("//div/div[2]/div/div[2]/div/a")).click();

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}

				// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				driver.findElement(By.xpath("//*[@id=\"elementsButton\"]")).click();

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
	}

	@After
	public void teardown() {
		driver.quit();
	}
}

// switch the window to the pop up

// ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
// driver.switchTo().window(windows.get(1));
