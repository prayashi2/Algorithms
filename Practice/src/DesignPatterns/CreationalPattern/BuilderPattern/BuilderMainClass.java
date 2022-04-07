package DesignPatterns.CreationalPattern.BuilderPattern;

public class BuilderMainClass {

    public static void main(String[] args) {

        EarthQuakeResistanceBuilder earthQuakeResistanceBuilder = new EarthQuakeResistanceBuilder();

        Director director = new Director(earthQuakeResistanceBuilder);
        director.manageRequiredHomeConstruction();
        Home homeConstructedAtTheEnd = director.getComplexObjectOfHome();

        System.out.println(homeConstructedAtTheEnd);
        System.out.println(homeConstructedAtTheEnd.floor);
    }

}
