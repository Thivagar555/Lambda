package exceptionHandlingLambda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LambdaException {
    public static void main(String[] args) {
        Map<String, Double> employees = new HashMap<>();

        // Adding employees (Key = Name, Value = Salary)
        employees.put("Ravi", 55000.0);
        employees.put("Anjali", 72000.0);
        employees.put("Karan", 48000.0);
        employees.put("Sneha", 65000.0);
        employees.put("Arjun", 80000.0);

        printInFile(employees);
    }
    public static void printInFile(Map<String, Double> employees)
    {
        try(FileWriter writer = new FileWriter("employeeList.text"))
        {
            employees.forEach((String name, Double salary) -> {
                try {
                    writer.write(name + " : " + salary + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            });
        }catch (IOException  | RuntimeException  ex)
        {
            ex.printStackTrace();
        }
//        try ( FileWriter writer = new FileWriter("employeeList.txt")){
//            for(Map.Entry<String, Double> entry: employees.entrySet() )
//            {
//                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
