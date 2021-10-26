package com.qa.guru99.config;

import org.testng.annotations.Test;

import com.qa.guru99.base.Test1;

public class Test2 {
	
	public static int b =20;
	
	@Test
	public void sum() {
		System.out.println(Test1.a+b);
	}

}
