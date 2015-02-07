package org.fxi.test.javaBase.java8.interace;

public class StaticMethodImpl implements StaticMethodInterface{
	public static void main(String[] args){
		StaticMethodImpl staticMethodImpl = new StaticMethodImpl();
		staticMethodImpl.test2();
		
		StaticMethodInterface.test();
	}
}
