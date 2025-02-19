import java.util.*;
import java.lang.*;


public class lab3 {
    public static List<Integer> list = new ArrayList<>();

    public static void enterList()
    {
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 15; i++) {
            int number = -15 + random.nextInt(16 + 15);
            list.add(number);
        }
    }

    public static void main(String[] args) {
        enterList();
        System.out.println(list);
        list.stream()
                .sorted((x, y) -> (y - x))
                .forEach(list::add);
        list = list.subList(list.size() / 2, list.size());
        System.out.println(list);
    }

}
