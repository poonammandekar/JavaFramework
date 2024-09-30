package com.iris22a.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterisation {

	int x,y,r;
	double m,n,sum=0;
	
	@Given("I have two numbers {int} and {int}")
	public void acceptTwoNumbers(int x,int y)
	{
		this.x=x;
		this.y=y;
		
	}
	@Given("I have two float numbers {double} and {double}")
	public void i_have_two_float_numbers_and(Double double1, Double double2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("I add float numbers")
	public void addFloatNumbers()
	{
		this.sum=m+n;
	}
	
	@When("I add them")
	public void addNumbers()
	{
		this.r=x+y;
	}
	
	@Then("Print the result")
	public void displayResult() {
		System.out.println("Result: "+r);
	}
	
	@Given("I have a fruit {string}")
	public void displayFruit(String fruit)
	{
		System.out.println("And the color is "+fruit);
	}
	@Then("display it's {string}")
	public void displayColor(String color )
	{
		System.out.println("And the color is "+color);
	}
	
	@Given("I have following <states>")
	public void AcceptCities(DataTable states) {
		System.out.println("==========STATES==================");
		Map<String,List> statDetails=states.asMap(String.class,List.class);
		Set<Map.Entry<String,List>> entries=statDetails.entrySet();
		
		for(Entry<String,List> entry:entries) {
			List<String> data=entry.getValue();
			System.out.println(entry.getKey()+"\t"+data.get(0)+"\t"+data.get(1));
		}
	}
	
	@Given("I have {int} and {int}")
	public void i_have_and(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		this.x=int1;
		this.y=int2;
	}
	
	@Then("print if there addition is prime")
	public void isPrime() {
		int flag=0;
		for(int i=2;i<=r/2;i++) {
			if(r%i==0) {
				flag=1;
				break;
			}
		}
			if(flag==0)
			{
				System.out.println("Number is prime: "+r);
			}
		}
	
	
}
