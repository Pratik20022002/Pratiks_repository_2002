package com.demo_automationtesting.libraries;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class DriverSetup {
	public static WebDriver driver;
	public static String url ="http://demo.automationtesting.in/Alerts.html";
	public static String browsertype;
	
	public static WebDriver driverInitiate(String browser) {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);		
		return driver;
	}
	public static void driverQuit() {
		driver.quit();
	}

 
}
