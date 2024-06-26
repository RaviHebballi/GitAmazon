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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import BaseTest.BaseTest;
import EcommerceMain.CheckOutPage;
import EcommerceMain.HomePage;
import EcommerceMain.ProductCatalog;
import dev.failsafe.internal.util.Assert;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.ITesseract;

public class ErrorCheck extends BaseTest {
	  
@Test
public void ErrorCheckd() throws IOException{
	HomePage hmepage = lounchApp();
	ProductCatalog Pc= hmepage.HomePageApplication("8073329004", "Ravi@1199");
	
   SoftAssert sf = new SoftAssert();
	Pc.GetShoe("Adidas Shoes For Men");
    Pc.SwitchWindow();
    
    CheckOutPage ckout = Pc.SwitchWindow();
    ckout.SelectColor();
    ckout.SelectSize();
    ckout.AddToCart();
	String confmesg = Pc.toString();
	sf.assertNotEquals(confmesg, "Error in confm mesg ");
//	sf.assertEquals(confmesg, "Error confm mesg ");
    System.out.println("Test complete");
	sf.assertAll();
	
 }
}
