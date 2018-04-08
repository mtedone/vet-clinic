package serenitylabs.tutorials.vetclinic.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

@Subject("the pets in the hotel")
public class TheRegisteredGuests implements Question<List<Pet>>{

    private final PetHotel hotel;

    public TheRegisteredGuests(PetHotel hotel) {

        this.hotel = hotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return hotel.getPets();
    }

    public static Question<List<Pet>> in(PetHotel hotel) {
        return new TheRegisteredGuests(hotel);
    }
}
