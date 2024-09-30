package com.iris22a.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIkeyword;

public class MenTshirtPage {

	UIkeyword ui=new UIkeyword();
	
	@FindBy(xpath="//div[@class=\"sort-sortBy\"]")
	public WebElement sortByFilter;
	
	@FindBy(xpath="//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]")
	public WebElement countryOfOrigin;
	
	@FindBy(xpath="//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]")
	public WebElement recommendedFilter;
	
	@FindBy(xpath="//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]")
	public WebElement popularityFilter;
	
	public MenTshirtPage(){
		/*sortByFilter=UIKeywords.driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
		
		recommendedFilter=UIKeywords.driver.findElement(By.xpath("//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]"));
		recommendedFilter=UIKeywords.driver.findElement(By.xpath("//div[@class='sort-sortBy']/span[contains(text(),'Recommended')]"));*/
		PageFactory.initElements(UIkeyword.driver.get(), this);
	}
	
	public void clickonSortByFilter(){
		sortByFilter.click();
	}
	public void selectPopularityFilter() {
		ui.mouseMove(recommendedFilter);
		ui.click(popularityFilter);
	}
}
