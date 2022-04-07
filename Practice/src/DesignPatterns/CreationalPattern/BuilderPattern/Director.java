package DesignPatterns.CreationalPattern.BuilderPattern;

public class Director {

    public Builder builder;

    public Director(Builder builderType) {
        this.builder = builderType;
    }

    public Home getComplexObjectOfHome() {
        return this.builder.getComplexHomeObject();
    }

    public void manageRequiredHomeConstruction() {
        this.builder.buildFloor();
        this.builder.buildWalls();
        this.builder.buildTerrace();
    }
}
