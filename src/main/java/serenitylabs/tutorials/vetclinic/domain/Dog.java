package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDateTime dateOfBirth;
    private String favouriteFood;
    private final String colour;

    private Dog(String name, String breed, LocalDateTime dateOfBirth, String favouriteFood, String colour) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.favouriteFood = favouriteFood;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public static WithBreed called(String name) {
        return new DogBuilder(name);
    }

    public String getColour() {
        return colour;
    }

    public interface WithBreed {
        OfColour ofBreed(String breed);
    }

    public interface OfColour {
        DogBuilder ofColour(String colour);
    }

    public static class DogBuilder implements WithBreed, OfColour {
        private String name;
        private String breed;
        private LocalDateTime dateOfBirth;
        private String favouriteFood;
        private String colour;

        public DogBuilder(String name) {
            this.name = name;
        }

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
    }
}
