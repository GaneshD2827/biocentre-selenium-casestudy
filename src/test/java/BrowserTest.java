import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	public static void main(String[] args) {
		String ppath = System.getProperty("user.dir");
		//System.out.println("DIR Path" + ppath);
		//System.setProperty("webdriver.gecko.driver", ppath+"/Drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", ppath+"/Drivers/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", ppath+"/Drivers/IEdriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		driver.get("https://google.com/");
		// textbox = driver.findElement(By .xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]"));
		int count = driver.findElements(By .xpath("//input")).size();
		java.util.List<WebElement> inputlist = driver.findElements(By .xpath("//input"));
		System.out.println("Count " +count);
		System.out.println(inputlist);
		//textbox.sendKeys("Hello World");
		//try {
			//Thread.sleep(3000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//driver.close();
	}
}
