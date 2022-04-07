package DesignPatterns.CreationalPattern.Singleton;

public class SingletonClass {

    private static SingletonClass singletonInstance = new SingletonClass();

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        return singletonInstance;
    }

    public void simpleMethod() {
        System.out.println("HashCode of singleton Object " + singletonInstance);
    }
}
