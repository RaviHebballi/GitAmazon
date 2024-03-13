package EcommerceMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class HomePage extends  AbstractComponent {

	WebDriver driver;
	
	    public HomePage(WebDriver driver) {
	    	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		  
		  
	    @FindBy(id="nav-link-accountList-nav-line-1")
		  WebElement signin;

		@FindBy(id="ap_email")
		  WebElement userId;
		  @FindBy(id="continue")
		  WebElement continu;
		  @FindBy(id="ap_password")
		  WebElement userpasswrd;
		  
		  public  void HomePageApplication(String UserNumber,String Passward) {
			  signin.click();
			  userId.sendKeys(UserNumber);
			  continu.click();
			  userpasswrd.sendKeys(Passward);
		  }
		  
		  public void GoTo() {
			  driver.get("https://www.amazon.in");
			  
		  }

		
		}
	

/*	 driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
 * driver.findElement(By.id("ap_email")).sendKeys("8073329004");
driver.findElement(By.id("continue")).click();
driver.findElement(By.id("ap_password")).sendKeys("Ravi@1199");*/
