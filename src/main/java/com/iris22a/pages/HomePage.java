package com.iris22a.pages;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.iris22a.keywords.UIkeyword;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.iris22a.pages.HomePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
//import com.iris22a.pages.Logger;
import org.openqa.selenium.WebElement;

public class HomePage {
	UIkeyword ui=new UIkeyword();
	private static final Logger log = LogManager.getLogger(HomePage.class);
	//private static final Logger log=Logger.getLogger(HomePage.class);
	@CacheLookup
	@FindBy(xpath="//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]")
	public WebElement menMenu;
	
	@FindBy(xpath="//a[@href=\"/men-tshirts\"]")
	public WebElement menTShirt;

	@FindBy(xpath="(//li[@class=\"desktop-oddColumnContent\"])[1]/descendant::a[contains(text(),\"Casual\")]")
	public WebElement casualShirts;
	
	/*public HomePage(){
		menMenu=ui.driver.findElement(By.xpath("//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]"));
		menTShirt=ui.driver.findElement(By.xpath("//a[@href=\"/men-tshirts\"]"));
		
	}*/
	
	@FindBy(css="div.desktop-query>input.desktop-searchBar")
	public WebElement searchComponent; 
	
	@FindBy(css="h4.product-product")
	public List<WebElement> productTexts;
	
	public HomePage(){
		PageFactory.initElements(UIkeyword.driver.get(), this);
	}
	public void hoverOnMenMenu()
	{
		ui.mouseMove(menMenu);
	}
	
	public void clickOnMenTshirt() {
		ui.click(menTShirt);
	}
	public void clickOnCasualShirts() {
		// TODO Auto-generated method stub
		casualShirts.click();
		log.info("Clicked on Casual Shirts");
	}
	
	public void searchProduct(String productName)
	{
		ui.enterText(searchComponent,productName+Keys.ENTER);
	}
	public List<String> getSearchResultTexts() {
		// TODO Auto-generated method stub
		List<String> productTexts=new ArrayList<String>();
		for(WebElement product:this.productTexts) {
			productTexts.add(product.getText());
		}
		return productTexts;
	}
	
}
	
	
