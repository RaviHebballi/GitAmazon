package BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommerceMain.HomePage;

public class BaseTest {
	public WebDriver driver;
	
	public WebDriver BrowserInitilizer(WebDriver driver) throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\GitAmazon\\src-main\\GlobalProperties\\GlobalData.properties");
		pro.load(fis);
		String BrowserName = pro.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.driver.chrome", "C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver2.exe");
			driver = new ChromeDriver();
		}
		if (BrowserName.equalsIgnoreCase("Firefox")) 
		{
			//Firefox
		}
		
		else
		{
			// Edge
		}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	@BeforeTest
	public HomePage lounchApp() throws IOException {
		driver=BrowserInitilizer(driver);
		HomePage hmepage = new HomePage(driver);
		hmepage.GoTo();
		return hmepage;
	}
}
