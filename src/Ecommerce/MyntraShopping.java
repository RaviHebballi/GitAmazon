package Ecommerce;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.io.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.domstorage.model.Item;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import EcommerceMain.CheckOutPage;
import EcommerceMain.HomePage;
import EcommerceMain.ProductCatalog;
import dev.failsafe.internal.util.Assert;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.ITesseract;

public class MyntraShopping {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

		System.setProperty("webdriver.driver.chrome", "C:\\Users\\DELL\\Downloads\\chromedriver-win64.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage hmepage = new HomePage(driver);
		hmepage.GoTo();
		hmepage.HomePageApplication("8073329004", "Ravi@1199");
		/*
		 * driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		 * driver.findElement(By.id("ap_email")).sendKeys("8073329004");
		 * driver.findElement(By.id("continue")).click();
		 * driver.findElement(By.id("ap_password")).sendKeys("Ravi@1199");
		 * driver.findElement(By.id("signInSubmit")).click();
		 * 
		 * WebElement imageEle =
		 * driver.findElement(By.cssSelector("img[alt='captcha']")); File screnShot =
		 * imageEle.getScreenshotAs(OutputType.FILE); String path =
		 * "C:\\Users\\DELL\\eclipse-workspace\\RaviAutomates\\captcha\\cptig.PNG";
		 * FileHandler.copy(screnShot, new File(path)); Thread.sleep(2000); ITesseract
		 * image = new Tesseract(); try { System.out.println(image.doOCR(new
		 * File(path)));
		 * 
		 * // driver.findElement(By.cssSelector("input[name='cvf_captcha_input']")).
		 * sendKeys(capt); // System.out.println(capt); } catch(TesseractException e) {
		 * String capt = image.doOCR(new File(path));
		 * driver.findElement(By.cssSelector("input[name='cvf_captcha_input']")).
		 * sendKeys(capt); System.out.println(capt); }
		 */

		driver.get("https://www.amazon.in/?ref_=nav_ya_signin");

		ProductCatalog Pc = new ProductCatalog(driver);
		Pc.GetShoe("Adidas Shoes For Men");
		driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
		CheckOutPage ckout = new CheckOutPage(driver);
		ckout.SelectColor();
        ckout.SelectSize();
	    ckout.AddToCart();
		ckout.VerifyConfirmText();
		System.out.println("Test complete");
        driver.quit(); 
	}

}
