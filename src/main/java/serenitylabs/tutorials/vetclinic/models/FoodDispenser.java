package serenitylabs.tutorials.vetclinic.models;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;
import java.util.Map;

public class FoodDispenser {

    private static final Map<Breed, PetFood> FOOD_BY_PET = new HashMap<>();
    private final static Map<Breed, Integer> GRAMS_PER_KILO_BY_PET = new HashMap<>();

    static {
        FOOD_BY_PET.put(Breed.Cat, PetFood.KittyKat);
        FOOD_BY_PET.put(Breed.Dog, PetFood.FidosFood);
        GRAMS_PER_KILO_BY_PET.put(Breed.Cat, 10);
        GRAMS_PER_KILO_BY_PET.put(Breed.Dog, 20);
    }

    public Meal prepareMealForPet(Pet pet) {
        return new Meal(rightAmoutOfFoodForPet(pet), rightFoodBrandFor(pet));
    }

    private PetFood rightFoodBrandFor(Pet pet) {
        return FOOD_BY_PET.get(pet.getBreed());
    }

    private double rightAmoutOfFoodForPet(Pet pet) {
        return pet.getWeightInKilos() * GRAMS_PER_KILO_BY_PET.get(pet.getBreed());
    }
}
