package DesignPatterns.CreationalPattern.BuilderPattern;

public class EarthQuakeResistanceBuilder implements Builder {

    private Home earthQuakeResistanceHome = new Home();

    @Override
    public void buildFloor() {
        this.earthQuakeResistanceHome.floor = "Wooden floor";
    }

    @Override
    public void buildWalls() {
        this.earthQuakeResistanceHome.walls = "Wooden walls";
    }

    @Override
    public void buildTerrace() {
        this.earthQuakeResistanceHome.terrace = "Wooden terrace";
    }

    @Override
    public Home getComplexHomeObject() {
        return this.earthQuakeResistanceHome;
    }
}
