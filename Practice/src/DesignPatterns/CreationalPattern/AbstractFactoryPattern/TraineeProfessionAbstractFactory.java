package DesignPatterns.CreationalPattern.AbstractFactoryPattern;

public class TraineeProfessionAbstractFactory extends AbstractFactory {

    public Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null) return null;
        if(typeOfProfession.equalsIgnoreCase("Engineer")) return new TraineeEngineer();
        if(typeOfProfession.equalsIgnoreCase("Teacher")) return new TraineeTeacher();
        return null;
    }
}
