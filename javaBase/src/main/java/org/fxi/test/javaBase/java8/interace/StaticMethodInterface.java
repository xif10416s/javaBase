package org.fxi.test.javaBase.java8.interace;

public interface StaticMethodInterface {
	public static int test() {
		System.out.println("test.....static ");
		return 1;
	};
	
	
	public default void test2(){
		System.out.println("default test2");
	}
	
}
