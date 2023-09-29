package com.meennujaiswal.javaproblems.difficult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

public class Anagram {
	 public static List<List<String>> findAnagrams(List<String> inputList) {
	        Map<String, List<String>> anagramGroups = inputList.stream()
	                .collect(Collectors.groupingBy(str -> sortString(str)));

	        return anagramGroups.values().stream()
	                .filter(group -> group.size() > 1)
	                .collect(Collectors.toList());
	    }

	    private static String sortString(String str) {
	        char[] charArray = str.toCharArray();
	        Arrays.sort(charArray);
	        return new String(charArray);
	    }

	    public static void main(String[] args) {
	        List<String> inputList = Arrays.asList("eat", "tea", "tan", "ate", "act", "cat");

	        List<List<String>> anagramGroups = findAnagrams(inputList);

	        anagramGroups.forEach(group -> System.out.println("Anagrams: " + String.join(", ", group)));
	    }
}