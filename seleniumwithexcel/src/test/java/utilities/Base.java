package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class Base {
	public static WebDriver driver;
	
	public static WebDriver navigateToWebsite(String url, String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//Drivers//deckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void takeScreenshotForFailedTest(String methodName) {
			Date date = new Date();
			String fileName = methodName + " " + date.toString().replace(":", "_").replace(" ", "_") + ".png";
			TakesScreenshot scnshot = (TakesScreenshot) driver;
			File source = scnshot.getScreenshotAs(OutputType.FILE);
			File destination = new File("./FailedTests/" + fileName);
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
}
