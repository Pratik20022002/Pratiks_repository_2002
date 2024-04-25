package mini_project;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MiniProjectNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		•	Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
//		•	Go to URL, http://demo.automationtesting.in/Alerts.html
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
//		•	Hover the mouse over “SwitchTo” menu
		WebElement SwitchTo = driver.findElement(By.linkText("SwitchTo"));
		Actions actions = new Actions(driver);
		actions.moveToElement(SwitchTo).build().perform();
		
//		•	Click on Alerts
		driver.findElement(By.linkText("Alerts")).click();
		
//		•	Click on the link “Alert with OK”" and click on “click the button to display an alert box:”.
		
		driver.findElement(By.cssSelector(".analystic[href='#OKTab']")).click();  //cssSelector using tag+class+attribute
		
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
		
		
//		•	Click the Link "Alert with OK & Cancel" in the left menu option.
		
		driver.findElement(By.cssSelector(".analystic[href='#CancelTab']")).click();  //cssSelector using tag+class+attribute
		
//		•	Click the link "click the button to display a confirm box.
		
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

//		•	Click the Link "Alert with Textbox".
		driver.findElement(By.cssSelector(".analystic[href='#Textbox']")).click();
		
//		•	Click the link "click the button to demonstrate the prompt box.
		try{
			driver.findElement(By.cssSelector(".btn.btn-info")).click();		//		•	Check whether prompt box pop up appears or not.
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alertwin3 = driver.switchTo().alert();
			Thread.sleep(3000);
			alertwin3.sendKeys("Pratik");
			Thread.sleep(3000);//		•	Enter your name in the textbox and click on “OK”
			alertwin3.accept();
			System.out.println("Prompt box pop up appeared and clicked on Ok.");
		}catch(Exception e) {
			System.out.println("Prompt box pop up not appeared.");
		}
		
//		•	Check if the message Hello <your name> How are you today” is displayed
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
		
//		•	Close the browser
		driver.quit();


	}

}
