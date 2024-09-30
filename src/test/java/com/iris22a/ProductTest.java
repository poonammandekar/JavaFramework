package com.iris22a;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.config.TestNGBase;
import com.iris22a.keywords.UIkeyword;
import com.iris22a.pages.CasualShirtsPage;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;
import com.iris22a.util.PropUtil;
import com.iris22a.util.WaitFor;


public class ProductTest extends TestNGBase {
	UIkeyword ui=new UIkeyword();
	WaitFor wait=new WaitFor();	
	@Test
public  void verifySearchResultForPoloMen() throws InterruptedException {
		PropUtil repository=new PropUtil();
		Environment env=new Environment();
		ui.launchUrl(Environment.URL);
		ui.maxWindow();
		ui.enterText(repository.getLocator("search_products_txtBx")[0],repository.getLocator("search_products_txtBx")[1],"polo men");
		ui.clickButton(repository.getLocator("search_icon")[0],repository.getLocator("search_icon")[1]);
		
		List<String> productTitles=ui.getTexts(repository.getLocator("product_titles_txt")[0],repository.getLocator("product_titles_txt")[1]);
		
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"),"Product title doesn't contain polo: "+productTitle);
		}
		
	}
	
	@Test
	public void verifyCategoryListForTopWears() {
		Environment env=new Environment();
		PropUtil repository=new PropUtil();
		List<String> expected=new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("Shirts");
		expected.add("Sweatshirts");
		expected.add("Kurtas");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");
		ui.launchUrl(Environment.URL);
		ui.maxWindow();
		ui.mouseMove(repository.getLocator("men_menu")[0],repository.getLocator("men_menu")[1]);
		ui.clickButton(repository.getLocator("menu_topwear")[0],repository.getLocator("menu_topwear")[1]);
		wait.elementToBePresent(repository.getLocator("categories_text")[0],repository.getLocator("categories_text")[1]);
		List<String> actualCategory=ui.getTexts(repository.getLocator("categories_text")[0],repository.getLocator("categories_text")[1]);
		System.out.println(actualCategory);
		for(int i=0;i<actualCategory.size();i++)
		{
			actualCategory.set(i,actualCategory.get(i).split("[(]")[0]);
		}
		Assert.assertTrue(actualCategory.containsAll(expected));
	}
	
	@Test
	public void verifyItemCountOfCasualShirts() {
		ui.launchUrl(Environment.URL);
		HomePage home=new HomePage();
		home.hoverOnMenMenu();
		home.clickOnCasualShirts();
		CasualShirtsPage casual=new CasualShirtsPage();
		int itemCount=casual.getItemCount();
		System.out.println(itemCount);
	}
	
	@Test
	public void m3() 
	{
		
	}
	
	@Test
	public void m4() 
	{
		
	}
	@Test
	public void m5() 
	{
		
	}
	
	@Test
	public void m6() 
	{
		
	}
	@Test
	public void m7() 
	{
		
	}
	
	@Test
	public void m8() 
	{
		
	}
	@Test
	public void m9() 
	{
		
	}
	
	@Test
	public void m10() 
	{
		
	}
	@Test
	public void m11() 
	{
		
	}
	
	@Test
	public void m12() 
	{
		
	}
	
}
