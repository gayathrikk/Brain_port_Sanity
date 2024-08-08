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

public class Timestamp_AtlasEditor {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4444/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in/");
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
			WebElement table1 = wait6
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
			table1.sendKeys("TestM\n");
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is not Entered successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement table2 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath(
	"//nb-icon[@nbtooltip='Atlas Editor']")));
			table2.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Altas Editor is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Editor is not clicked");
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

	@Test(priority = 3)
	public void Direct_Draw_page() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).build().perform();

			System.out.println("Action executed successfully!");

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error executing action: " + e.getMessage());
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			// Click on the annotation icon
			WebElement annotation = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()='Annotation']")));
			annotation.click();

			System.out.println("-------------------------------------------------");
			System.out.println("The annotation icon is clicked");

		} catch (Exception e) {
			System.out.println("The annotation icon is not clicked");
		}

		try {
			Actions actions = new Actions(driver);

			// Press ALT + V
			actions.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build().perform();
			System.out.println("-------------------------------------------------");
			System.out.println("Action executed successfully!");

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error executing action: " + e.getMessage());
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement search = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
			search.sendKeys("brain");
			Thread.sleep(3000);
			System.out.println("-------------------------------------------------");
			System.out.println("The search icon is clicked");
		} catch (Exception e) {
			System.out.println("The search icon is not clicked");
		}
	}

	@Test(priority = 4)
	public void search() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			WebElement brainId = wait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='1_anchor']")));
//			brainId.click();
//			String t1 = brainId.getText();
//			String expectedText = "Brain";
//			Assert.assertEquals(t1, expectedText);
//			System.out.println("Assertion passed: " + t1 + " matches the expected value.");
//		} catch (AssertionError e) {
//			System.out.println("Assertion failed: " + e.getMessage());
//			// Re-throw the AssertionError
//			throw e;
//		} catch (Exception e) {
//			System.out.println("An error occurred: " + e.getMessage());
//			// Re-throw the Exception
//			throw e;
//		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement Timestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()=' Timestamp ']")));
			Timestamp.click();
			Thread.sleep(3000);
			System.out.println("-------------------------------------------------");
			System.out.println("The Time stamp is clicked");
		} catch (Exception e) {
			System.out.println("The Time stamp is not clicked");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement Time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total time: 00:00:09.942']")));
			Time.getText();
			String actualText = Time.getText();
			Thread.sleep(3000);
			System.out.println("The text is :"+ Time);
			System.out.println("-------------------------------------------------");
			System.out.println("The Time stamp is worked");
		} catch (Exception e) {
			System.out.println("The Time stamp is not worked");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement Download = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/csv.svg']")));
			Download.click();
			Thread.sleep(3000);
		 
			System.out.println("-------------------------------------------------");
			System.out.println("The Time stamp is download");
		} catch (Exception e) {
			System.out.println("The Time stamp is not download");
		}
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}