package com.meennujaiswal.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
	
	public static void main(String args[]) {
		
		List<String> words = Arrays.asList("Hello", "World");
		
		
		//H, e, l, o, W, r, d
		
		List<String[]> listOfStringArrays = words.stream()
			 .map(word -> word.split(""))
			 .distinct()
			 .collect(Collectors.toList());
		
		String[] arraysOfWords = {"GoodBye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arraysOfWords);
		
		List<Stream<String>> listOfStreamOfStringArrays = words.stream()
		 .map(word -> word.split(""))
		 .map(Arrays::stream)//Stream<String>, it returns Stream<Stream<String[]>> -> Stream<String>
		 .distinct()
		 .collect(Collectors.toList());
		
		List<String> listOfStrings = words.stream()
				 .map(word -> word.split(""))
				 .flatMap(Arrays::stream)
				 .distinct()
				 .collect(Collectors.toList());
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> squares = numbers.stream()
									   .map(n -> n*n)
									   .collect(Collectors.toList());
		
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		
		List<int[]> pairs = list1.stream()
				                 .flatMap(i -> list2.stream()
				                		 		.map(j -> new int[]{i,j})
				                	     )
				                 .collect(Collectors.toList());
		
		List<int[]> pairs1 = list1.stream()
								  .flatMap(i -> list2.stream().filter(j -> (i+j) % 3 ==0)
										  					  .map( j -> new int[] {i,j})
								          )
								  .collect(Collectors.toList());
                

		
		
	}

}
