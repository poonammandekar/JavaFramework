package com.iris22a.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import com.iris22a.keywords.UIkeyword;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;

public class WaitFor {
	UIkeyword ui=new UIkeyword();
private  FluentWait<WebDriver> wait=null;

	public void intializeWait(){
		wait=new FluentWait<WebDriver> (UIkeyword.driver.get());
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("wait is finished and element is not avilable");
	}
	
	

	public  void elementToBePresent(String locatorType, String locatorValue) {
		this.intializeWait();
		// TODO Auto-generated method stub
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(ui.returnLocator(locatorType, locatorValue)));
	}



	public  void elementToBePresent(org.openqa.selenium.WebElement element) {
		// TODO Auto-generated method stub
		this.intializeWait();
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}



	public  void time(int durationInSeconds) {
		// TODO Auto-generated method stub
		long startTime=System.currentTimeMillis();
		long endTime=startTime+(durationInSeconds*1000);
		while(startTime<=endTime)
		{
			startTime=System.currentTimeMillis();
		}
	}
}
