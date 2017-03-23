import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TekkiLoginVerify5CompIE{
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private static StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public static  void  setUp() throws Exception {
	  System.out.println("reached here1 ie");
	  System.setProperty("webdriver.ie.driver","C:\\Users\\admin\\Documents\\webdrivers\\IEDriverServer.exe");
	        driver = new InternetExplorerDriver();
    baseUrl = "http://192.168.0.244:8000/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    System.out.println("reached here ie");
  }

  @Test
  public void testTekkiLoginVerify5Components() throws Exception {
    driver.get(baseUrl + "/auth/login?next=%2F");
    driver.navigate().refresh();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("jayesh");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("jayesh");
    driver.findElement(By.name("user_login")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    System.out.println("reached here ie after");
   
    try {
      assertEquals(driver.findElements(By.xpath("//div[@id='container']/div/div[2]/div[2]/div[2]/div/ul/li[1]/div")).size(), 1);
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElements(By.xpath("//div[@id='container']/div/div[2]/div[2]/div[2]/div/ul/li[2]/div")).size(), 1);
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElements(By.xpath("//div[@id='container']/div/div[2]/div[2]/div[2]/div/ul/li[3]/div")).size(), 1);
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElements(By.xpath("//div[@id='container']/div/div[2]/div[2]/div[2]/div/ul/li[4]/div")).size(), 1);
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElements(By.xpath("//div[@id='container']/div/div[2]/div[2]/div[2]/div/ul/li[5]/div")).size(), 1);
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterClass
  public static void tearDown() throws Exception {
//    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
