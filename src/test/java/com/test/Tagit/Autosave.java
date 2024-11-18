package com.test.Tagit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;

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
public class Autosave {

private RemoteWebDriver driver;
@BeforeTest
public void setup() throws MalformedURLException
{
	DesiredCapabilities dc = DesiredCapabilities.chrome();
	URL url = new URL("http://172.20.23.92:4443/wd/hub");
	driver = new RemoteWebDriver(url, dc);
}
@Test(priority=1)
public void Login() throws InterruptedException {
	driver.get("http://apollo2.humanbrain.in/");
	driver.manage().window().maximize();
	System.out.println("The server is Opened sucessfully");
	WebDriverWait wait = new WebDriverWait(driver, 50);
	WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));
	viewerSectionLink.click();
	System.out.println("The Viewer Icon is clicked");
	String parentWindow = driver.getWindowHandle();
	WebDriverWait wait1= new WebDriverWait(driver, 20);
	WebElement login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
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
	WebDriverWait wait2 = new WebDriverWait(driver,20);
	WebElement  emailInput = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	emailInput.sendKeys("softwaretestingteam9@gmail.com");
	System.out.println("Mail I'd is entered");
	WebDriverWait wait3 = new WebDriverWait(driver,20);
	WebElement  Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	Next.click();
	System.out.println("The Next Button is clicked");
	WebDriverWait wait4 = new WebDriverWait(driver,20);
	WebElement  PasswordInput = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
	PasswordInput.sendKeys("Health#123");
	System.out.println("Password is entered");
	WebDriverWait wait5 = new WebDriverWait(driver,20);
	WebElement  Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
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
		WebDriverWait wait  = new WebDriverWait(driver, 30);
		WebElement table1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
		table1.sendKeys("TestM\n");
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The number Entered Successfully");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The number is not Entered successfully");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement table2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
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
		}}}
