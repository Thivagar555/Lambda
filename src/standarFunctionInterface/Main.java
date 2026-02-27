package standarFunctionInterface;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    static Optional<Employee> findEmployee(List<Employee> employees, Predicate<Employee> employeePredicate)
    {
        for(Employee employee: employees)
        {
            if(employeePredicate.test(employee))
            {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }
    public static void main(String[] args) {
        //search employees and fetch the salary
        Optional<Employee> employee = findEmployee(EmployeeData.getEmployees(), e -> e.getName().equals("Steve"));

        //functional programming style
       employee.map(Employee::getSalary)
               .ifPresent(System.out::println);
    }
}
