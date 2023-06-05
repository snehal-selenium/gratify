package org.testing.testscripts;

import java.util.List;
import java.io.IOException;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

// Change mood today

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.Base.Base;
import org.testing.assertions.Assert_1;
import org.testing.pages.Login;
import org.testing.pages.Logout;
import org.testing.utilities.Screenshot;
import org.testing.utilities.logsCapture;
import org.testng.annotations.Test;

public class TC1 extends Base
{

	
	@Test
	public void TestCase1() throws InterruptedException, IOException
	{
		try {
			String expected_user = "Snehal Dilip Karande";
			Login login = new Login(driver,pr);
			login.signIn("snehalka", "Qwerty#@!Q$$123");
			Thread.sleep(10000);
			Screenshot.takeScreenshot(driver, "D://screenshot/first.png");
			logsCapture.takeLogs("TC1.class", "Login successfull");
			//DOMConfigurator.configure("../gratifiFW/log.xml");
			//Logger logger =Logger.getLogger(TC1.class);
			//logger.info("Login successfull");
			String actual_user = driver.findElement(By.xpath(pr.getProperty("user_name_display"))).getText();
			System.out.println("********user validation**********");
			Assert_1.assertion(expected_user, actual_user);
			driver.findElement(By.xpath(pr.getProperty("mood_dropdown"))).click();  
			driver.findElement(By.xpath(pr.getProperty("happy_mood"))).click();
			
			Logout logout = new Logout(driver, pr);
			logout.signOut();
			
			
		} catch (Exception e) {

			WebElement el=driver.findElement(By.xpath(pr.getProperty("mood_popup")));
			
			if(el.isDisplayed())
			{
				List<WebElement> ls = driver.findElements(By.xpath(pr.getProperty("Veryhappy_mood")));
				ls.get(1).click();
				Thread.sleep(5000);
			}
			
			
		} 
		
		
	}
}
