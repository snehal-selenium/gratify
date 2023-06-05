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

//View Greet and Recognize module
public class TC4 extends Base
{

	@SuppressWarnings("deprecation")
	@Test
	public void testcase4() throws IOException
	{
		Login login = new Login(driver,pr);
		login.signIn("snehalka", "Qwerty#@!Q$$123");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Screenshot.takeScreenshot(driver, "D://screenshot/forth.png");
		logsCapture.takeLogs("TC4.class", "Login successfull");
		driver.findElement(By.xpath(pr.getProperty("greet_recognize"))).click();
		
		Logout logout = new Logout(driver,pr);
		logout.signOut();
		
	}
}
