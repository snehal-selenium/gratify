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

//view all badges
public class TC3 extends Base

{

	@SuppressWarnings("deprecation")
	@Test
	public void testCase3() throws InterruptedException, IOException
	{
		Login login = new Login(driver,pr);
		login.signIn("snehalka", "Qwerty#@!Q$$123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Screenshot.takeScreenshot(driver, "D://screenshot/third.png");
		logsCapture.takeLogs("TC3.class", "Login successfull");
		driver.findElement(By.xpath(pr.getProperty("view_badges"))).click();
		//Thread.sleep(10000);
		Logout logout = new Logout(driver,pr);
		logout.signOut();
	}
}
