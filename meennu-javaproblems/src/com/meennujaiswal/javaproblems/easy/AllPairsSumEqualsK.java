package com.meennujaiswal.javaproblems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPairsSumEqualsK {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int k = 7;

        List<String> pairs = findPairsWithSum(array, k);

        if (pairs.isEmpty()) {
            System.out.println("No pairs found with sum " + k);
        } else {
            System.out.println("Pairs with sum " + k + ": " + String.join(", ", pairs));
        }
    }

    public static List<String> findPairsWithSum(int[] array, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        List<String> pairs = new ArrayList<>();

        for (int num : array) {
            int complement = k - num;
            if (numCountMap.containsKey(complement)) {
                pairs.add("(" + num + ", " + complement + ")");
            }
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        return pairs;
    }
}