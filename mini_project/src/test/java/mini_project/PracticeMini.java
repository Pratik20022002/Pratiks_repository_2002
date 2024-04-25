package mini_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeMini {
	Alert alert;
	Actions act;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		
		WebElement swt = driver.findElement(By.linkText("SwitchTo"));
		Actions act = new Actions(driver);
		act.moveToElement(swt).build().perform();
		driver.findElement(By.linkText("Alerts")).click();
		
		driver.findElement(By.cssSelector("[href='#OKTab']")).click();
		
		try {
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Alert Box is Present and clicked OK.");
		}catch (Exception e) {
			System.out.println("Alert Box is not Present.");	
		}
		
		WebElement swt1 = driver.findElement(By.linkText("Widgets"));
		//Actions act = new Actions(driver);
		act.moveToElement(swt1).build().perform();
		driver.findElement(By.cssSelector("a[href='Datepicker.html']")).click();
		
		driver.findElement(By.id("datepicker1")).click();
		String year = "2025";
		String month = "May";
		String date = "20";
		
		while(true) {
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String mnt = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(yr.equals(year) && mnt.equals(month)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> dt = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
		for(WebElement dts:dt) {
			if(date.equals(dts.getText())) {
				dts.click();
			}
		}
		

	}

}
