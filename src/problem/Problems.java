package problem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problems {
    public static void main(String[] args) {
        //print the sum of squares for even numbers
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList());

        int result = numbers.stream()
                .filter(n -> n%2==0)
                //our output is Integer to map to Int
                .mapToInt(n -> n*n)
                .sum();
        System.out.println(result);
        // Flat Map
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        //convert 2d to 1d and square it
        List<Integer>  flattenedList = nestedList.stream()
                .flatMap(List::stream)//list -> list.stream()
                .map(n -> n*2)
                .collect(Collectors.toList());

        System.out.println(flattenedList);


        List<Transaction> transactions = Arrays.asList(
                new Transaction("Grocery", 2500),
                new Transaction("Entertainment", 500),
                new Transaction("Grocery", 1500),
                new Transaction("Utilities", 1200),
                new Transaction("Utilities", 500),
                new Transaction("Entertainment", 1500)
        );

        // Use case 1: Calculate the total amount spent on groceries
        int amount = transactions.stream()                          // Stream<Transaction>
                .filter(t -> t.getCategory().equals("Grocery"))
                .mapToInt(Transaction::getAmount)   //transaction -> transaction.getAmount()                // IntStream
                .sum();

        System.out.println("Total Grocery Expense: " + amount);

        // Use case 2: Find the average expense across all categories
        double averageExpense = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0.0);

        System.out.println("Average Expense: " + averageExpense);
    }
}
class Transaction {
    private String category;
    private int amount;

    public Transaction(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}
