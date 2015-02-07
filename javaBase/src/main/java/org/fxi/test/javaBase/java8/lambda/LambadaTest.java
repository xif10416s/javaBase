package org.fxi.test.javaBase.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.fxi.test.javaBase.java8.interace.FuncitonInterface;
import org.fxi.test.javaBase.java8.interace.FunctionTest;
import org.junit.Test;

public class LambadaTest {
	@Test
	public void test001() {
		List<String> names = new ArrayList<>();
		Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
		System.out.println(names);
		
		Runnable r = () ->{System.out.print("aaa");};
		Thread thread = new Thread(r);
		thread.start();
		
	}

	@Test
	public void test0002() {
		List<String> names = new ArrayList<>();
		names.add("TaoBao");
		names.add("ZhiFuBao");
		List<String> lowercaseNames = names.stream().map((String name) -> {
			return name.toLowerCase();
		}).collect(Collectors.toList());
		
		System.out.println(lowercaseNames);
	}
	
	/**
	 * String::valueOf x ->String.valueOf(x);
		Object::toString x ->x.toString();
		x::toString () ->x.toString();
		ArrayList::new () -> new ArrayList<>();
	 */
	@Test
	public void test0003(){
		FuncitonInterface fi = FunctionTest::test;
		
		System.out.println(fi.test("from :: test"));
	}
	
	
	
}
