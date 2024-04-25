//Test Cases and Main Method

package com.demo_automationtesting.testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo_automationtesting.libraries.DriverSetup;

public class AlertHandling extends DriverSetup {
	public static WebDriver driver;
	public static String browser="Edge";
	public static WebElement SwitchTo,Alerts,AlertWithOk,ClickTheButtonAlertBox,AlertWithOkandCancel,ClickTheButtonConfirmBox,MessageDisplayed1,AlertWithTextBox,ClickTheButtonPromptBox,MessageDisplayed2;
	
	public static void createDriver(String browser) 
	{
		driver=DriverSetup.driverInitiate(browser);
	}
	
	public static void mouseAction() 
	{
		WebElement SwitchTo = driver.findElement(By.linkText("SwitchTo"));
		Actions actions = new Actions(driver);
		actions.moveToElement(SwitchTo).build().perform();
	}
	
	public static void clickAlerts() 
	{
		driver.findElement(By.linkText("Alerts")).click();
	}
	
	public static void clickAlertWithOk() 
	{
		driver.findElement(By.cssSelector(".analystic[href='#OKTab']")).click();
	}
	
	public static void displayAlertBox() 
	{
		try{
			driver.findElement(By.cssSelector(".btn.btn-danger")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alertwin1 = driver.switchTo().alert(); 							//		•	Check whether alert pop up appears or not.
			alertwin1.accept(); 													//		•	Click on “OK”
			System.out.println("Alert pop up appeared and clicked on OK.");
		}catch(Exception e) {
			System.out.println("Alert pop up not appeared.");
		}
	}
	
	public static void clickAlertWithOkandCancel() 
	{
		driver.findElement(By.cssSelector(".analystic[href='#CancelTab']")).click();
	}
	
	public static void displayConfirmBox() 
	{
		try {
			driver.findElement(By.cssSelector(".btn.btn-primary")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alertwin2 = driver.switchTo().alert();							//		•	Check whether confirm box pop up appears or not.
			alertwin2.dismiss();													//		•	Click on “Cancel” and check the respective message displayed
			System.out.println("Confirm box pop up appeared.");
		}catch(Exception e) {
			System.out.println("Confirm box pop up not appeared.");
		}
	}
	
	public static void message1() 
	{
		String act_msg = "You Pressed Cancel";
		String exp_msg = "";
		WebElement msg1 = driver.findElement(By.id("demo"));
		exp_msg = msg1.getText();
		System.out.println(msg1.getText());
		if(act_msg.equals(exp_msg)) {
			System.out.println("Respective message is displayed.");
		}else {
			System.out.println("Respective message is not displayed.");
		}
	}
	
	public static void clickAlertWithTextbox() 
	{
		driver.findElement(By.cssSelector(".analystic[href='#Textbox']")).click();
	}
	
	public static void displayPromptBox() 
	{
		try{
			driver.findElement(By.cssSelector(".btn.btn-info")).click();		//		•	Check whether prompt box pop up appears or not.
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alertwin3 = driver.switchTo().alert();
			alertwin3.sendKeys("Pratik");//		•	Enter your name in the textbox and click on “OK”
			alertwin3.accept();
			System.out.println("Prompt box pop up appeared and clicked on Ok.");
		}catch(Exception e) {
			System.out.println("Prompt box pop up not appeared.");
		}
	}
	
	public static void message2() 
	{
		String act_msg1 = "Hello Pratik How are you today";
		String exp_msg1 = "";
		WebElement msg2 = driver.findElement(By.id("demo1"));
		exp_msg1 = msg2.getText();
		System.out.println(msg2.getText());
		if(act_msg1.equals(exp_msg1)) {
			System.out.println("Respective message is displayed.");
		}else {
			System.out.println("Respective message is not displayed.");
		}
	}
	
	public static void closeBrowser() {
		driverQuit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createDriver(browser);
		mouseAction();
		clickAlerts();
		clickAlertWithOk();
		displayAlertBox();
		clickAlertWithOkandCancel();
		displayConfirmBox();
		message1();	
		clickAlertWithTextbox();
		displayPromptBox();
		message2();
		closeBrowser();
		
		

	}

}
