import java.time.LocalDate;

@FunctionalInterface
public interface Supplier {
    LocalDate get();
}
