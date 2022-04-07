package DesignPatterns.CreationalPattern.AbstractFactoryPattern;

public class ProfessionAbstractFactory extends AbstractFactory {

    public Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null) return null;
        if(typeOfProfession.equalsIgnoreCase("Engineer")) return new Engineer();
        if(typeOfProfession.equalsIgnoreCase("Teacher")) return new Teacher();
        return null;
    }
}
