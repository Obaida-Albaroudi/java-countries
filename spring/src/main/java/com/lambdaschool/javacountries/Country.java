package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{

    private static final AtomicLong counter = new AtomicLong();

    private long id;
    private String name;
    private int population;
    private int landMass;
    private int medianAge;

    public Country(String name, int population, int landMass, int medianAge)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country(Country toClone)
    {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMass = toClone.getLandMass();
        this.medianAge = toClone.getMedianAge();

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getLandMass() {
        return landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }
    public int getWordLength() {
        return getName().length();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
