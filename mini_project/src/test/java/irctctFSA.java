
import java.time.Duration;
import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class irctctFSA {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		//Maximize the window
		driver.manage().window().maximize();
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Launch https://www.air.irctc.co.in/ in a web browser
		driver.get("https://www.air.irctc.co.in/");
		
		//verify the respective application is opened or not 
		String actual=driver.getTitle();
		String expected="Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air";
		if(actual.equals(expected)) {
			System.out.println("Yes website is opened!");
		}
		driver.findElement(By.name("From")).click();
		
		////Enter "Hyd" in “From” city, in the auto listed results, select "HYDERABAD (HYD)"
		List<WebElement>origin=(List<WebElement>) driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		for (WebElement option : origin) {
	    if (option.getText().contains("Hyderabad (HYD)")) {
	    	
	        option.click();
	        break;
	    	}
		}
		driver.findElement(By.name("To")).click();
		
		//Enter "Pune" in "To" city, in the auto listed results, select "PUNE (PNQ)" 
		List<WebElement>destination=(List<WebElement>) driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		for(int i=0;i<destination.size();i++) {
			WebElement option1=driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']")).get(i);
	
			if (option1.getText().contains("Pune (PNQ)")) {
				option1.click();
				break;
			}
		}

		//Select today’s date from the date picker. 
		//driver.findElement(By.xpath("//span[@class='act active-red']")).click();  //today's date 
		//driver.findElement(By.xpath("//span[normalize-space()='14']")).click();		// this date wise flights
		
		
		//click on the departure
		driver.findElement(By.xpath("//input[@id='originDate']")).click();
		
		//Verify the results shown are valid, by checking the city and date values are same as given in previous page. 
		String year="2025";
		String month="JANUARY";
		String date=" 16";
		
		List<WebElement> years=driver.findElements(By.xpath("//datepickermodifi[@class='form-control']//tr//sub"));
		
		List<WebElement> allData=driver.findElements(By.xpath("//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[3]/datepickermodifi/div/div[2]/div[1]/table/tr/td/span[1]"));

		List<WebElement> months=driver.findElements(By.xpath("//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[3]/datepickermodifi/div/div[2]/div[1]/table//span[@class='ML-Month d-none d-md-block']"));
		
		System.out.println(years.size());
		
		for(int i=0;i<years.size();i++) 
		{
			
		    String s1=years.get(i).getText();
		    String s2=months.get(i).getText();

		    if(s1.equals(year) && s2.equals(month)) 
		    {
		    	System.out.println(s1);
				System.out.println(s2);
		        break;
		       
		    }
		        
		}
		
		List<WebElement> allDates2=driver.findElements(By.xpath("//table/tbody//td/span"));
		/*for(int i=0;i<allDates2.size();i++) 
		{
			String ac=allDates2.get(i).getText();
			System.out.println(ac);
			if(ac.equals(date)) {
				
			}
			
		}*/
		
		
		//System.out.println(allDates2.get(i).getText());
        for(WebElement dt:allDates2) 
        {
        	
        	if(date.equals(dt.getText())) 
        	{
        		System.out.println(dt.getText());
        		dt.click();
        		break;
        	
        	}
    	}
		
		
		
		//select class
		driver.findElement(By.xpath("//input[@id='noOfpaxEtc']")).click();
		
		driver.findElement(By.xpath("//select[@id='travelClass']")).click();
		
		// code here
		Select objSelect =new Select(driver.findElement(By.xpath("//select[@id='travelClass']")));
		objSelect.selectByVisibleText("Business");
		
		//Click on "Search" button
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		
		//Wait to load the flights
		Thread.sleep(4000);
		
		//Display the name and Number of available Flights on the console 
		List<WebElement> flightList=driver.findElements(By.xpath("/html/body/app-root/app-oneway/div/main/div/div/div[2]//b"));
		for(int i=0;i<flightList.size();i++) {
			String flight=flightList.get(i).getText();
			System.out.println(flight); 
			
		}
		System.out.println("Total No of flights: "+ flightList.size());
		
		//to watch flights
		Thread.sleep(4000);
		//Close the Application. 
		driver.close();
	}    
}



//Verify the results shown are valid, by checking the city and date values are same as given in previous page. 
//Capture the results screenshot and save in the project folder. 
//Select today’s date from the date picker. 