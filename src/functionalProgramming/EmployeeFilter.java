package functionalProgramming;

import java.math.BigDecimal;

@FunctionalInterface
public interface EmployeeFilter {
    boolean test(BigDecimal n);
}
