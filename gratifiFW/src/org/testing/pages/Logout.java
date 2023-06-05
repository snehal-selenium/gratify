package org.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout 
{


	ChromeDriver driver;
	Properties pr;
	public Logout(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void signOut()
	{
		driver.findElement(By.xpath(pr.getProperty("navbar_username"))).click();
		driver.findElement(By.xpath(pr.getProperty("logout_button"))).click();
	}
	
}
