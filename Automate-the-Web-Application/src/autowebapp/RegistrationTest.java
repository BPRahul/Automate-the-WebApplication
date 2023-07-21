package autowebapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
 
	private static String url = "https://www.marshallspetzone.com/";
	WebDriver wd;

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rahul\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize(); 
	}
	

	@Test(priority =1)
	  public void Register() throws InterruptedException {
		wd.get(url);
		wd.findElement(By.cssSelector(".header-btn.header-user-btn")).click();
		wd.findElement(By.linkText("No account? Create one here")).click();
		wd.findElement(By.cssSelector("input[name='id_gender'][value='1']")).click();
		wd.findElement(By.name("firstname")).sendKeys("Rahul");
		wd.findElement(By.name("lastname")).sendKeys("BP");
		wd.findElement(By.name("email")).sendKeys("bprahul92001@gmail.com");
		wd.findElement(By.name("password")).sendKeys("rahul@2001");
		Thread.sleep(9000);
		wd.findElement(By.xpath("//button[@class='btn btn-primary form-control-submit' and @data-link-action='save-customer' and contains(text(), 'Save')]")).click();
		Thread.sleep(9000);
	}
	@Test(priority=2)
	public void login()throws InterruptedException {
		wd.get(url);
		wd.findElement(By.cssSelector(".header-btn.header-user-btn")).click();
		wd.findElement(By.cssSelector("input.form-control[name='email']")).sendKeys("bprahul92001@gmail.com");
		wd.findElement(By.cssSelector("input.form-control.js-child-focus.js-visible-password[name='password']")).sendKeys("rahul@2001");
		Thread.sleep(9000);
		wd.findElement(By.id("submit-login")).click();
		Thread.sleep(9000);
		wd.findElement(By.id("identity-link")).click();
		Thread.sleep(7000);
	}
    
	@Test(priority =3)
	  public void searchandcart() throws InterruptedException {
		wd.get(url);
		wd.findElement(By.cssSelector(".header-btn.header-user-btn")).click();
		wd.findElement(By.cssSelector("input.form-control[name='email']")).sendKeys("bprahul92001@gmail.com");
		wd.findElement(By.cssSelector("input.form-control.js-child-focus.js-visible-password[name='password']")).sendKeys("rahul@2001");
		Thread.sleep(5000);
		wd.findElement(By.id("submit-login")).click();
		
		wd.findElement(By.cssSelector(".fa.fa-search.fa-fw.icon")).click();
		 WebElement searchInput = wd.findElement(By.name("s"));

	        // Type the search query into the search input
	        searchInput.sendKeys("dogs");
	        Thread.sleep(9000);
	        searchInput.submit();
	        Thread.sleep(8000);
	    wd.findElement(By.cssSelector(".thumbnail.product-thumbnail")).click();
	    Thread.sleep(8000);
	    wd.findElement(By.cssSelector(".btn.btn-primary.btn-lg.add-to-cart")).click();
	    Thread.sleep(9000);
	  }
	
	
	  
	  
    
}
