package Java8;

import java.util.Arrays;
import java.util.List;

public class SkipDemo {

    public static void main(String[] args) {
        List list = Arrays.asList(10, 20, 30, 40, 10, 40, 80, 50, 60, 70, 90, 100);
        list.stream().skip(2).forEach(x-> System.out.println(x));
    }
}
