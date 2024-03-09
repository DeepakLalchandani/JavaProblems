package com.meennujaiswal.javaproblems.java8;
import java.util.List;
import java.util.function.Consumer;

public class Square {

    // Original method: Squaring each element in the list
    public static void squareElements(List<Integer> numbers) {
    	SquareOperation squareOp = new SquareOperation();
        for (int number : numbers) {
        	squareOp.accept(number);
        }
    }
    
    // Anonymous Class: Squaring each element in the list
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void squareElementsWithAnonymousClass(List<Integer> numbers) {
        numbers.forEach(new Consumer() {
        	@Override
        	public void accept(Object number) {
                number = (int)number * (int)number;
            }
        });
    }

    // Lambda Expression: Squaring each element in the list
    public static void squareElementsWithLambda(List<Integer> numbers) {
        numbers.stream().map(number -> findSquare(number));
    }

    // Method Reference: Squaring each element in the list
    public static void squareElementsWithMethodReference(List<Integer> numbers) {
        numbers.stream().map(Square::findSquare);
    }

    private static int findSquare(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        // Test the methods
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        
        squareElements(numbers);
        
        squareElementsWithAnonymousClass(numbers);

        squareElementsWithLambda(numbers);

        squareElementsWithMethodReference(numbers);
        
        numbers.forEach(System.out::println);
    }
}
