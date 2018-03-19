package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public  class DogBuilder implements WithBreed, OfColour {
    private String name;
    private String breed;
    private LocalDateTime dateOfBirth;
    private String favouriteFood;
    private String colour;

    @Override
    public DogBuilder ofBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public Dog bornOn(LocalDateTime dateOfBirth) {
        return new Dog(name, breed, dateOfBirth, favouriteFood, colour);
    }

    public DogBuilder withFavouriteFoodOf(String favouriteFood) {
        this.favouriteFood = favouriteFood;
        return this;
    }

    @Override
    public DogBuilder ofColour(String colour) {
        this.colour = colour;
        return this;
    }

    public static DogBuilder aDog() {
            return new DogBuilder();
    }

    public DogBuilder called(String name) {
        this.name = name;
        return this;
    }

    public static DogBuilder aLargeDog() {
        return aDog().ofBreed("Labrador");
    }

    public static DogBuilder aSmallDog() {
        return aDog().ofBreed("Poodle");
    }
}