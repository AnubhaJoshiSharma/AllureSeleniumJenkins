package com.mavenJenkinsAllure;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class GoogleTests extends BaseClass {
	
	@Description("TEST NUMBERED 1")
	@Step("Chrome browser test for google.com")
	@Test(description="This is method 1 for opening google")
	public void testMethod1() {
		System.out.println("Inside method 1");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.google.com/","SOME MESSAGE");
	}
	@Description("TEST NUMBERED 2")
	@Step("Firefox browser test for Google.com")
	@Test(description="This is method 1 for opening google")
	public void testMethod2() {
		System.out.println("Inside method 2");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.google.com/","SOME MESSAGE");
	}

}
