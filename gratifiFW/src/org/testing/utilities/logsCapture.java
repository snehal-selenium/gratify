package org.testing.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testing.testscripts.TC1;

public class logsCapture 
{
	

	public static void takeLogs(String classname, String msg)
	{	
		DOMConfigurator.configure("../gratifiFW/log.xml");
		Logger logger = Logger.getLogger(classname);
		logger.info(msg);
	}
}
