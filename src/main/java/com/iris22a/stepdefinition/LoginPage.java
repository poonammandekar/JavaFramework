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

public class LoginPage {
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
	
	@Given("the user enters the username")
	public void the_user_enters_the_username() {
	    
	}

	@Given("the user enters the password")
	public void the_user_enters_the_password() {
	    
	}

	@Then("the user redirect to home page")
	public void the_user_redirect_to_home_page() {
	    
	}
}
