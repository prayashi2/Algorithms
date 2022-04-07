package DesignPatterns.CreationalPattern.AbstractFactoryPattern;

public class AbstractFactoryPatternMainClass {

    public static void main(String[] args) {

        AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession(true);
        Profession engg = abstractFactory.getProfession("Engineer");
        engg.print();
    }
}