@Test(priority=3)
public void Drawpage() throws InterruptedException {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement Atlas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/oldmenu.svg']")));
		Atlas.click();
		Thread.sleep(30000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Edit menu Clicked Successfully");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Edit menu is not Clicked");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Draw']")));
		edit.click();
		Thread.sleep(10000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Draw menu Clicked Successfully");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Draw menu is not Clicked");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Unlock']")));
		edit.click();
		Thread.sleep(10000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Unlock button Clicked Successfully");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Unlock button is not Clicked");
	}
	Thread.sleep(3000);
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		// Click on the annotation icon
		WebElement annotation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()='Annotation']")));
		annotation.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The annotation icon is clicked");

	} catch (Exception e) {
		System.out.println("The annotation icon is not clicked");
	}
	Thread.sleep(3000);

	try {
		Actions actions = new Actions(driver);
		// Press ALT + V
		actions.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build().perform();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("Action executed successfully!");

	} catch (NoSuchElementException e) {
		System.out.println("Element not found: " + e.getMessage());
	} catch (Exception e) {
		System.out.println("Error executing action: " + e.getMessage());
	}
	Thread.sleep(6000);
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		search.sendKeys("brain");
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The search icon is clicked");
	} catch (Exception e) {
		System.out.println("The search icon is not clicked");
	}
	Thread.sleep(3000);
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement brainId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='1_anchor']")));
		brainId.click();
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The option is selected");
	} catch (Exception e) {
		System.out.println("The option is not clicked");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement canvas = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"atlasEditorMap\"]/div[1]/div[1]/div[2]")));
		canvas.click();
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The canvas is clicked");
	} catch (Exception e) {
		System.out.println("The canvas is not clicked");
	}
}	
@Test(priority = 4)
public void search() throws InterruptedException {	
	
	try {
		Actions actions = new Actions(driver);

		actions.sendKeys("a").perform();
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("Action executed successfully!");

	} catch (NoSuchElementException e1) {
		System.out.println("Element not found: " + e1.getMessage());
	} catch (Exception e) {
		System.out.println("Error executing action: " + e.getMessage());
	}

	WebElement canvas = driver.findElement(By.xpath("//canvas"));
	Actions actions = new Actions(driver);
	actions.moveToElement(canvas).click().moveByOffset(200, 0).click().moveByOffset(0, 200).click()
			.moveByOffset(-200, 0).click().moveByOffset(0, -200).click().release().perform();
	// Wait for visualization (optional)
	Thread.sleep(5000);
	System.out.println("Square drawn successfully in the middle of the canvas");
	int waitTime = 5 * 60; // 5 minutes in seconds
	for (int i = 0; i < waitTime; i++) {
	    // Display remaining minutes at specific intervals
	    if (i == 0) {
	        System.out.print("\rWaiting... 5 min more");
	    } else if (i == 60) {
	        System.out.print("\rWaiting... 4 min more");
	    } else if (i == 120) {
	        System.out.print("\rWaiting... 3 min more");
	    } else if (i == 180) {
	        System.out.print("\rWaiting... 2 min more");
	    } else if (i == 190) {
	        System.out.print("\rWaiting... 30 more");
	    }
	    // Update the cycling dots animation
	    System.out.print("\rWaiting" + ".".repeat(i % 5));
	    Thread.sleep(1000); // 1-second delay
	}

	// Final message after waiting
	System.out.println("\rDone waiting!");

	
	
	
//	try {
//		Actions actions1 = new Actions(driver);
//
//		actions1.keyDown(Keys.SHIFT).sendKeys("S").keyUp(Keys.SHIFT).build().perform();
//		Thread.sleep(5000);
//		System.out.println("--------------------------*****************-----------------------");
//		System.out.println("Save action executed successfully!");
//
//	} catch (NoSuchElementException e1) {
//		System.out.println("Element not found: " + e1.getMessage());
//	} catch (Exception e) {
//		System.out.println("Error executing action: " + e.getMessage());
//	}

	
	
//	WebElement canvas = driver.findElement(By.xpath("//canvas"));
//	Actions actions = new Actions(driver);
//	actions.moveToElement(canvas).click().moveByOffset(200, 0).click().moveByOffset(0, 200).click()
//			.moveByOffset(-200, 0).click().moveByOffset(0, -200).click().release().perform();
//	// Wait for visualization (optional)
//	Thread.sleep(5000);
//	
//	System.out.println("Square drawn successfully in the middle of the canvas");
//	 Thread.sleep(360000);
//	    System.out.println("Waited for 6 minutes");
 	     Thread.sleep(3000);
	    try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']")));
			yesButton.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Autosave button activated Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Autosave button is not activated ");
		}
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, 30);
//	        WebElement toasterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toastr-container[contains(@class, 'ng-star-inserted')]//*[contains(text(), 'Saved region successfully')]")));
//	        
//	        if (toasterMessage.isDisplayed()) {
//	            System.out.println("Toaster message displayed: Saved region successfully");
//	        }
//	    } catch (Exception e) {
//	        System.out.println("Toaster message not found or did not appear.");
//	        e.printStackTrace();
//	    }
	    Thread.sleep(3000);
	    try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/cancel.svg']")));
			yesButton.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The back button Clicked Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The back button is not Clicked");
		}
	    Thread.sleep(3000);
	    try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Draw']")));
			edit.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Draw menu Clicked Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Draw menu is not Clicked");
		}
}
	    @Test(priority = 4)
		public void selectRegion() {
			try {
				Actions actions = new Actions(driver);
				// Perform the action to trigger the selection (e.g., sending "x")
				actions.sendKeys("x").perform();
				Thread.sleep(3000);
				System.out.println("--------------------------*****************-----------------------");
				System.out.println("Select Action executed successfully!");
				// Locate the canvas element
				WebElement canvas = driver.findElement(By.xpath("//canvas"));
				Thread.sleep(3000);
				Actions actions1 = new Actions(driver);
				int centerX = 0;
				int centerY = 0;
				actions.moveToElement(canvas, centerX, centerY).click().perform();
				// Wait for visualization (optional)
				Thread.sleep(5000);
				System.out.println("--------------------------*****************-----------------------");
				System.out.println("Drawn square successfully clicked in the middle of the canvas");
			} catch (Exception e) {
				System.out.println("Error drawing square: " + e.getMessage());
			}
		}
	    @Test(priority = 5)
		public void DeleteRegion() {
			try {
				Actions actions = new Actions(driver);
				// Perform the action to trigger the deletion (e.g., sending "d")
				actions.sendKeys("d").perform();
				Thread.sleep(3000);
				System.out.println("--------------------------*****************-----------------------");
				System.out.println("Deletion action executed successfully!");
				// Additional actions or verification can be added here if needed
			} catch (NoSuchElementException e1) {
				System.out.println("Element not found: " + e1.getMessage());
			} catch (Exception e) {
				System.out.println("Error executing deletion action: " + e.getMessage());
			}
//			try {
//				WebDriverWait wait = new WebDriverWait(driver, 50);
//				WebElement del = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
//				del.click();
//				Thread.sleep(3000);
//				System.out.println("--------------------------*****************-----------------------");
//				System.out.println("The Delete Button is clicked");
//			} catch (Exception e) {
//				System.out.println("The Delete Button is not clicked");
//			}
			try {
				Actions actions1 = new Actions(driver);
				actions1.keyDown(Keys.SHIFT).sendKeys("S").keyUp(Keys.SHIFT).build().perform();
				Thread.sleep(5000);
				System.out.println("--------------------------*****************-----------------------");
				System.out.println("Save action executed successfully!");
				System.out.println("--------------------------*****************-----------------------");
			} catch (NoSuchElementException e1) {
				System.out.println("Element not found: " + e1.getMessage());
			} catch (Exception e) {
				System.out.println("Error executing action: " + e.getMessage());
			}
		}
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}}
}