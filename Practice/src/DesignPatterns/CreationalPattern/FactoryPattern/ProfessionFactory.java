package DesignPatterns.CreationalPattern.FactoryPattern;

public class ProfessionFactory {

    public Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null) return null;
        if(typeOfProfession.equalsIgnoreCase("Engineer")) return new Engineer();
        if(typeOfProfession.equalsIgnoreCase("Doctor")) return new Doctor();
        if(typeOfProfession.equalsIgnoreCase("Teacher")) return new Teacher();
        return null;
    }
}
