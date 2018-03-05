package com;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		//����Optionalʵ����ͨ�������ķ���ֵ�õ��� ��ΪOptional��Ĺ�����˽���ˣ����Բ���ֱ�Ӵ���ʵ����
		Optional<String> name = Optional.of("hello world");
		
		//����û��ֵ��Optionalʵ��������ֵΪ"null"
		Optional empty = Optional.ofNullable(null);
		
		//isPresent���������Optionalʵ���Ƿ���ֵ��
		if(name.isPresent()){
			System.out.println(name.get());
		}
		
	    try {
	        //��Optionalʵ���ϵ���get()�׳�NoSuchElementException��
	        System.out.println(empty.get());
	      } catch (NoSuchElementException ex) {
	        System.out.println(ex.getMessage());
	    }
	    
	    //ifPresent-->���Optionalʵ����ֵ��Ϊ�����consumer������������
	    name.ifPresent((value) -> {
	    	System.out.println("The length of the values is :" + value.length());
	    });
	    
	    //�����ֵorElse�����᷵��Optionalʵ�������򷵻ش���Ĵ�����Ϣ��
	    System.out.println(empty.orElse("There is no value present!"));
	    System.out.println(name.orElse("There is some value!"));
	    
	    //map����ͨ�������lambda���ʽ�޸�Optonalʵ��Ĭ��ֵ�� 
	    //lambda���ʽ����ֵ���װΪOptionalʵ����
	    Optional<String> upperName = name.map((value)-> value.toUpperCase());
	    System.out.println(upperName.get());
	    
	    //flatMap��map��Funtion���ǳ����ƣ���������lambda���ʽ�ķ���ֵ��
	    //map������lambda���ʽ����ֵ�������κ����ͣ����Ƿ���ֵ���װ��Optionalʵ����
	    //����flatMap������lambda����ֵ����Optional���͡�
	    upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
	    System.out.println(upperName.orElse("No value found"));
	    
	    //filter�������Optionalֵ�Ƿ��������������������㷵��Optionalʵ��ֵ�����򷵻ؿ�Optional��
	    Optional<String> longName = name.filter((value)-> value.length()>6);
	    System.out.println(longName.orElse("����С��6"));
	}
}
