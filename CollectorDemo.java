package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {

	public static void main(String[] args) {
		
		//数组转List集合
		List<Integer> collectList = Stream.of(1,2,3,4).collect(Collectors.toList());
		System.out.println("collectList: "+collectList);
		
		//分割数据块，partitioningBy方法返回的Map的key为boolean，使用的是Predicate<T>: 条件测试器。
		Map<Boolean, List<Integer>> collectPari = Stream.of(1,2,3,4).
				   collect(Collectors.partitioningBy(it -> it%2 ==0));
		System.out.println("collectPari: "+collectPari);
		
		//组合Collector
		Map<Boolean, Long> pariCount = Stream.of(1,2,3,4).
				   collect(Collectors.partitioningBy(it -> it%2==0,Collectors.counting()));
		System.out.println("pariCount"+pariCount);
		
		//数据分组，groupingBy返回的Map的key为T，使用的是Function<T,R>: 数据转换器。
		Map<Boolean, List<Integer>> collectGroup = Stream.of(1,2,3,4).
				collect(Collectors.groupingBy(it -> it>3));
		System.out.println("collectGroup: "+collectGroup);
		
		//字符串
		String str = Stream.of("1","2","3","4").collect(Collectors.joining(",","[","]"));
		System.out.println("str: "+str);
		
		//List转Map
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Supplier<Map<Integer,Integer>> mapSupplier = () -> list.stream().collect(Collectors.toMap(x->x, y-> y * y));
		
		//Collector组合
		Map<Integer, Integer> mapValueAdd = list.stream().collect(Collectors.toMap(x->x, y->y, (v1,v2) -> v1+v2, mapSupplier));
		System.out.println(mapValueAdd);
	}
}
