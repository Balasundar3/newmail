package com.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class classe  {
	public static WebDriver driver;
	@Test
	private void tc1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

	@Parameters({"User","Pass"})
	@Test
	private void tc2(String email, String password) {
		
		WebElement oo = driver.findElement(By.id("email"));
		oo.sendKeys(email);
		
	WebElement pass = driver.findElement(By.name("pass"));
pass.sendKeys(password);
	}

}
