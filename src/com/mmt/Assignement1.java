package com.mmt;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignement1 {

	public static void main(String[] args) throws InterruptedException {

		// Chrome profile for Chrome options
		String userProfile = "C://Users//sumahali//AppData//Local//Google//Chrome//User Data";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sumahali\\MakeMyTripApplication\\MakeMyTripCabBooking\\src\\Webdrivers\\chromedriver.exe");

		// Chrome options are used to block the notifications and pop-up
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=" + userProfile);
		options.addArguments("--profile-directory=Default");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		// Maximize the window
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// URL
		driver.navigate().to("https://www.makemytrip.com/");
		

		// Entering the email id for login
		System.out.println("<<<<<<<<<<   LOGIN  >>>>>>>>>>");
		System.out.println("");
		System.out.println("TITLE: " + driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[1]/div/input"))
		.sendKeys("rajkarthik42810@gmail.com");
		System.out.println("--Email id is entered in the field");

		Thread.sleep(1000);

		// Click on Continue button
		WebElement cont = driver.findElement(By.xpath("//button[@class='capText font16']"));

		// Wait until continue button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(cont));
		cont.click();
		System.out.println("--Continue button is clicked");

		// Enter Password in the field
		driver.findElement(By.id("password")).sendKeys("Sundar@123");
		System.out.println("--Password is entered in the field");

		// Click on login button
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		System.out.println("--Login button is clicked");
		System.out.println("Your account logged in successfully!!!!!");
		System.out.println("-----------------------------------------------------------------------------");
		Thread.sleep(2000);

		// Click on cab tab
		System.out.println("<<<<<<<<<<   CABS  >>>>>>>>>>");
		System.out.println("");
		System.out.println("TITLE: " + driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[7]/span/a")).click();
		System.out.println("--Cabs tab is selected");
		Thread.sleep(1000);

		// Click from city dropdown
		driver.findElement(By.id("fromCity")).click();
		System.out.println("--Clicked on from city dropdown");

		// Click and select From city
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("Bangalore");
		System.out.println("--Entered From-city name in the field");

		List<WebElement> dynamicList = driver.findElements(By.xpath("//p[@class='searchedResult font14 darkText']"));

		for(int i=0; i<dynamicList.size(); i++) {

			String text = dynamicList.get(i).getText();
			System.out.println("Selected from city: " + text);

			if(text.contains("Bangalore")) {
				dynamicList.get(i).click();
				break;
			}
		}


		// Click and select To city
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("Hyderabad");
		System.out.println("--Entered To-city name in the field");

		List<WebElement> dynamicList2 = driver.findElements(By.xpath("//p[@class='searchedResult font14 darkText']"));

		for(int i=0; i<dynamicList2.size(); i++) {

			String text = dynamicList2.get(i).getText();
			System.out.println("Selected from city: " + text);

			if(text.contains("Hyderabad")) {
				dynamicList2.get(i).click();
				break;
			}
		}

		Thread.sleep(1000);

		// Click on departure
		driver.findElement(By.xpath("//div[@class='csw_inner']//div[3]")).click();
		System.out.println("--Departure dropdown in clicked");
		Thread.sleep(1000);

		// Set departure date
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]")).click();
		System.out.println("--Departure date is selected");
		Thread.sleep(1000);

		// Click on pickup dropdown
		driver.findElement(By.xpath("//div[@class='csw_inner']//div[5]")).click();
		System.out.println("--Pickup dropdown is clicked");
		Thread.sleep(1000);

		// Select pick up hours
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[1]/li[9]")).click();
		System.out.println("--Pickup hour is selected");
		Thread.sleep(1000);

		// Select pick up minute
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[2]/li[11]")).click();
		System.out.println("--Pickup minute is selected");
		Thread.sleep(1000);

		// Select AM/PM
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[3]/li[1]")).click();
		System.out.println("--Pickup session (AM/PM) is selected");
		Thread.sleep(1000);

		//Click on apply button
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/div[5]")).click();
		System.out.println("--Apply button is clicked");

		// Click on search button
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/p/a")).click();
		System.out.println("--Search button is clicked");
		System.out.println("-----------------------------------------------------------------------------");

		// Click on Book Button
		System.out.println("<<<<<<<<<<   AVAILABLE CABS  >>>>>>>>>>");
		System.out.println("");
		System.out.println("TITLE: " + driver.getTitle());
		WebElement Book = driver.findElement(By.xpath("//*[@id=\"List\"]/div[1]/div/div[3]/div/a/span"));
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("arguments[0].click();", Book);
		System.out.println("--Book button is clicked");
		System.out.println("-----------------------------------------------------------------------------");

		// Enter pickup details
		System.out.println("<<<<<<<<<<   PICKUP DETAILS  >>>>>>>>>>");
		System.out.println("");
		WebElement pickup = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[1]/div[1]/div/input"));
		JavascriptExecutor scrl = (JavascriptExecutor) driver;
		scrl.executeScript("arguments[0].scrollIntoView();", pickup);
		pickup.click();
		System.out.println("--Pickup field is clicked");

		// Select pickup address
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[1]/div[1]/div/div/div[1]/div/input"))
		.sendKeys("Whitefield");
		System.out.println("--Pickup address is entered");

		List<WebElement> dynamicList3 = driver
				.findElements(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/p[1]"));

		for (int i = 0; i < dynamicList3.size(); i++) {

			String text1 = dynamicList3.get(i).getText();
			System.out.println("Entered pickup address is: " + text1);

			if (text1.equals("Whitefield")) {
				dynamicList3.get(i).click();
				break;
			}
		}

		// Enter passenger name
		WebElement Name = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[2]/div[1]/div[1]/input"));
		Name.sendKeys("Traveller");
		System.out.println("--Name is entered");
		
		// Select radio button - female
		WebElement Female = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[2]/div[1]/div[2]/div/span[2]/div"));
		JavascriptExecutor j4 = (JavascriptExecutor) driver;
		j4.executeScript("arguments[0].click();", Female);
		System.out.println("--Gender radio button is selected");
		Thread.sleep(1000);


		// Click on pay button
		WebElement pay = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div/div[3]/div[1]/a"));
		JavascriptExecutor j5 = (JavascriptExecutor) driver;
		j5.executeScript("arguments[0].click();", pay);
		System.out.println("--Pay button is clicked");
		System.out.println("-----------------------------------------------------------------------------");
		Thread.sleep(7000);
		driver.navigate().back();
		Thread.sleep(1000);

		// Click on User profile for logout
		System.out.println("<<<<<<<<<<   LOGOUT  >>>>>>>>>>");
		System.out.println("");
		System.out.println("TITLE: " + driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"loginTrigger\"]/div")).click();
		System.out.println("--User profile at top is clicked");

		// Click on my profile
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li/div[2]/a[1]/div/p[2]")).click();
		System.out.println("--My profile is clicked");
		Thread.sleep(1000);

		// Click on logout
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"myProfilePage\"]/div[2]/div[1]/div/ul/li[5]"));
		JavascriptExecutor j3 = (JavascriptExecutor) driver;
		j3.executeScript("arguments[0].click();", logout);
		System.out.println("--Logout is clicked");
		System.out.println("Your account logged out successfully!!!!!");
		System.out.println("-----------------------------------------------------------------------------");
		Thread.sleep(3000);
		
		// Close the browser
		driver.quit();


	}

}
