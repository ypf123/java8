package com;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		//创建Optional实例，通过方法的返回值得到。 因为Optional类的构造器私有了，所以不能直接创建实例。
		Optional<String> name = Optional.of("hello world");
		
		//创建没有值的Optional实例，例如值为"null"
		Optional empty = Optional.ofNullable(null);
		
		//isPresent方法来检查Optional实例是否有值。
		if(name.isPresent()){
			System.out.println(name.get());
		}
		
	    try {
	        //在Optional实例上调用get()抛出NoSuchElementException。
	        System.out.println(empty.get());
	      } catch (NoSuchElementException ex) {
	        System.out.println(ex.getMessage());
	    }
	    
	    //ifPresent-->如果Optional实例有值则为其调用consumer，否则不做处理。
	    name.ifPresent((value) -> {
	    	System.out.println("The length of the values is :" + value.length());
	    });
	    
	    //如果有值orElse方法会返回Optional实例，否则返回传入的错误信息。
	    System.out.println(empty.orElse("There is no value present!"));
	    System.out.println(name.orElse("There is some value!"));
	    
	    //map方法通过传入的lambda表达式修改Optonal实例默认值。 
	    //lambda表达式返回值会包装为Optional实例。
	    Optional<String> upperName = name.map((value)-> value.toUpperCase());
	    System.out.println(upperName.get());
	    
	    //flatMap与map（Funtion）非常相似，区别在于lambda表达式的返回值。
	    //map方法的lambda表达式返回值可以是任何类型，但是返回值会包装成Optional实例。
	    //但是flatMap方法的lambda返回值总是Optional类型。
	    upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
	    System.out.println(upperName.orElse("No value found"));
	    
	    //filter方法检查Optional值是否满足给定条件。如果满足返回Optional实例值，否则返回空Optional。
	    Optional<String> longName = name.filter((value)-> value.length()>6);
	    System.out.println(longName.orElse("长度小于6"));
	}
}
