package webAutomation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class autoTestClass {

  private WebDriver driver;
  static private String url ="https://www.google.com";
  
  @BeforeClass
  public void beforeClass() {
      driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
      driver.quit();
  }

  @BeforeTest
  public void beforeTest(){
	  System.out.println("ToDo before test - login");
  }
  
  @AfterTest
  public void afterTest(){
	  System.out.println("ToDo before test - Logout");
  }
  
  
  @Test
  public void verifySearchButton() {
	  //Given wait 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      driver.get(url);
      String search_text = "Google Search";
     
      WebElement search_button = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
      String text = search_button.getAttribute("value");
      
      WebElement search_box = driver.findElement(By.xpath("//*[@id='lst-ib']"));
      search_box.click();
      search_box.sendKeys("test");
      search_button.click();

      Assert.assertEquals(text, search_text, "Text not found!");
  }
}