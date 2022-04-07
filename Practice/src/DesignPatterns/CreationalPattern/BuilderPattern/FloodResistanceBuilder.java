package DesignPatterns.CreationalPattern.BuilderPattern;

public class FloodResistanceBuilder implements Builder {

    private Home floodResistanceHome = new Home();

    @Override
    public void buildFloor() {
        this.floodResistanceHome.floor = "10 feets above ground level floor";
    }

    @Override
    public void buildWalls() {
        this.floodResistanceHome.walls = "Water resistance walls";
    }

    @Override
    public void buildTerrace() {
        this.floodResistanceHome.terrace = "Water leakage resistance terrace";
    }

    @Override
    public Home getComplexHomeObject() {
        return this.floodResistanceHome;
    }
}
