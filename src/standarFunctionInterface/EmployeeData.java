package standarFunctionInterface;

import java.util.ArrayList;
import java.util.List;

class EmployeeData {

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Steve", 30, 50000));
        employees.add(new Employee(2, "John", 28, 45000));
        employees.add(new Employee(3, "Emma", 35, 70000));
        employees.add(new Employee(4, "David", 40, 90000));

        return employees;
    }
}
