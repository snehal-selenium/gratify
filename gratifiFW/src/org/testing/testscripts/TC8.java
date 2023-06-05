package org.testing.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.pages.Logout;
import org.testing.utilities.Screenshot;
import org.testing.utilities.logsCapture;
import org.testng.annotations.Test;

public class TC8 extends Base
{

	@SuppressWarnings("deprecation")
	@Test
	public void testCase8() throws IOException
	{
		Login login = new Login(driver,pr);
		login.signIn("snehalka", "Qwerty#@!Q$$123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Screenshot.takeScreenshot(driver, "D://screenshot/seven.png");
		logsCapture.takeLogs("TC8.class", "Login successfull");
		driver.findElement(By.xpath(pr.getProperty("recognition"))).click();
		driver.findElement(By.xpath(pr.getProperty("recognition_history"))).click();
		
		Logout logout = new Logout(driver,pr);
		logout.signOut();
	}
}
