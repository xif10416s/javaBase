package org.fxi.test.javaBase.java8.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	@Test
	public void test001() {
		List<String> names = new ArrayList<String>();
		names.add("aaa");
		names.add("fxx");
		names.add("xff");
		names.add("fxxf");
		int sum = names.stream().filter(str -> str.startsWith("f"))
				.mapToInt(str -> 1).sum();
		System.out.println(sum);

	}

	/**
	 * 使用Stream静态方法来创建Stream
	 * 
	 * 1. of方法：有两个overload方法，一个接受变长参数，一个接口单一值
	 */
	@Test
	public void test002() {
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		long count = integerStream.filter(x -> x % 2 == 1).count();
		System.out.println(count);

		Stream<String> stringStream = Stream.of("taobao");

	}

	/**
	 * 使用Stream静态方法来创建Stream
	 * 
	 * 2. generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier
	 * （这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
	 */
	@Test
	public void test003() {
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		Stream.generate(() -> Math.random());
		Stream<Double> generate = Stream.generate(Math::random);
		long count = generate.limit(10).filter(x -> {
			System.out.println(x);
			return x > 0.3;
		}).count();
		System.out.println(count);

	}

	/**
	 * 使用Stream静态方法来创建Stream
	 * 
	 * 3. iterate方法：也是生成无限长度的Stream，和generator不同的是，其元素的生成是重复对给定的种子值(seed)
	 * 调用用户指定函数来生成的。 其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
	 */
	@Test
	public void test004() {
		Stream.iterate(1, item -> item + 1).limit(10).peek(System.out::println)
				.forEach(System.out::println);
	}

	@Test
	public void test005() {
		List<Integer> nums = Arrays.asList(new Integer[]{1,1,null,2,3,4,null,5,6,7,8,9,10});
		List<Integer> numsWithoutNull = nums
				.stream()
				.filter(num -> num != null)
				.collect(() -> new ArrayList<Integer>(),
						(list, item) -> list.add(item),
						(list1, list2) -> list1.addAll(list2));
		
		System.out.println(numsWithoutNull);
		
		List<Integer> numsWithoutNull2 = nums.stream().filter(num -> num != null).
		              collect(Collectors.toList());
		
		System.out.println("ints sum is:" + numsWithoutNull2.stream().reduce((sum, item) -> sum + item).get());
		
		
	}
}
