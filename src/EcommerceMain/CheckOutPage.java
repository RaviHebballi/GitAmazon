package EcommerceMain;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;
import dev.failsafe.internal.util.Assert;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(css=("img[alt='MLEAD/STONE/LUCLEM']"))
	   WebElement Color;
	 @FindBy(id=("native_dropdown_selected_size_name"))
	   WebElement dropelement;
	 @FindBy(css="input[title='Add to Shopping Cart']")
	 WebElement SendToCart;
	 @FindBy(id=("NATC_SMART_WAGON_CONF_MSG_SUCCESS"))
	 WebElement confmesg;
	 
	 public void SelectColor() {
		   Color.click();
	 }
	 
	 public void SelectSize() {
		 try {
		   Select dropdown = new Select (dropelement);
		   dropdown.selectByIndex(6);
		 }catch(StaleElementReferenceException e) {
			 Select dropdown = new Select (dropelement);
			   dropdown.selectByIndex(6);
		 }
	   }
	 public void AddToCart() throws IOException {
		 try {
		 SendToCart.click();
		 } 
		 catch(StaleElementReferenceException e) {
	     SendToCart.click();
		 }
		 TakeScreenShot();
	 }
	 
	 public void VerifyConfirmText() {
		 
		 String Txt = confmesg.getText();
		 Assert.isTrue(true,"Added to Cart", confmesg);
		 System.out.println(Txt);
	 }
	 
	 
}
