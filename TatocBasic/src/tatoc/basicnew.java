package tatoc;

import java.io.File;

//import javax.servlet.http.Cookie;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

//import javafx.scene.control.Alert;
//import java.lang.*;

import org.openqa.selenium.firefox.FirefoxBinary;
public class basicnew {

	public static void main(String[] args) throws  InterruptedException {
		File binaryPath=new File("/home/anuraggarg/Downloads/firefox/firefox");
		FirefoxBinary ffbinary=new FirefoxBinary(binaryPath);
		FirefoxProfile ffprofile=new FirefoxProfile();
		WebDriver driver=new FirefoxDriver(ffbinary,ffprofile);
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		//driver.get("10.0.1.86");
		Thread.sleep(2000);
		driver.findElement(By.className("greenbox")).click();
		Thread.sleep(3000);
		//WebElement link=driver.findElement(By.linkText("Proceed"));
		//link.click();
		driver.switchTo().frame("main");
		String box1=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		driver.switchTo().frame("child");
		String box2=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		System.out.println(box1);
		System.out.println(box2);
		
		while(!box1.equals(box2))
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			Thread.sleep(1000);
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			box2=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
			System.out.println(box2);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.linkText("Proceed")).click();
		
		
		WebElement element = driver.findElement(By.id("dragbox"));
		WebElement target = driver.findElement(By.id("dropbox"));

		(new Actions(driver)).dragAndDrop(element, target).perform();
		/*if(element.getLocation()==target.getLocation())
		{
			driver.findElement(By.linkText("Proceed")).click();
		}
		else*/
		Thread.sleep(1000);
			driver.findElement(By.linkText("Proceed")).click();
			
			
			/*driver.findElement(By.linkText("Launch Popup Window")).click();
			//String handle = driver.getWindowHandle().toArray()[1].toString();
			//driver.toString().window(handle);
			driver.findElement(By.id("name")).sendKeys("happy");
			driver.findElement(By.id("submit")).click();*/
			
			
			driver.findElement(By.linkText("Launch Popup Window")).click();
			 String firstWinHandle = driver.getWindowHandle();
	            for(String webHand: driver.getWindowHandles()){
	                driver.switchTo().window(webHand);
	             }
	           Thread.sleep(2000);
	            driver.findElement(By.cssSelector("input#name")).sendKeys("Anurag");
	            Thread.sleep(1000);
	            driver.findElement(By.cssSelector("input#submit")).click();
	            driver.switchTo().window(firstWinHandle);
	            driver.findElement(By.linkText("Proceed")).click();
			
			
			
			driver.findElement(By.linkText("Generate Token")).click();
			String token=driver.findElement(By.id("token")).getText();
			String[] arr=token.split(": ");
			Cookie cookie=new Cookie("Token",arr[1]);
			driver.manage().addCookie(cookie);
			driver.findElement(By.linkText("Proceed")).click();
		/*if(box1.equals(box2))
		{
			
		}
		else
		{
			
			driver.switchTo().frame("main");
			while(box1.equals(box2));
				{
					driver.findElement(By.linkText("Repaint Box 2")).click();;
					//Thread.sleep(2000);
				}
				driver.findElement(By.linkText("Proceed")).click();*/
			
		
		//String box3=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
			//System.out.println(box3);
			//driver.findElement(By.linkText("Proceed")).click();
			//driver.switchTo().defaultContent();
		}
		//driver.findElement(By.linkText("Proceed"));
		//driver.findElements(By.id("answer")).get(0).click();
		//driver.findElement(By.xpath("a[linkText()='Proceed']"));
		//else
			//driver.findElement(By.className("redbox")).click();
	}


