package CAS_WorldClock;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.page.model.NavigatedWithinDocument;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google_Time {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		
		
		Thread.sleep(10000);
		WebElement clickLogoOfAccount=driver.findElement(By.xpath("//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']"));
		myWait.until(ExpectedConditions.elementToBeClickable(clickLogoOfAccount));
		clickLogoOfAccount.click();
		System.out.println("Clicked Successfully");
		
		WebElement userInfo=driver.findElement(By.xpath("//*[@id=\"mectrl_currentAccount_primary\"]"));
		myWait.until(ExpectedConditions.visibilityOf(userInfo));
		String userDetails = userInfo.getText();
		System.out.println(userDetails);
		Thread.sleep(5000);
		
		WebElement clickLogoOfAccount1=driver.findElement(By.xpath("//*[@id=\"mectrl_headerPicture\"]"));
		clickLogoOfAccount1.click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement xyz = driver.findElement(By.xpath("(//div[@class='CanvasComponent'])/div/div/div[2]"));
		js.executeScript("arguments[0].scrollIntoView();",xyz);
		Thread.sleep(5000);
		
		WebElement wc = driver.findElement(By.xpath("(//span[@id='CaptionElementView'])[4]"));
		String WCT = wc.getText();
		System.out.println(WCT);
		String abc = "World Clock";
		if(abc.equals(WCT)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		Thread.sleep(5000);
		
		
		
		//WebElement date = driver.findElement(By.xpath("//body//div[@id='SPPageChrome']//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//div[2]"));
		WebElement date = driver.findElement(By.xpath("(//div[@class='n_b_816e1fa6'])[1]//div[2]"));
		
		String da = date.getAttribute("title");
		
		myWait.until(ExpectedConditions.visibilityOf(date));
		Thread.sleep(2000);
		
		String dtNoSpace = da.replaceAll("\\s", "");
		System.out.println("Current date and Week details in World Clock: "+dtNoSpace);
		
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Get the weekday
		//System.out.println("Weekday: " + weekday);
		//System.out.println("Current date: " + currentDate);
		String weekday = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formatDate = now.format(formatter);
		String dateWeek = weekday+","+formatDate;
		System.out.println("Current date and Week details in System Clock: "+dateWeek);
		if(dtNoSpace.equalsIgnoreCase(dateWeek)) {
			System.out.println("Test Pass Current Date and Week detail.");
		}else {
			System.out.println("Test Fail Current Date and Week detail.");
		}
		
		
		
		
		WebElement bangT = driver.findElement(By.xpath("(//div[@class='m_b_816e1fa6'])[1]//div[1]"));
		String BangaloreTime = bangT.getText();
		System.out.println("Current time in Bangalore: " +BangaloreTime);
		
		
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("h:mma");
       
        String formatDateTime = now.format(formatter2);
        System.out.println("User System's current time: " +formatDateTime);
        if(BangaloreTime.equals(formatDateTime)) {
        	System.out.println("Test Pass");
        }else {
        	System.out.println("Test Fail");
        }
		
		
        WebElement londonT = driver.findElement(By.xpath("(//div[@class='m_b_816e1fa6'])[2]//div[1]"));
		String LondonTime = londonT.getText();
		System.out.println("Current time in London: " +LondonTime);
		
		
		WebElement nyT = driver.findElement(By.xpath("(//div[@class='m_b_816e1fa6'])[3]//div[1]"));
		String NewYorkTime = nyT.getText();
		System.out.println("Current time in New York: " +NewYorkTime);
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String>winId = driver.getWindowHandles();
        List<String>winList=new ArrayList(winId);
        
        String parentWinId = winList.get(0);
        String childWinId1 = winList.get(1);
		// Get London time
        driver.navigate().to("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));//*[@id="APjFqb"]
        searchBox.sendKeys("current time in london");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
        WebElement londonTimeElement = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div[1]"));
        String londonTime = londonTimeElement.getText();
        String noSpacesText1 = londonTime.replaceAll(" ", "");
        System.out.println("Current time in London: " + noSpacesText1);
        
        
        if(LondonTime.equalsIgnoreCase(noSpacesText1)) {
        	System.out.println("Test Pass");
        }else {
        	System.out.println("Test Fail");
        }
        Thread.sleep(3000);

        // Get New York time
        //driver.get("https://www.google.com/search?q=current+time+in+New+York");
        WebElement clear = driver.findElement(By.xpath("(//*[name()='svg'][@focusable='false'])[2]"));
        clear.click();
        Thread.sleep(3000);
        WebElement searchBox1 = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBox1.sendKeys("current time in new york");
        actions.keyDown(Keys.ENTER).perform();
        WebElement newYorkTimeElement = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div[1]"));
        String newYorkTime = newYorkTimeElement.getText();
        String noSpacesText2 = newYorkTime.replaceAll(" ", "");
        System.out.println("Current time in New York: " + noSpacesText2);
        
        if(NewYorkTime.equalsIgnoreCase(noSpacesText2)) {
        	System.out.println("Test Pass");
        }else {
        	System.out.println("Test Fail");
        }
       
        driver.close();
     
        driver.switchTo().window(parentWinId);
    
		//WebElement xyz1 = driver.findElement(By.xpath("(//div[@class=\"g_b_50a7110f\"])/div[2]"));
        //js.executeScript("arguments[0].scrollIntoView();",xyz1);
        Thread.sleep(3000);
        
        WebElement tzDiffLondon = driver.findElement(By.cssSelector("div[title='-4h 30m']"));
        String timeZoneDiffLondon = tzDiffLondon.getText();
        System.out.println(timeZoneDiffLondon);		
        		
        WebElement tzDiffNY = driver.findElement(By.cssSelector("div[title='-9h 30m']"));
        String timeZoneDiffNewYork = tzDiffNY.getText();
		System.out.println(timeZoneDiffNewYork);
        
        
		Thread.sleep(3000);
		
		
		
		//test case 8 onwards
		
		driver.findElement(By.linkText("OneCognizant")).click();
		Thread.sleep(5000);
		
		//Switch to one cognizant window
		Set<String> winIDSet = driver.getWindowHandles();
		List<String> winIDList = new ArrayList<String>(winIDSet);
		String parentWinID = winIDList.get(0);
		String childWinID = winIDList.get(1);
		driver.switchTo().window(childWinID);
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//*[@id=\"oneC_searchAutoComplete\"]")).sendKeys("1234567");
		WebElement ViewAllApps= driver.findElement(By.xpath("//div[normalize-space()='View All Apps']"));
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ViewAllApps);
		Thread.sleep(2000);
		
		WebElement ViewAllApps1= driver.findElement(By.xpath("//div[normalize-space()='View All Apps']"));
		ViewAllApps1.click();
		
		
		//Test Case 10
		
		WebElement header = driver.findElement(By.xpath("//*[@id='divAppstoreContainer']/div[1]/div/div/div[2]/div"));
		//System.out.println(header.getText());
	    String headerText = header.getText().toUpperCase();
	    
	    // Check if all alphabets are present
	    String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    
	    	for (char alphabet : alphabets.toCharArray()) 
	        {
	            if (!headerText.contains(String.valueOf(alphabet))) 
	            {
	                System.out.println("The alphabet " + alphabet + " is not present in the header.");
	                break;
	            }
	            else 
	            {
	            	System.out.println("all alphabets are there");
	            	break;
	            }
	        }
		
		
		
		//Test Case 11
		
		List<WebElement> allAppsDetails = driver.findElements(By.cssSelector("div[class='appStoreAppName']"));
		int axv = allAppsDetails.size();
		System.out.println();
		System.out.println("Total apps: "+axv);
		System.out.println();
		
		//for(WebElement appsDetails : allAppsDetails) {
		//	System.out.println(appsDetails.getText());
		//}
		WebElement Alphabet = driver.findElement(By.xpath("//div[@aria-label='Filter apps starts with alphabet G']"));
		Alphabet.click();
		
		
		try {
		List<WebElement> speAppsDetails = driver.findElements(By.xpath("//div[starts-with(text(), 'G')]/ancestor::div[@class='appStoreColAppHolder']"));
		
		
		int ccc = speAppsDetails.size();
		System.out.println("No of apps in G section: "+ccc);
		System.out.println();
		
		System.out.println("List of Apps after clicking on G: ");
		Thread.sleep(3000);
		
		for(WebElement appsDetails : speAppsDetails) {
			Thread.sleep(1000);
			System.out.println(appsDetails.getText());
			//Thread.sleep(1000);
		}
		}catch (StaleElementReferenceException e) {
			List<WebElement> speAppsDetails = driver.findElements(By.xpath("//div[starts-with(text(), 'G')]/ancestor::div[@class='appStoreColAppHolder']"));
			
			for(WebElement appsDetails : speAppsDetails) {
				System.out.println(appsDetails.getText());
			}
		}
		
		//WebElement alphaApps= driver.findElement(By.xpath("//*[@id=\"oneCplatformBar_FooterID\"]/div[1]/div/div/div"));
		//js.executeScript("arguments[0].scrollIntoView();", alphaApps);
		 
		
		
	
		 
		driver.quit();
		

	}

}
