package com.iris22a.stepdefinition;

import java.util.List;

import org.testng.Assert;

import com.iris22a.keywords.UIkeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTshirtPage;
import com.iris22a.util.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps {
	UIkeyword ui=new UIkeyword();
	WaitFor wait=new WaitFor();	
	@Given("The Chrome browser shuold be open.")
	public void m1() {
		ui.openBrowser("chrome");
	}
	
	@And("The url should be launched.")
	public void launchURL() {
		ui.launchUrl("https://www.myntra.com");
	}
	
	
	@When("User search for polo t shirt.")
	public void searchforPoloTshirt() {
		HomePage home=new HomePage();
		home.searchProduct("Polo");
	}
	
	@Then("All result should be related to polo.")
	public void getSearchResult()
	{
		HomePage home=new HomePage();
		
		List<String> productTitles=home.getSearchResultTexts();
		System.out.println(productTitles);
		for(String productTitle:productTitles) {
			System.out.println("ProductTitle:"+productTitle);
			Assert.assertTrue(productTitle.contains("Polo"),"Product title doesn't contain polo: "+productTitle);
		}
	}
	
	@When("User hovers on men menu")
	public void hoverOnMenMenu()
	{
		HomePage home=new HomePage();
		//HomePage home=PageFactory.initElements(UIKeywords.driver, HomePage.class);
		home.hoverOnMenMenu();
	}
	
	@And("user click on mens T-shirt")
	public void clickOnMenTshiert()
	{
		HomePage home=new HomePage();
		//HomePage home=PageFactory.initElements(UIKeywords.driver, HomePage.class);
		home.clickOnMenTshirt();
	}
	
	@Then("user selects popularity filter")
	public void selectPopularityFilter()
	{
		MenTshirtPage menTshirt=new MenTshirtPage();
		wait.elementToBePresent(menTshirt.sortByFilter);
		menTshirt.selectPopularityFilter();  
	}
	
}
