package org.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Executable {


	WebDriver driver;
	@Given("user is in home page and selects add customer option")
	public void user_is_in_home_page_and_selects_add_customer_option() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sM\\eclipse-workspace\\JenkinsProject\\div\\chromedriver.exe");
		  driver =new ChromeDriver();
		  driver.get("http://demo.guru99.com/telecom/");
		  driver.manage().window().maximize();
		  
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("user enters cutomer details with firstname and lastname")
	public void user_enters_cutomer_details_with_firstname_and_lastname(io.cucumber.datatable.DataTable d) throws Exception {
	
		List<String> li = d.asList(String.class);
		driver.findElement(By.xpath("//label[@for='done']")).click();
		
		driver.findElement(By.id("fname")).sendKeys(li.get(0));
		driver.findElement(By.id("lname")).sendKeys(li.get(1));
		driver.findElement(By.id("email")).sendKeys(li.get(2));
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(li.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(li.get(4));
		Thread.sleep(4000);
	}

	@When("user clicks submit button")
	public void user_clicks_submit_button() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@type='submit']")) );
	
	 Thread.sleep(3000);
	}

	@Then("customer id should be generated")
	public void customer_id_should_be_generated() {
	 String url = driver.getCurrentUrl();
	 Assert.assertTrue(url.contains("uid"));
	 
	 driver.quit();
	}

}
