package serenitylabs.tutorials.vetclinic.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Performable {

    private final Pet pet;
    private final PetHotel hotel;

    public CheckIn(Pet pet, PetHotel hotel) {
        this.pet = pet;
        this.hotel = hotel;
    }

    @Step("Petra checks in #pet into the hotel #hotel")
    @Override
    public <T extends Actor> void performAs(T t) {
        hotel.checkIn(pet);
    }

    public static CheckInBuilder aPet(Pet pet) {
        return new CheckInBuilder(pet);
    }

    public static class CheckInBuilder {
        private final Pet pet;

        public CheckInBuilder(Pet pet) {

            this.pet = pet;
        }

        public Performable into(PetHotel hotel) {
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet, hotel);
        }
    }
}
