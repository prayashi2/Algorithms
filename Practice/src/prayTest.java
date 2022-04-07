import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.*;

public class prayTest extends prayTestAbs implements prayTestFunc {

    public static void main(String[] args) {
        try {
            Child p = new Child();
            p.display();
            BiConsumer<Integer, Integer> biConsumer = (a,b)-> System.out.println(a+b);
            BiConsumer<Integer, Integer> biConsumer1 = (a,b)-> System.out.println(a*a);
            biConsumer.andThen(biConsumer1).andThen(biConsumer1).accept(2,3);
            prayTest pt = new prayTest();
            pt.print();
            pt.add();
            prayTestFunc.eat();
            pt.eat();
            System.out.println(prayTestFunc.hi);
            BiFunction<Integer, Integer, Integer> mul = (x, y) -> x * y;
            Function<Integer, Integer> times2 = x -> x * 2;
            Function<Integer, Integer> minus1 = x -> x - 1;
            ConcurrentHashMap map = new ConcurrentHashMap(16, 0.75f, 8);
            map.put(1,2);
            System.out.println(map.get(1));

// r = ((3 * 3) * 2) - 1
            Integer r = mul.andThen(times2).andThen(minus1).apply(3, 3);
        }
        catch (NullPointerException e) {
            System.out.println("catch1 display");
        }
        catch (ArithmeticException e) {
            System.out.println("catch2 display");
        }
        finally {
            System.out.println("finally display");
        }


    }

    public void print() {
        System.out.println("print Main");
    }
    public void see() {
        System.out.println("see Main");
    }

    public void eat() {
        System.out.println("eat Main");
    }

}

    class Parent {
    public void display() {
        System.out.println("Parent display");
    }
    }

class Child extends Parent {
    public void display() {
        System.out.println("Child display");
    }
}
