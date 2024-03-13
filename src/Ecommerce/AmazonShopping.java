package Ecommerce;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import net.sourceforge.tess4j.TesseractException;

public class AmazonShopping {
	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

		System.setProperty("webdriver.driver.chrome", "C:\\Users\\DELL\\Downloads\\chromedriver-win64.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  driver.get("https://www.amazon.in");
		  driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		  driver.findElement(By.id("ap_email")).sendKeys("8073329004");
		  driver.findElement(By.id("continue")).click();
		  driver.findElement(By.id("ap_password")).sendKeys("Ravi@1199");
		/*  driver.findElement(By.id("signInSubmit")).click();
		  
	WebElement imageEle = driver.findElement(By.cssSelector("img[alt='captcha']"));
		 File screnShot = imageEle.getScreenshotAs(OutputType.FILE);
		 String path = "C:\\Users\\DELL\\eclipse-workspace\\RaviAutomates\\captcha\\cptig.PNG";
		 FileHandler.copy(screnShot, new File(path));
		 Thread.sleep(2000);
		 ITesseract image = new Tesseract();
		 try {
		System.out.println(image.doOCR(new File(path)));
		
//		 driver.findElement(By.cssSelector("input[name='cvf_captcha_input']")).sendKeys(capt);
//		 System.out.println(capt);
		 } catch(TesseractException e) {
			 String capt = image.doOCR(new File(path));
			 driver.findElement(By.cssSelector("input[name='cvf_captcha_input']")).sendKeys(capt);
			 System.out.println(capt);
		}*/
		
		 
		driver.get("https://www.amazon.in/?ref_=nav_ya_signin");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("adidas shoes for men");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> AllShoes = driver.findElements(By.cssSelector("h2.a-size-mini.s-line-clamp-1"));

		for (int i = 1; i < AllShoes.size(); i++) {
			String Shoename = AllShoes.get(i).getText();

			if (Shoename.contains("adidas")) {

				driver.findElement(By.cssSelector("img[alt='Adidas Mens Fluento M Running Shoe']")).click();
				break;
			}

		}

		driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
		driver.findElement(By.cssSelector("img[alt='MLEAD/STONE/LUCLEM']")).click();
		try {
			
			WebElement element = driver.findElement(By.id("native_dropdown_selected_size_name"));
			Select dropdown = new Select(element);
			dropdown.selectByIndex(5);
		} catch (StaleElementReferenceException e) {
//			driver.navigate().refresh();
			WebElement element = driver.findElement(By.id("native_dropdown_selected_size_name"));
			Select dropdown = new Select(element);
			dropdown.selectByIndex(5);
		}
		try {
			driver.findElement(By.cssSelector("input[title='Add to Shopping Cart']")).click();
		} catch (StaleElementReferenceException e) {
//			driver.navigate().refresh(); // added to refresh page and avoid stale element exception.
			driver.findElement(By.cssSelector("input[title='Add to Shopping Cart']")).click();
		}
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("C:\\Users\\DELL\\eclipse-workspace\\RaviAutomates\\CaptchaImages\\screenshott.png" ));

		String cnfmsg = driver
				.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS")).getText();
		Assert.isTrue(true, "Added to Cart", cnfmsg);
		System.out.println("Test complete");
//        driver.close(); 
	}

}

