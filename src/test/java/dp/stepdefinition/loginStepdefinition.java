package dp.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dpUtilities.Driver;

public class loginStepdefinition extends Driver{
	
	public loginStepdefinition() {
		super();
	}
	 
	@Given("^User is on dp home page$")
	public void User_is_on_dp_home_page() { 
		
		driver = new ChromeDriver();
		driver.get("https://www.dynamicplanner.com/");
	}	
	
	@When ("^title of home page is Dynamic Planner$")
	public void title_of_home_page_is_Dynamic_Planner() {
		
		String title=driver.getTitle();
		System.out.println(title);
	    Assert.assertEquals("Dynamic Planner | Ensuring Investment Suitability", title);
	    driver.manage().window().maximize();
	}
	    
	 
	@Then("^user moves to login page and click to try it now button$")
	public void user_moves_to_login_page_and_click_to_try_it_now_button() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click(); 
			
		driver.findElement(By.xpath("//div/div[2]/div/div[2]/div/a")).click();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
	    System.out.println("2" +driver.getTitle());
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	    driver.findElement(By.xpath("//*[@id=\"elementsButton\"]")).click();

	    for(String winHandle : driver.getWindowHandles()){
	       driver.switchTo().window(winHandle);
		}
	}
	
	@Then("^user login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_login_with_username_and_password(String username, String password) {
		 for(String winHandle : driver.getWindowHandles()){
		       driver.switchTo().window(winHandle);
			}
		
		 
		 
		// WebDriverWait wait = new WebDriverWait(driver, 5); // 5 seconds timeout
		   // wait.until(ExpectedConditions.textToBe(By.xpath("//div/div[2]/div/div[2]/div/div[1]/div/div/h1/span"), "Login to Dynamic Planner"));
		
		    
		   
		    
	    driver.findElement(By.id("Username")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"formHolder\"]/form/div[3]/button")).click();
		sleep(5000);
		
	}
	
	@Then("^user get verification$")
	public void  user_get_verification() {
		//driver.findElement(By.xpath("//*[@id=\"formHolder\"]/div/ul/li[1]")).getText();
		//System.out.println("The Username field is required.");
		
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"formHolder\"]/div/ul/li[1]"));
		String expectedErrorMessage = "Username / password not found or your account is locked.";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
		sleep(3000);
	}
	
	@Then("^close browser$")
	public void close_browser() {
		driver.close();
	}
	
	private void sleep(long milles) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(milles);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	}


