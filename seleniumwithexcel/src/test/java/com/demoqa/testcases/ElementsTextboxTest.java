package com.demoqa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.demoqa.pages.ElementsPage;
import utilities.Base;
import utilities.ReadAndWriteExcel;

public class ElementsTextboxTest {
	public WebDriver driver;
	String url = "https://www.demoqa.com";
	String browserName = "chrome";
	String projectPath = System.getProperty("user.dir");
	String excelPath = projectPath + "/testdata.xlsx";
	String sheetName = "Sheet1";
	ElementsPage elementsPage;
	ReadAndWriteExcel readAndWriteExcel;
	
	// @Test(dataProvider = "ElementsTextboxTestData", dataProviderClass = utilities.ExcelDataProvider.class)
	public void textBoxTest(String fullName, String email, String cAddress, String pAddress) {
		driver = Base.navigateToWebsite(url, browserName);
//		WebElement element = driver.findElement(By.xpath("//div[@class='card-body']/h5[text() = 'Elements']"));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
//		driver.findElement(By.xpath("//li[@id='item-0']//span[@class='text']")).click();
//		driver.findElement(By.id("userName")).sendKeys("Tom Cruise");
//		driver.findElement(By.id("userEmail")).sendKeys("tomcruise123@gmail.com");
//		driver.findElement(By.id("currentAddress")).sendKeys("12 Elizabeth Road, London, E3 4DJ");
//		driver.findElement(By.id("permanentAddress")).sendKeys("12 Elizabeth Road, London, E3 4DJ");
//		WebElement submitButton = driver.findElement(By.id("submit"));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", submitButton);
//		submitButton.click();
		elementsPage = new ElementsPage(driver);
		elementsPage.clickOnElement();
		elementsPage.clickOnTextBox();
		/*
		readAndWriteExcel = new ReadAndWriteExcel(excelPath, sheetName);
		elementsPage.enterFullName(readAndWriteExcel.getCellData(1, 0));
		elementsPage.enterEmailAddress(readAndWriteExcel.getCellData(1, 1));
		elementsPage.enterCurrentAddress(readAndWriteExcel.getCellData(1, 2));
		elementsPage.enterPermanentAddress(readAndWriteExcel.getCellData(1, 3));
		*/
		elementsPage.enterFullName(fullName);
		elementsPage.enterEmailAddress(email);
		elementsPage.enterCurrentAddress(cAddress);
		elementsPage.enterPermanentAddress(pAddress);
		elementsPage.clickOnSubmitButton();
		Base.closeBrowser();
	}
	
	@Test(dataProvider = "ElementsTextboxTestData", dataProviderClass = utilities.ExcelDataProvider.class)
	public void textBoxTest1(String ...data) {
		driver = Base.navigateToWebsite(url, browserName);
		elementsPage = new ElementsPage(driver);
		elementsPage.clickOnElement();
		elementsPage.clickOnTextBox();
		elementsPage.enterFullName(data[0]);
		elementsPage.enterEmailAddress(data[1]);
		elementsPage.enterCurrentAddress(data[2]);
		elementsPage.enterPermanentAddress(data[3]);
		elementsPage.clickOnSubmitButton();
		Base.closeBrowser();
	}
}
