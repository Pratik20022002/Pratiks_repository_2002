package mini_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class promptAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",element);
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		promptAlert.sendKeys("Pratik");
		System.out.println("Alert text is "+alertText);

	}

}
