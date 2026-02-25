package functionalProgramming;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static long countEmployees(List<BigDecimal> salary, EmployeeFilter filer)
    {
        List<BigDecimal> filteredEmployee = new ArrayList<>();
        salary.forEach(sal -> {
            if(filer.test(sal)) {
                filteredEmployee.add(sal);
            }
        } );
        return filteredEmployee.size();
    }
    public static void printEmployees(List<BigDecimal> salary, EmployeeFilter filer)
    {
        for(BigDecimal sal : salary)
        {
            if(filer.test(sal))
            {
                System.out.println(sal);
            }
        }
    }
    public static void main(String[] args) {
        List<BigDecimal> salary = Stream.of(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000)
                .map(BigDecimal::valueOf)
                .collect(Collectors.toList());

        final BigDecimal salaryLimit = new BigDecimal(4500);

        System.out.println("below limit");
        printEmployees(salary, (BigDecimal n) -> n.compareTo(salaryLimit) < 0);

        System.out.println("above limit");
        printEmployees(salary, (BigDecimal n) -> n.compareTo(salaryLimit) > 0);
    }
}
