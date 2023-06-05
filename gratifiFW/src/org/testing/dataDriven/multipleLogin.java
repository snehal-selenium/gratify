package org.testing.dataDriven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.pages.Logout;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;

import junit.framework.TestCase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class multipleLogin extends Base
{

	public int count=0;
	int ct=0;
	@SuppressWarnings("deprecation")
	@Test(dataProvider="dp2")
	public void TestCase(String user, String pass)
	{
		
		try {
		
		Login login = new Login(driver,pr);
		login.signIn(user, pass);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		Logout logout = new Logout(driver, pr);
		logout.signOut();
		count =count+1;
		System.out.println("Login successful for times: "+ count);
		}
		catch (Exception e) {
			
			ct=ct+1;
			System.out.println("Login unsuccessfull for times:"+ct);
		}
	}
	
	
	
	@DataProvider
	public Object [][] dp2() throws BiffException, IOException
	{
	File f = new File("C:\\Users\\snehalka\\Desktop\\input2.xls");
	Workbook wk = Workbook.getWorkbook(f);
	Sheet s = wk.getSheet(0);
	int r = s.getRows();
	int c = s.getColumns();
	
	Object[][] ob = new Object [r][c];
	
	for (int i=0; i<r; i++)
	{
		for(int j=0; j<c; j++)
		{
			Cell wc = s.getCell(j, i);
			ob[i][j]=wc.getContents();
		}
		
	}
	return ob;
	}
}
