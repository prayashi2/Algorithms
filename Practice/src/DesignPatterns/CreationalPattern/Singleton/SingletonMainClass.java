package DesignPatterns.CreationalPattern.Singleton;

import DesignPatterns.CreationalPattern.FactoryPattern.Teacher;

public class SingletonMainClass {

    public static void main(String[] args) {
        SingletonClass singletonObject1 = SingletonClass.getInstance();
        singletonObject1.simpleMethod();

        SingletonClass singletonObject2 = SingletonClass.getInstance();
        singletonObject2.simpleMethod();

        Teacher t1 = new Teacher();
        System.out.println(t1);
        Teacher t2 = new Teacher();
        System.out.println(t2);
    }
}
