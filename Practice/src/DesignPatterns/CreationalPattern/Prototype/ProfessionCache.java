package DesignPatterns.CreationalPattern.Prototype;

import java.util.Hashtable;

public class ProfessionCache {

    private static Hashtable<Integer, Profession> professionMap = new Hashtable<Integer, Profession>();

    public static Profession getCloneNewProfession(int id) {
        Profession cachedProfessionInstance = professionMap.get(id);
        return (Profession) cachedProfessionInstance.cloningMehod();
    }

    public static void loadProfessionCache() {
        Doctor doc = new Doctor();
        doc.id=1;
        professionMap.put(doc.id, doc);

        Engineer engg = new Engineer();
        engg.id=2;
        professionMap.put(engg.id, engg);

        Teacher teacher = new Teacher();
        teacher.id=3;
        professionMap.put(teacher.id, teacher);

    }
}
