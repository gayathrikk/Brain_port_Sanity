package com.test.Tagit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class thumbNail {
    private RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://172.20.23.92:4443/wd/hub");
        driver = new RemoteWebDriver(url, dc);
    }

    @Test(priority = 1)
    public void Login() throws InterruptedException {
        driver.get("https://dataportal.colab.humanbrain.in/");
        driver.manage().window().maximize();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The server is Opened successfully");

        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
        viewerSectionLink.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The Viewer Icon is clicked");

        String parentWindow = driver.getWindowHandle();
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
        login.click();
        System.out.println("--------------------------*****************-----------------------");
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
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        emailInput.sendKeys("meena@htic.iitm.ac.in");
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("Mail I'd is entered");

        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        next.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The Next Button is clicked");

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys("meena@123");
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("Password is entered");

        WebElement next2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        next2.click();
        System.out.println("--------------------------*****************-----------------------");
        System.out.println("The Next Button is clicked");

        Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void table() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement img = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Human ']")));
            img.click();
            Thread.sleep(3000);
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Human fetus clicked Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Human fetus is not clicked");
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=' Brain '])[1]")));
            brain.click();
            Thread.sleep(3000);
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The Brain clicked Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The brain is not clicked");
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement fb3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()=' 44']")));
            fb3.click();
            Thread.sleep(3000);
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The HB clicked Successfully");
        } catch (Exception e) {
            System.out.println("--------------------------*****************-----------------------");
            System.out.println("The HB is not clicked");
        }
    }

    @Test(priority=3)
	public void thumbnailview() throws InterruptedException {
		try {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			    WebElement t = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='tab-link'])[2]")));
			    t.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Nissl is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Nissl is not clicked");
		}
		try {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			    WebElement hd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='4'])[1]")));
			    hd.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is not clicked");
		}
	   
	    JavascriptExecutor js = (JavascriptExecutor) driver; // Create an instance of JavascriptExecutor

	    for (int i = 1; i <= 5000; i += 3) {
	        // Click on thumbnail
	    	WebElement spanElement = driver.findElement(By.cssSelector("span.ngx-gallery-remaining-count"));

	        // Wait for a brief moment for any potential errors to log
	        try {
	            Thread.sleep(1000); // Adjust this wait time as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    // Check for console log messages
	    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	    for (LogEntry entry : logEntries) {
	        if (entry.getLevel() == Level.SEVERE && entry.getMessage().contains("Failed to load resource: the server responded with a status of 404")) {
	            System.out.println("404 Error logged: " + entry.getMessage());
	        }
	    }
	}
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
