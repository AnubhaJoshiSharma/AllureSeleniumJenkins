package com.mavenJenkinsAllure;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import io.qameta.allure.Step;

public class GoogleTests extends BaseClass {
	@Step("Chrome browser test for google.com")
	@Test
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
	@Step("Firefox browser test for Google.com")
	@Test
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
