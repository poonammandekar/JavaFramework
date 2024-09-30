package com.iris22a.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.iris22a.keywords.UIkeyword;
import com.iris22a.util.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class TestBase {
	private static final Logger log = Logger.getLogger(TestBase.class);
	UIkeyword ui=new UIkeyword();
	
	@BeforeAll
	public static void setLogs()
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Set up Log4j properties
        Properties logProperties = new Properties();
        logProperties.setProperty("log4j.rootLogger", "INFO, FILE");
        logProperties.setProperty("log4j.appender.FILE", "org.apache.log4j.RollingFileAppender");
        logProperties.setProperty("log4j.appender.FILE.File", "logs/application_" + timestamp + ".log");
        logProperties.setProperty("log4j.appender.FILE.layout", "org.apache.log4j.PatternLayout");
        logProperties.setProperty("log4j.appender.FILE.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
        logProperties.setProperty("log4j.appender.FILE.Append", "false");

        // Configure Log4j with the properties
        PropertyConfigurator.configure(logProperties);
	}
	@Before
	public void setUP() throws Exception {
		// TODO Auto-generated method stub
		String browserName=Environment.BROWSER;
		System.out.println("Open browser"+browserName);
		if(browserName==null) {
			browserName="Chrome";
			log.info("Setting default browser as chrome");
		}
		if(browserName.isEmpty())
		{
			browserName="Chrome";
			log.info("Setting default browser as chrome");
		}
		ui.openBrowser(browserName);
	}
	
	@After
	public void teardown()
	{
		ui.closeBrowser();
		log.info("Browser close successfully");
	}
}



