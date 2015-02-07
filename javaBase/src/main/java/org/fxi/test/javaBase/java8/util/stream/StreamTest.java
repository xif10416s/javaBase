package org.fxi.test.javaBase.java8.util.stream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StreamTest {
	@Test
	public void test001(){
		List<String> names = new ArrayList<String>();
		names.stream().filter(str -> str.startsWith("f")).mapToInt(str -> 1).sum();
	}
}	
