import java.util.Arrays;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        intList.stream()
                .filter(e -> e > 0)
                .filter(e -> e % 2 == 0)
                .sorted()
                .forEach(e -> System.out.print(e + " "));
    }
}
