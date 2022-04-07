@FunctionalInterface
public interface prayTestFunc {

     int hi=1;
    void  see();


    default void print() {
        System.out.println("print");
    }
    default void add() {
        System.out.println("add int");
    }

    static void eat() {
        System.out.println("eat int");
    }

}
