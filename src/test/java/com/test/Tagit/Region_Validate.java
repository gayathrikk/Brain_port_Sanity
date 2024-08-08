package com.test.Tagit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Region_Validate {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4444/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in");
		driver.manage().window().maximize();
		System.out.println("The server is Opened sucessfully");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement viewerSectionLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));
		viewerSectionLink.click();
		System.out.println("The Viewer Icon is clicked");
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement login = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
		login.click();
		System.out.println("The login Button is clicked");
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement emailInput = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
		emailInput.sendKeys("softwaretestingteam9@gmail.com");
		System.out.println("Mail I'd is entered");
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		WebElement Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next.click();
		System.out.println("The Next Button is clicked");
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
		WebElement PasswordInput = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		PasswordInput.sendKeys("Health#123");
		System.out.println("Password is entered");
		WebDriverWait wait5 = new WebDriverWait(driver, 20);
		WebElement Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next2.click();
		System.out.println("The Next Button is clicked");
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void table() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		try {
			WebDriverWait wait6 = new WebDriverWait(driver, 30);
			WebElement Atlas = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/cellreports.svg']")));
			Atlas.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Dashboard Click Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Dashboard is not Click");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement AtlasDashboard = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Atlas Dashboard']")));
			AtlasDashboard.click();			
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Dashboard Click Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Dashboard is not Click");
		}
		try {
			WebDriverWait wait8 = new WebDriverWait(driver, 30);
			WebElement Bio = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='biosample']")));
			Bio.sendKeys("222");				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Bio Sample Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Bio Sample is not Entered Successfully");
		}
		try {
			WebDriverWait wait9 = new WebDriverWait(driver, 30);
			WebElement reg = wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='region']")));
			reg.sendKeys("Internal capsule");				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Region Name Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Region Name is not Entered Successfully");
		}
		try {
			WebDriverWait wait10 = new WebDriverWait(driver, 30);
			WebElement Button = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Search'])[1]")));
			Button.click();		
			Thread.sleep(5000);
			System.out.println("------------------------*****************-----------------------");
			System.out.println("The Search Button clicked Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The search Button not clicked");
		}
		 Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }}
	        @Test(priority = 3)
	        public void regions() throws InterruptedException {
	    	 
	    		try {
	    			WebDriverWait wait  = new WebDriverWait(driver, 30);
	    			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
	    			search.sendKeys("238");
	    			WebElement search1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-list-item[text()=' 238 ']")));
	    			search1.click();
	    			Thread.sleep(3000);
	    			System.out.println("--------------------------*****************-----------------------");
	    			System.out.println("The Searched Number is clicked Sucessfully");
	    		} catch (Exception e) {
	    			System.out.println("--------------------------*****************-----------------------");
	    			System.out.println("The Searched Number is clicked Sucessfully");
	    		}
	    		 
	    		try {
	    			WebDriverWait wait  = new WebDriverWait(driver, 30);
	    			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Internal capsule']")));
	    			search.getText();
	    			String A = search.getText();
	    			Thread.sleep(3000);
	    			String expectedText = "Internal capsule";
	    			System.out.println("The Text is :"+ A);
	    			Assert.assertEquals(A, expectedText);
	    			System.out.println("Assertion passed: " + A + " matches the expected value.");
	    		} catch (AssertionError e) {
	    			System.out.println("Assertion failed: " + e.getMessage());
	    			// Re-throw the AssertionError
	    			throw e;
	    		} catch (Exception e) {
	    			System.out.println("An error occurred: " + e.getMessage());
	    			// Re-throw the Exception
	    			throw e;
	    		}
	    		try {
	    			WebDriverWait wait  = new WebDriverWait(driver, 30);
	    			WebElement search1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='222']")));
	    			search1.getText();
	    			String A1 = search1.getText();
	    			Thread.sleep(3000);
	    			String expectedText = "222";
	    			System.out.println("The Text is :"+ A1);
	    			Assert.assertEquals(A1, expectedText);
	    			System.out.println("Assertion passed: " + A1 + " matches the expected value.");
	    		} catch (AssertionError e) {
	    			System.out.println("Assertion failed: " + e.getMessage());
	    			// Re-throw the AssertionError
	    			throw e;
	    		} catch (Exception e) {
	    			System.out.println("An error occurred: " + e.getMessage());
	    			// Re-throw the Exception
	    			throw e;
	    		}
	    			 
	}
		@AfterTest
		public void tearDown() {
			if (driver != null) {
				driver.quit();
			}
		}}
