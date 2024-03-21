package EcommerceMain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class ProductCatalog extends  AbstractComponent {
	WebDriver driver;
	
    public ProductCatalog(WebDriver driver) {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
   @FindBy(id="twotabsearchtextbox") 
   WebElement searchbox;
   @FindBy(id="nav-search-submit-button") 
   WebElement search;
   @FindBy(css="h2.a-size-mini.s-line-clamp-1") 
    List <WebElement> AllShoes;
   @FindBy(css="img[alt='Adidas Mens Fluento M Running Shoe")
   WebElement SelectedShoe; 
   @FindBy(css="h2.a-size-mini.s-line-clamp-1")
   WebElement listOfShoes;
  
    By ListOfShoes = By.cssSelector("h2.a-size-mini.s-line-clamp-1");
   
   public void GetShoe(String adidasshoesformen ) {
	   searchbox.sendKeys(adidasshoesformen);
	   search.click();

	   for (int i = 1; i < AllShoes.size(); i++) {
			String Shoename = AllShoes.get(i).getText();

			if (Shoename.contains("adidas")) {

				SelectedShoe.click();
				break;
			}

		}
	   
   }
   public CheckOutPage SwitchWindow() {
		driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
		CheckOutPage ckout = new CheckOutPage(driver);
		return ckout;
   
   }  
  
} 



/*WebElement element = driver.findElement(By.id("native_dropdown_selected_size_name"));
			Select dropdown = new Select(element);
			dropdown.selectByIndex(5);
 * 
 * 
 * driver.findElement(By.id("twotabsearchtextbox")).sendKeys("adidas shoes for men");
 */
//driver.findElement(By.id("nav-search-submit-button")).click();
//List<WebElement> AllShoes = driver.findElements(By.cssSelector("h2.a-size-mini.s-line-clamp-1"));*/