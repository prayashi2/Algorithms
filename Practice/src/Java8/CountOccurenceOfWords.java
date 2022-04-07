package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurenceOfWords {

    public static void main(String[] args) {
        String s = "Welcome to programming and programming welcomes you to";
        List<String> list = Arrays.asList(s.split(" "));
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k,v)-> System.out.println(k + "=" + v));
    }
}
