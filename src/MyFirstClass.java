import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class MyFirstClass {

	public static void main(String[] args) throws IOException {

		// System.setProperty("webdriver.chrome.driver",
		// "G:\\\\\\\\MyNewDriver\\\\\\\\chromedriver.exe");
//Firefox		//System.setProperty("webdriver.gecko.driver", "G:\\Firefox Driver64\\geckodriver.exe");		
//		WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.edge.driver", "G:\\Edge WebDriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("http://127.0.0.1:5500/index.html");
		// Date currentDate = new Date();
		// String theActualDate = currentDate.toString().replace(":", "-");

		// TakesScreenshot src = ((TakesScreenshot) driver);
		// File SrcFile = src.getScreenshotAs((OutputType.FILE));
		// File Dest = new File(".\\Screenshots\\" + theActualDate + ".png");
		// FileUtils.copyFile(SrcFile, Dest);

		List<WebElement> thestudents = driver.findElements(By.tagName("option"));
		int theTotalNumberOfStudents = thestudents.size();

		System.out.println(theTotalNumberOfStudents + " this is the original number of students");

		int HowManyItems = 10;

		System.out.println(HowManyItems + " this is the number of students i want to remove");

		for (int i = 0; i < HowManyItems; i++) {

			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}

		List<WebElement> theStudentAfterRemove = driver.findElements(By.tagName("option"));
		int ActualNumber = theStudentAfterRemove.size();

		System.out.println(ActualNumber + " this is the actual number of students after remove");

		int expectedItems = theTotalNumberOfStudents - HowManyItems;

		System.out.println(expectedItems + " this is the expected number i have expected");

		Assert.assertEquals(ActualNumber, expectedItems);

	}

}
