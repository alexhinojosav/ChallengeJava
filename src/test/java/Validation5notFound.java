/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Alex
 */
public class Validation5notFound {
    
  public class TestNG {
    WebDriver driver ;
    WebDriverWait wait;
    @Test
    public void tst1() {
	   String baseUrl = "http://localhost:3000";
	   driver = new EdgeDriver();
            wait= new WebDriverWait(driver, Duration.ofSeconds(2));
	   driver.get(baseUrl);
           driver.findElement(By.xpath("//*[@id='root']/div/main/section[1]"));
           driver.findElement(By.xpath("//*[@id='root']/div/main/form/div/label"));
           driver.findElement(By.id("username"));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
           driver.findElement(By.id("username")).sendKeys("@--=+",Keys. RETURN);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/section[1]/p/strong")));
           String failure=driver.findElement(By.xpath("/html/body/div/div/main/section[1]/p/strong")).getText();
           Assert.assertEquals(failure, "Github user not found");

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
