package org.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login 
{
	public ChromeDriver driver;
	public Properties pr;

	public Login(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void signIn(String usernm, String pwd)
	{
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(usernm);
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys(pwd);
		driver.findElement(By.xpath(pr.getProperty("login_button"))).click();
	}
	
}
