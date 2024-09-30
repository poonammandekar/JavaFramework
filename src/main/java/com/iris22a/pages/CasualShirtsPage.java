package com.iris22a.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.iris22a.keywords.UIkeyword;

public class CasualShirtsPage {
	UIkeyword ui=new UIkeyword();
	public By itemCount=By.xpath("//span[@class=\"title-count\"]");
	public int getItemCount() {
		String totalItem=UIkeyword.driver.get().findElement(itemCount).getText();
		
		Pattern p=Pattern.compile("/d");
		Matcher m=p.matcher(totalItem);
		String count=m.group();
		
		return Integer.parseInt(count);
	}
}
