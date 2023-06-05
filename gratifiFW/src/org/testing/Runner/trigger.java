package org.testing.Runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class trigger 
{

	public static void main(String[] args) throws BiffException, IOException {
	
		XmlSuite xs = new XmlSuite();
		xs.setName("Suite1");
		XmlTest xt = new XmlTest(xs);
		File f = new File("C:\\Users\\snehalka\\Desktop\\input.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet(0);
		int rows = s.getRows();
		ArrayList<XmlClass> xL = new ArrayList<XmlClass>();
		for (int i=1; i<rows; i++)
		{
			Cell c = s.getCell(4, i);
			if(c.getContents().equals("Y"))
					{
				
						Cell pkg = s.getCell(2, i);
						Cell class_name = s.getCell(3, i);
						String v = pkg.getContents()+"."+class_name.getContents();
						XmlClass c1 = new XmlClass(v);
						xL.add(c1);
					}
		}
			System.out.println("Total tests: "+xL.size());
			xt.setClasses(xL);
			ArrayList<XmlTest> xL2 = new ArrayList<XmlTest>();
			xL2.add(xt);
			xs.setTests(xL2);
			ArrayList<XmlSuite> xL3 = new ArrayList<XmlSuite>();
			xL3.add(xs);
			
			TestNG T = new TestNG();
			T.setXmlSuites(xL3);
			T.run();
		
	}
}
