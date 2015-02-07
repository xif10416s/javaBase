package org.fxi.test.javaBase.java8.interace;

public class FunctionTest {

	public static void main(String[] args) {
		FuncitonInterface fi = (x) -> {
			return x;
		};
		System.out.println(fi.test("xcv"));
	}
	
	public static String test(String x){
		System.out.println("static test.");
		return x;
	}

}
