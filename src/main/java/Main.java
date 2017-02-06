import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        Sign sign = new Sign();
        LocalDate date = LocalDate.of(1995,5,2);
        sign.write("file.xls","Petya", date);
    }
}
