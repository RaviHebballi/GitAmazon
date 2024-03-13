package AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent  {
	WebDriver driver;
	String path = "C:\\Users\\DELL\\eclipse-workspace\\RaviAutomates\\ScreenShots\\screenshot1.png";
	public  AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
	}
	
	

	public void WaitForVisibilityOfEle(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(9000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("findby")));
//		h2.a-size-mini.s-line-clamp-1
	}
	
	public void TakeScreenShot() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file,new File(path));
	}

}
