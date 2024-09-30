package com.iris22a;

import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIkeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTshirtPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;


public class MensTshirt extends TestBase  {
		// TODO Auto-generated method stub
	UIkeyword ui=new UIkeyword();
	WaitFor wait=new WaitFor();	
		@Test
		public void verifyIfSearchByPopularityYeildsProperResults()
		{
			ui.launchUrl(Environment.URL);
			HomePage home=new HomePage();
			//HomePage home=PageFactory.initElements(UIKeywords.driver, HomePage.class);
			home.hoverOnMenMenu();
			home.clickOnMenTshirt();
			
			MenTshirtPage menTshirt=new MenTshirtPage();
			wait.elementToBePresent(menTshirt.sortByFilter);
			menTshirt.selectPopularityFilter();              
		}

}
