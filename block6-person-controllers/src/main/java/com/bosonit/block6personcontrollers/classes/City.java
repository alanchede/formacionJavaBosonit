package com.bosonit.block6personcontrollers.classes;

public class City {
    String name;
    int population;

    public City() {
        this.name = "City";
        this.population = 0;
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
