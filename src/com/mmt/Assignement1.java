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
		String userProfile = "C://Users//sumahali//AppData//Local//Google//Chrome//User Data";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sumahali\\MakeMyTripApplication\\MakeMyTripCabBooking\\src\\Webdrivers\\chromedriver.exe");

		//Chrome options are used to block the notifications and pop-up
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=" + userProfile);
		options.addArguments("--profile-directory=Default");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		//maximize the window
		driver.manage().window().maximize();

		// Url
		driver.get("https://www.makemytrip.com/");

		// Entering the mobile number for login
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[1]/div/input"))
		.sendKeys("7339433732");
		Thread.sleep(2000);

		// continue button
		WebElement cont = driver.findElement(By.xpath("//button[@class='capText font16']"));

		// wait until continue button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(cont));
		cont.click();
		Thread.sleep(17000);

		// click on login button
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		Thread.sleep(3000);

		// clicking on cab tab
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[7]/span/a")).click();
		Thread.sleep(3000);

		// click from city drop down
		driver.findElement(By.id("fromCity")).click();

		// click on from city
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("Bangalore");

		List<WebElement> dynamicList = driver.findElements(By.xpath("//p[@class='searchedResult font14 darkText']"));

		for(int i=0; i<dynamicList.size(); i++) {

			String text = dynamicList.get(i).getText();
			System.out.println(text);

			if(text.contains("Bangalore")) {
				dynamicList.get(i).click();
				break;
			}
		}


		//click on to city
		//driver.findElement(By.xpath("//span[normalize-space()='Pune']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("Hyderabad");

		List<WebElement> dynamicList2 = driver.findElements(By.xpath("//p[@class='searchedResult font14 darkText']"));

		for(int i=0; i<dynamicList2.size(); i++) {

			String text = dynamicList2.get(i).getText();
			System.out.println(text);

			if(text.contains("Hyderabad")) {
				dynamicList2.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		//click on departure
		driver.findElement(By.xpath("//div[@class='csw_inner']//div[3]")).click();
		Thread.sleep(1000);

		//departure date
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]")).click();
		Thread.sleep(1000);

		//pickup
		driver.findElement(By.xpath("//div[@class='csw_inner']//div[5]")).click();
		Thread.sleep(1000);

		//pick up hours
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[1]/li[9]")).click();
		Thread.sleep(1000);

		//pick up minute
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[2]/li[11]")).click();
		Thread.sleep(1000);

		//AM PM
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[3]/li[1]")).click();
		Thread.sleep(1000);

		//apply button
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/div[5]")).click();
		Thread.sleep(1000);

		//search button
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/p/a")).click();
		Thread.sleep(3000);

		//Click on Book Button
		WebElement Book = driver.findElement(By.xpath("//*[@id=\"List\"]/div[1]/div/div[3]/div/a/span"));
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("arguments[0].click();", Book);
		Thread.sleep(5000);

		//Enter pickup details
		WebElement pickup = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[1]/div[1]/div/input"));
		JavascriptExecutor scrl = (JavascriptExecutor) driver;
		scrl.executeScript("arguments[0].scrollIntoView();", pickup);
		pickup.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[1]/div[1]/div/div/div[1]/div/input"))
		.sendKeys("Whitefield");
		Thread.sleep(3000);

		List<WebElement> dynamicList3 = driver
				.findElements(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/p[1]"));

		for (int i = 0; i < dynamicList3.size(); i++) {

			String text1 = dynamicList3.get(i).getText();
			System.out.println(text1);

			if (text1.equals("Whitefield")) {
				dynamicList3.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);

		// radio button -female
		WebElement Female = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[2]/div[1]/div[2]/div/span[2]/div"));
		JavascriptExecutor j4 = (JavascriptExecutor) driver;
		j4.executeScript("arguments[0].click();", Female);
		Thread.sleep(1000);

		// Email
		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/div[4]/div/div[2]/div[2]/div[1]/div/input"))
		.sendKeys("traveller123@gmail.com");
		Thread.sleep(1000);

		// Pay button
		WebElement pay = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div/div[3]/div[1]/a"));
		JavascriptExecutor j5 = (JavascriptExecutor) driver;
		j5.executeScript("arguments[0].click();", pay);
		Thread.sleep(8000);

		driver.quit();

	}

}
