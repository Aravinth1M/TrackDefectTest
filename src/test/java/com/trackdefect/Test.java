package com.trackdefect;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable notifications");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search for products,')]")).sendKeys("iphone"+Keys.ENTER);
				
			driver.findElement(By.xpath("//img[@alt='APPLE iPhone 13 Pro (Silver, 1 TB)']")).click();
			
			
			String parentwindow=	driver.getWindowHandle();
			Set<String> allwindows=driver.getWindowHandles();
			WebDriverWait wait=new WebDriverWait(driver, 15);
			for(String window:allwindows) {
			
			
				if(!parentwindow.equals(window)) {
				
				driver.switchTo().window(window);
				driver.findElement(By.xpath("//*[text()='ADD TO CART']")).click();
//				Thread.sleep(5000);
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Save for later']/following-sibling::div")));
//				driver.findElement(By.xpath("//div[text()='Save for later']/following-sibling::div")).click();
//			
//				//WebDriverWait wait=new WebDriverWait(driver, 15);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Cancel']/following-sibling::div[text()='Remove']")));
//			
//			driver.findElement(By.xpath("//div[text()='Cancel']/following-sibling::div[text()='Remove']")).click();			}
		}
			}
	}	
}
