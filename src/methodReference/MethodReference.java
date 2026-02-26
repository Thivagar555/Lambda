package methodReference;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {
    public static boolean isOverPaid(Integer salary)
    {
        return salary.compareTo(4500) >0 ;
    }
    public static void main(String[] args) {
        List<Integer> salary = Stream.of(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000)
                .collect(Collectors.toList());

        salary.forEach(System.out::println);
    }
}
