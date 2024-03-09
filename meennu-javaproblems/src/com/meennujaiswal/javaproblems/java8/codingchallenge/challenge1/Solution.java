package com.meennujaiswal.javaproblems.java8.codingchallenge.challenge1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		
		List<Transaction> tran2011 = transactions.stream()
											.filter(transaction->transaction.getYear()==2011)
											.sorted(Comparator.comparing(Transaction::getValue))
											.collect(Collectors.toList());
		
		tran2011.stream().forEach(System.out::println);
		
		// 2. What are all the unique cities where the traders work?
		List<String> cities = transactions.stream()
										.map(transaction->transaction.getTrader().getCity())
										.distinct()
										.collect(Collectors.toList());
		cities.stream().forEach(System.out::println);
		
		Set<String> cities1 = transactions.stream()
										.map(transaction->transaction.getTrader().getCity())
										.collect(Collectors.toSet());
		cities1.stream().forEach(System.out::println);
										
		// 3. Find all traders from Cambridge and sort them by name.
		List<Trader> camTraders = transactions.stream()
										.map(Transaction::getTrader)
										.filter(trader -> trader.getCity().equals("Cambridge"))
										.distinct()
										.sorted(Comparator.comparing(Trader::getName))
										.collect(Collectors.toList());
		camTraders.stream().forEach(System.out::println);
		// 4. Return a string of all traders’ names sorted alphabetically.
		String allTraders = transactions.stream()
										.map(transaction->transaction.getTrader().getName())
										.distinct()
										.sorted()
										.collect(Collectors.joining());
										//.reduce("",(s1,s2) -> s1+s2);
		
		System.out.println(allTraders);
										
		// 5. Are any traders based in Milan?
		boolean areInMilan = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(areInMilan);
		
		// 6. Print all transactions’ values from the traders living in Cambridge.
		transactions.stream().filter(transaction->"Cambridge".equals(transaction.getTrader().getCity()))
							 .map(Transaction::getValue)
							 .forEach(System.out::println);
		
		// 7. What’s the highest value of all the transactions?
		Optional<Integer> highestTranOpt = transactions.stream()
													  .map(Transaction::getValue)
													  .reduce(Integer::max);
		highestTranOpt.ifPresent(System.out::println);
		
		// 8. Find the transaction with the smallest value.
		Optional<Integer> lowestTranOpt = transactions.stream()
													  .map(Transaction::getValue)
													  .reduce(Integer::min);
		lowestTranOpt.ifPresent(System.out::println);

	}

}
