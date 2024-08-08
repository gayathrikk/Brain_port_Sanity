package com.test.Tagit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search_Regin_Validate {

	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4443/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}
@Test(priority = 1)
public void Login() throws InterruptedException {
    driver.get("http://apollo2.humanbrain.in/");
    driver.manage().window().maximize();
    System.out.println("--------------------------*****************-----------------------");
    System.out.println("The server is opened successfully");

    WebDriverWait wait = new WebDriverWait(driver, 50);
    try {
        WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));
        viewerSectionLink.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The Viewer Icon is clicked");

        String parentWindow = driver.getWindowHandle();
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
        login.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The login Button is clicked");

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        emailInput.sendKeys("softwaretestingteam9@gmail.com");
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("Mail ID is entered");

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        nextButton.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The Next Button is clicked");

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys("Health#123");
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("Password is entered");

        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        nextButton2.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The Next Button is clicked");

        driver.switchTo().window(parentWindow);
        Thread.sleep(5000); // Consider replacing this with a more robust wait

    } catch (NoSuchElementException e) {
        System.out.println("Element not found: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
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
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Dashboard Click Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Dashboard is not Click");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement Bio = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='biosample']")));
			Bio.sendKeys("222");				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Bio Sample Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Bio Sample is not Entered Successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement reg = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='region']")));
			reg.sendKeys("Internal capsule");				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Region Name Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Region Name is not Entered Successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement Button = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Search'])[1]")));
			Button.click();				
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Search Button clicked Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The search Button not clicked");
		}
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}