package org.testing.testscripts;
import java.io.IOException;
//to check insights-->security
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.pages.Logout;
import org.testing.utilities.Screenshot;
import org.testing.utilities.logsCapture;
import org.testng.annotations.Test;

public class TC5 extends Base
{

	@SuppressWarnings("deprecation")
	@Test
	public void testCase5() throws IOException
	{
		Login login = new Login(driver,pr);
		login.signIn("snehalka", "Qwerty#@!Q$$123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Screenshot.takeScreenshot(driver, "D://screenshot/fifth.png");
		logsCapture.takeLogs("TC5.class", "Login successfull");
		driver.findElement(By.xpath(pr.getProperty("insights"))).click();
		driver.findElement(By.xpath(pr.getProperty("security"))).click();
		
		Logout logout = new Logout(driver,pr);
		logout.signOut();
	}
}
