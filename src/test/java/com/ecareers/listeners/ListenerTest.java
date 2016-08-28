package com.ecareers.listeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.utilities.CareerTestListener;

@Listeners(CareerTestListener.class)
public class ListenerTest{
	
	@Test
	public void test1success(){
		Assert.assertTrue(true, "Tests are awsome");
	}

	@Test
	public void test2fail(){
		Assert.assertTrue(false,"Tests are Failings");
	}

	@Test(dependsOnMethods = "test2fail")
	public void test3skip(){
		Assert.assertTrue(true, "Tests are skipping");
		 //throw new SkipException ("Skipping Tests");
	}
}
