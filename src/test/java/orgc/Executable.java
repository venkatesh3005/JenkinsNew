package orgc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Executable {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sM\\eclipse-workspace\\JenkinsProject\\div\\chromedriver.exe");

		   WebDriver driver=new ChromeDriver();
		   driver.get("https://www.facebook.com/");
		   
			driver.findElement(By.id("email")).sendKeys("Hello");
			
			driver.findElement(By.id("pass")).sendKeys("1565121");
			
			driver.findElement(By.id("loginbutton")).click();
			
	}
}
