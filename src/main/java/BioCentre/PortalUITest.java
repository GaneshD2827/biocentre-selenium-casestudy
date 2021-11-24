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
import org.testng.annotations.Test;

public class PortalUITest {
	
	WebDriver Ch_driver;
	@Test(priority = 1, description="Beginning the test.")
		
	public void UITest1_Start() 
	{
		
	System.out.println("Test Started");
	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(priority = 2, description="Open the browser and load the website under test")
		
	public void UITest2_LoadWebsite() throws InterruptedException 
	{
	
	String ppath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", ppath+"/Drivers/Chromedriver/chromedriver.exe");
	System.out.println("Opening The Browser");
	Ch_driver = new ChromeDriver();
	Ch_driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	Ch_driver.manage().window().maximize();
	System.out.println("Browser Launched Successfully!");
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
		//Set<String> handles = Ch_driver.getWindowHandles();
		//Ch_driver.switchTo().window(handles.toArray(new String[] {})[0]);
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
		
		
		//Ch_driver.navigate().back();
		//Ch_driver.switchTo().defaultContent();
	
	}

	
	
	//@Test(priority = 4, description="Download Rare Disease study Cohort (RDC) spreadsheet and save it in a directory")

	//public void UITest4_RDCDownload() 
	//{
	
	//WebElement RDC = Ch_driver.findElement(By.xpath("//a[@href='https://nationalbioresource-my.sharepoint.com/:x:/g/personal/lmb81_bioresource_nihr_ac_uk/ERXVvttELF5OmaX6Dq1d-xQBdh-K9FRbmY_xdC0V71RCAA']"));
	//String RDC_Text1 = RDC.getText();
	//Assert.assertEquals(RDC_Text1, "Rare Disease study Cohort (RDC)");
	//System.out.println("Rare Disease study Cohort (RDC) link identified successfully");
	//RDC.click();
	
	//@SuppressWarnings("deprecation")

	//WebElement iframe1 = new WebDriverWait(Ch_driver,30).until(ExpectedConditions.presenceOfElementLocated(By.id("WebApplicationFrame")));
	//Ch_driver.switchTo().frame(iframe1);
	//WebDriverWait wait = new WebDriverWait(Ch_driver,30);
	//WebElement FileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FileMenuLauncherContianer")));
	
	//System.out.println(FileBtn.getText());
	
	//FileBtn.isEnabled();
	//System.out.println("Button enabled");
	//FileBtn.click();
	//System.out.println("Button clicked");
	
	//WebElement SavBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FileSaveAsPage")));
	//System.out.println(SavBtn.getText());
	//SavBtn.click();
	
	//WebElement DownloadCopy = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".flexContainer-240")));
	
	//DownloadCopy.click();
	
	//Ch_driver.navigate().back();
	//Ch_driver.switchTo().defaultContent();
	//}

}


