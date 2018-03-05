package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {

	public static void main(String[] args) {
		
		//����תList����
		List<Integer> collectList = Stream.of(1,2,3,4).collect(Collectors.toList());
		System.out.println("collectList: "+collectList);
		
		//�ָ����ݿ飬partitioningBy�������ص�Map��keyΪboolean��ʹ�õ���Predicate<T>: ������������
		Map<Boolean, List<Integer>> collectPari = Stream.of(1,2,3,4).
				   collect(Collectors.partitioningBy(it -> it%2 ==0));
		System.out.println("collectPari: "+collectPari);
		
		//���Collector
		Map<Boolean, Long> pariCount = Stream.of(1,2,3,4).
				   collect(Collectors.partitioningBy(it -> it%2==0,Collectors.counting()));
		System.out.println("pariCount"+pariCount);
		
		//���ݷ��飬groupingBy���ص�Map��keyΪT��ʹ�õ���Function<T,R>: ����ת������
		Map<Boolean, List<Integer>> collectGroup = Stream.of(1,2,3,4).
				collect(Collectors.groupingBy(it -> it>3));
		System.out.println("collectGroup: "+collectGroup);
		
		//�ַ���
		String str = Stream.of("1","2","3","4").collect(Collectors.joining(",","[","]"));
		System.out.println("str: "+str);
		
		//ListתMap
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Supplier<Map<Integer,Integer>> mapSupplier = () -> list.stream().collect(Collectors.toMap(x->x, y-> y * y));
		
		//Collector���
		Map<Integer, Integer> mapValueAdd = list.stream().collect(Collectors.toMap(x->x, y->y, (v1,v2) -> v1+v2, mapSupplier));
		System.out.println(mapValueAdd);
	}
}
