package serenitylabs.tutorials.vetclinic.domain;

import com.google.common.collect.ImmutableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal implements NeedsVaccination{

    public static final String COMPLAINT = "Meaow";

    private final String name;
    private final String breed;
    private final List<String> colour;

    private LocalDate lastVaccinationDate;

    public Cat(String name, String breed, List<String> colour) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + " the " + (colour + " " + breed).toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public List<String> getColour() {
        return new ArrayList(colour);
    }

    public static CatBuilder called(String name) {
        return new CatBuilder(name);
    }

    @Override
    public String complaint() {
        return COMPLAINT;
    }

    @Override
    public String getComplaint() {
        return COMPLAINT;
    }

    @Override
    public void wasVaccinated(LocalDate lastVaccinationDate) {
        this.lastVaccinationDate = lastVaccinationDate;
    }

    @Override
    public LocalDate nextVaccinationDue() {
        return this.lastVaccinationDate.plusYears(1);
    }

    public static class CatBuilder {
        private final String name;
        private String breed;

        public CatBuilder(String name) {
            this.name = name;
        }

        public CatBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Cat andOfColour(String... colour) {
            return new Cat(name, breed, ImmutableList.copyOf(colour));
        }
    }
}
