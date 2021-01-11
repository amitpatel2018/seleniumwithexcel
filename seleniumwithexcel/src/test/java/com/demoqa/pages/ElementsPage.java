package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class ElementsPage extends BasePage {
	public ElementsPage(WebDriver driver) {
		super(driver);
	}
	
	By element = By.xpath("//div[@class='card-body']/h5[text() = 'Elements']");
	By textBox = By.xpath("//li[@id='item-0']//span[@class='text']");
	By fullName = By.id("userName");
	By userEmail = By.id("userEmail");
	By currentAddress = By.id("currentAddress");
	By permanentAddress = By.id("permanentAddress");
	By submitButton = By.id("submit");
	
	public void clickOnElement() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(element));
		driver.findElement(element).click();
	}
	public void clickOnTextBox() {
		driver.findElement(textBox).click();
	}
	public void enterFullName(String name) {
		driver.findElement(fullName).sendKeys(name);
	}
	public void enterEmailAddress(String email) {
		driver.findElement(userEmail).sendKeys(email);
	}
	public void enterCurrentAddress(String cAddress) {
		driver.findElement(currentAddress).sendKeys(cAddress);
	}
	public void enterPermanentAddress(String pAddress) {
		driver.findElement(permanentAddress).sendKeys(pAddress);
	}
	public void clickOnSubmitButton() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(submitButton));
		driver.findElement(submitButton).click();
	}
}
