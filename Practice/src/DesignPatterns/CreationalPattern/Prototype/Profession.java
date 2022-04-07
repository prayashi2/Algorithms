package DesignPatterns.CreationalPattern.Prototype;

public abstract class Profession implements Cloneable {

    public int id;
    public String name;

    abstract void print();

    public Object cloningMehod() {
        Object clone = null;
        try {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
