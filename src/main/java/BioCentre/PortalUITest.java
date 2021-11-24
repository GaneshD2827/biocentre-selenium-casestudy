package BioCentre;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PortalUITest {
	
	WebDriver Ch_driver;
	@BeforeMethod
	
	public void initsetup()
	{
		String ppath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ppath+"/Drivers/Chromedriver/chromedriver.exe");
		System.out.println("Opening The Browser");
		Ch_driver = new ChromeDriver();
		Ch_driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		Ch_driver.manage().window().maximize();
		System.out.println("Browser Launched Successfully!");
	}
	
	@AfterMethod
	
	public void closure()
	{
		if (Ch_driver != null)
		{
			Ch_driver.quit();
		}
	}
	@Test(priority = 1, description="Beginning the test.")
		
	public void UITest1_Start() 
	{
		
	System.out.println("Test Started");
	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(priority = 2, description="Open the browser and load the website under test")
		
	public void UITest2_LoadWebsite() throws InterruptedException 
	{
	
	
	Ch_driver.get("https://bioresource.nihr.ac.uk/recruiters/site-codes/");
	WebElement ActCookieBtn = new WebDriverWait(Ch_driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("ccc-notify-accept")));
	
	ActCookieBtn.click();
	System.out.println("Website Loaded Successfully!");	
	
	}

	
	@Test(priority = 3, description="Download Inflammatory Bowel Disease spreadsheet and save it in a directory")

	public void UITest3_IBDDownload() 
	{
		String ChkText1 = "Site Codes";
		WebElement SiteCodes = Ch_driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/h1[1]"));
		String ChkText2 = SiteCodes.getText();
		Assert.assertEquals(ChkText1, ChkText2);
		System.out.println("Page identified successfully");
		
		WebElement IBD = Ch_driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/p[2]/a[1]"));
		String IBD_Text1 = IBD.getText();
		Assert.assertEquals(IBD_Text1, "Inflammatory Bowel Disease (RTB-IBD)");
		System.out.println("Inflammatory Bowel Disease link identified successfully");
		IBD.click();
		@SuppressWarnings("deprecation")
		
		WebElement iframe1 = new WebDriverWait(Ch_driver,30).until(ExpectedConditions.presenceOfElementLocated(By.id("WebApplicationFrame")));
		Ch_driver.switchTo().frame(iframe1);
		WebDriverWait wait = new WebDriverWait(Ch_driver,30);
		WebElement FileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FileMenuLauncherContianer")));
		
		FileBtn.isEnabled();
		
		FileBtn.click();
		
		WebElement SavBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FileSaveAsPage")));
		
		SavBtn.click();
		
		WebElement DownloadCopy = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".flexContainer-240")));
		
		DownloadCopy.click();
		
				
	
	}


}


