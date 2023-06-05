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

public class TC6 extends Base
{

	@SuppressWarnings("deprecation")
	@Test
	public void testCase6() throws IOException
	{
		Login login = new Login(driver,pr);
		login.signIn("snehalka", "Qwerty#@!Q$$123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Screenshot.takeScreenshot(driver, "D://screenshot/six.png");
		logsCapture.takeLogs("TC6.class", "Login successfull");
		driver.findElement(By.xpath(pr.getProperty("pulse"))).click();
		driver.findElement(By.xpath(pr.getProperty("survey"))).click();
		
		Logout logout = new Logout(driver,pr);
		logout.signOut();
	}
}
