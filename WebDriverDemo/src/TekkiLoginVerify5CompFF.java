import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TekkiLoginVerify5CompFF{
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private static StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public static  void  setUp() throws Exception {
	  System.out.println("reached here1 ff");
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Documents\\webdrivers\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.0.244:8000/";
   // baseUrl = "http://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    System.out.println("reached here ff");
  }

  @Test
  public void testTekkiLoginVerify5Components() throws Exception {
    driver.get(baseUrl + "/auth/login?next=%2F");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("jayesh");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("jayesh");
    driver.findElement(By.name("user_login")).click();
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
