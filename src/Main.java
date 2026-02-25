import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Add obj = (a, b) -> a + b;

        System.out.println(obj.sum(12, 15));

        List<String> list = Arrays.asList("thivagar", "thivag", "dhiva", "", "apple", "happy", "java");

        Predicate validate = (s) -> s.startsWith("t");

        for(String s : list)
        {
            if(validate.test(s))
            {
                System.out.println(s);
            }
        }

        Supplier getLocalDate = () -> LocalDate.now();

        System.out.println(getLocalDate.get());

        int result = Calculator.add(10, 20, (a, b) -> a +b);
        System.out.println(result);
    }
}