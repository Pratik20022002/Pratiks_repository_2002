package mini_project;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiniProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://www.fb.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/input")).sendKeys("abc");
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div[1]/div[2]/div/div[1]/input")).sendKeys("xyz");
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div/div[1]/input")).sendKeys("987654321");
		
		//List<WebElement>days = driver.findElements(By.xpath("//*[@id=\"day\"]"));
		WebElement days = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[1]"));
		Select day = new Select(days);
		//List<WebElement>options = day.getOptions();
		//System.out.println(options.size());
		day.selectByVisibleText("10");
		
		
		WebElement months = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[2]"));
		Select month = new Select(months);
		month.selectByIndex(1);
		
		WebElement years = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[3]"));
		Select year = new Select(years);
		year.selectByValue("2005");
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input")).click();
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[11]/button")).click();
		Thread.sleep(2000);
		WebElement abc = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/text()"));
		abc.click();
		Thread.sleep(2000);
		//String xyz = abc.getText();
		System.out.println(abc.getText());
		//Thread.sleep(3000);
		//Alert alert = driver.switchTo().alert();
		//Thread.sleep(3000);
		//Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
		//System.out.println(alert.getText());
		//div[@id="js_d0"]
	}

}
