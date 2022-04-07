package Java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LimitDemo {

    public static void main(String[] args) {
        List list = Arrays.asList(10, 20, 30, 40, 10, 40, 80, 50, 60, 70, 90, 100);
        list.stream().limit(8).forEach(x-> System.out.println(x));
    }
}
