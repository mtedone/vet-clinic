package serenitylabs.tutorials.vetclinic.domain;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    private final String name;
    private final String breed;
    private final List<String> colours;


    public Dog(String name, String breed, List<String> colours) {

        this.name = name;
        this.breed = breed;
        this.colours = colours;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public List<String> getColours() {
        return new ArrayList<>(colours);
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {
        private final String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog andOfColour(String... colours) {
            return new Dog(name, breed, ImmutableList.copyOf(colours));
        }
    }

    @Override
    public String toString() {
        return name + " the " + (colours.get(0) + " " + breed).toLowerCase();

    }
}
