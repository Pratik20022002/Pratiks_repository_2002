//HOME PAGE

package com.demo_automationtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;
	public static WebDriver driver;
	
	public static WebElement SwitchTo(WebElement driver) {
		element = driver.findElement(By.linkText("SwitchTo"));
		return element;
	}
	
	public static WebElement Alerts(WebElement driver) {
		element = driver.findElement(By.linkText("Alerts"));
		return element;
	}
	
	public static WebElement AlertWithOk(WebElement driver) {
		element = driver.findElement(By.cssSelector(".analystic[href='#OKTab']"));
		return element;
	}
	
	public static WebElement ClickTheButtonAlertBox(WebElement driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-danger"));
		return element;
	}
	
	public static WebElement AlertWithOkandCancel(WebElement driver) {
		element = driver.findElement(By.cssSelector(".analystic[href='#CancelTab']"));
		return element;
	}
	
	public static WebElement ClickTheButtonConfirmBox(WebElement driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-primary"));
		return element;
	}
	
	public static WebElement MessageDisplayed1(WebElement driver) {
		element = driver.findElement(By.id("demo"));
		return element;
	}
	
	public static WebElement AlertWithTextBox(WebElement driver) {
		element = driver.findElement(By.cssSelector(".analystic[href='#Textbox']"));
		return element;
	}
	
	public static WebElement ClickTheButtonPromptBox(WebElement driver) {
		element = driver.findElement(By.cssSelector(".btn.btn-info"));
		return element;
	}
	
	public static WebElement MessageDisplayed2(WebElement driver) {
		element = driver.findElement(By.id("demo1"));
		return element;
	}
	

}