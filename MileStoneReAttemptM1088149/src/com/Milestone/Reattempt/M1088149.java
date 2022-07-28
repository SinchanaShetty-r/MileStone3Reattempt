package com.Milestone.Reattempt;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class M1088149 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String URL = "http://the-internet.herokuapp.com/";
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		//STEP 1: Click on “Hovers” link in the page. In the new page, hover on first image and print the name in console. Navigate back to the previous page
		driver.findElement(By.linkText("Hovers")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src=\"/img/avatar-blank.jpg\"]"))).build().perform();
		String FirstName = driver.findElement(By.tagName("h5")).getText();
		System.out.println(FirstName);
		driver.navigate().to(URL);
		
		
		//Click on “Checkboxes link” from the above URL. In the new page, uncheck all the checkboxes, wait for 2 seconds and then check all the checkboxes. Navigate back to the previous page
		driver.findElement(By.linkText("Checkboxes")).click();
		driver.findElement(By.xpath("//input[@checked]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.navigate().to(URL);
		
		
		//Click on “Inputs” from the above URL. Enter a 4 digit number into the textbox. Navigate back to the previous page.
		driver.findElement(By.linkText("Inputs")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("2580");
		driver.navigate().to(URL);
		
		
		//Click on the “Dropdown”. Choose “Option 2” from dropdown. Navigate back to the previous page.
		driver.findElement(By.linkText("Dropdown")).click();
		driver.findElement(By.id("dropdown")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.navigate().to(URL);
		
		
		//Click on “File Upload” link. In the next page choose dummy text file and click on “Upload”. Check that “File Uploaded!” message is displayed. Navigate back to main page
		driver.findElement(By.linkText("File Upload")).click();
		WebElement Browse = driver.findElement(By.xpath("//input[@id='file-upload']"));
		Browse.sendKeys("C:\\Users\\mindedge251\\Desktop\\ReattemptM1088149\\Dummy.txt");
		driver.findElement(By.id("file-submit")).click();
		driver.navigate().to(URL);
		
		
		//Click on “Sortable Data Tables”. In the next page, under “Example 1”, print the Email and web site of the person whose first name is “Tim”. Don’t hardcode the values for tables rows and columns. Make use of dynamic xpath to identify the email address and website. Navigate back to the previous page.
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		String email = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[3]")).getText();
		String website = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]")).getText();
		System.out.println(email);
		System.out.println(website);
		driver.navigate().to(URL);
		
		
		//Click on “Key Presses”. In the next page, try entering any key from the keyboard into the textbox and print the keyname/text highlighted beside “You entered:” as per the below window. Navigate back to the previous page.
		driver.findElement(By.linkText("Key Presses")).click();
		WebElement keyPress=driver.findElement(By.id("target"));
		keyPress.sendKeys(Keys.BACK_SPACE);
		String keyPressText = driver.findElement(By.id("result")).getText();
		System.out.println(keyPressText);
		driver.navigate().to(URL);
		
		
		//Click on “Multiple Windows”. In the next page, click on “Click Here” link. It should open a new tab. Print the text which appears in the new window/tab. Navigate back to main page(http://the-internet.herokuapp.com/).
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String content = driver.findElement(By.tagName("h3")).getText();
		System.out.println(content);
		driver.switchTo().window(parentId);
		driver.navigate().to(URL);
		
		
		//Click on “Context Menu”. In the new page, right click on the specified box and close the alert to see the context menu.
		driver.findElement(By.linkText("Context Menu")).click();
		a.contextClick(driver.findElement(By.id("hot-spot"))).perform();
		Alert alert =driver.switchTo().alert();
		alert.accept();
		driver.navigate().to(URL);
		
		
		
	}
}
