package DesignPatterns.CreationalPattern.Prototype;

public class PrototypePatternMainClass {

    public static void main(String[] args) {
        ProfessionCache.loadProfessionCache();

        Profession docProfession1 = ProfessionCache.getCloneNewProfession(1);
        System.out.println(docProfession1);

        Profession enggProfession1 = ProfessionCache.getCloneNewProfession(2);
        System.out.println(enggProfession1);

        Profession teachProfession = ProfessionCache.getCloneNewProfession(3);
        System.out.println(teachProfession);

        Profession docProfession2 = ProfessionCache.getCloneNewProfession(1);
        System.out.println(docProfession2);
    }
}
