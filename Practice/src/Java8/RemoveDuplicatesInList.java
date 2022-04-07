package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesInList {

    public static void main(String[] args) {
        List list = Arrays.asList(10, 20, 30, 40, 10, 40, 80, 50, 60, 70, 90, 100);
        Set set = new HashSet<>();
        list.stream().filter(x -> set.add(x)).collect(Collectors.toSet());
        set.forEach(x-> System.out.println(x));
    }
}
