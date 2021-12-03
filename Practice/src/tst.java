import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public void setId(int id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class tst {
    public static void main(String args[]) {
        Map<Integer, List<Employee>> map = new HashMap();
        List l = new ArrayList();
        l.add(new Employee(1, "prayashi"));
        l.add(new Employee(2, "abc"));
        l.add(new Employee(3, "bcgg"));
        map.put(1, l);
        map.put(2, l);
        map.put(3, l);
        map.put(4, l);

        for(List<Employee> l1 : map.values()) {
            l1.stream().map(Employee::getName).sorted().forEach(System.out::println);
            List<String> lo1 = l1.stream().map(Employee::getName).sorted().collect(Collectors.toList());
            for(String s : lo1) {
                System.out.println(s);
            }
        }

        System.out.println("Hi");

        for(List<Employee> l2 : map.values()) {
            for(Employee e : l2) {
                System.out.println(e.getName());
            }

        }

    }
}
