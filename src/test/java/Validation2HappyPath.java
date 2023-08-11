import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 *
 * @author Alex
 */
public class Validation2HappyPath {
    
    public class TestNG {
    WebDriver driver ;
    WebDriverWait wait;
    @Test
    public void tst() {
	   String baseUrl = "http://localhost:3000";
	   driver = new EdgeDriver();
           wait= new WebDriverWait(driver, Duration.ofSeconds(2));
	   driver.get(baseUrl);
           driver.findElement(By.xpath("//*[@id='root']/div/main/section[1]"));
           driver.findElement(By.xpath("//*[@id='root']/div/main/form/div/label"));
           driver.findElement(By.id("username"));           
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
           driver.findElement(By.id("username")).sendKeys("123",Keys. RETURN);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/section[1]/p/strong")));
           String success=driver.findElement(By.xpath("/html/body/div/div/main/section[1]/p/strong")).getText();
           Assert.assertEquals(success, "Success!");
           
   }
	
   @BeforeMethod
    public void beforeMethod() {
	
    }
	
    @AfterMethod
     public void afterMethod() {
	 driver.close();
	 
    }
}
    
}
