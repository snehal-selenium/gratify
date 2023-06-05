package org.testing.Base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.assertions.Assert_1;
import org.testing.utilities.propertiesFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base 
{

	public ChromeDriver driver;
	public Properties pr;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void BrowserLaunch() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "../gratifiFW/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String expectedURL = "https://cybage.gratifi.com/r3storefront/en/login";
		driver.get("https://cybage.gratifi.com/r3storefront/en/login");
		driver.manage().window().maximize();
		String actualURL = driver.getCurrentUrl();
		System.out.println("************URL validation**************");
		Assert_1.assertion(expectedURL, actualURL);
		pr = propertiesFile.loadProperties("../gratifiFW/Object.properties");
		//Thread.sleep(5000);
	}
	
	@AfterMethod
	public void BrowserClose()
	{
		driver.close();
	}
}
