import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));

        for (int i = intList.size() - 1; i >= 0; i--) {
            Integer element = intList.get(i);
            if (element <= 0 || element % 2 != 0) {
                intList.remove(i);
            }
        }
        intList.sort(Comparator.naturalOrder());

        for (Integer element : intList) {
            System.out.print(element + " ");
        }

    }
}
