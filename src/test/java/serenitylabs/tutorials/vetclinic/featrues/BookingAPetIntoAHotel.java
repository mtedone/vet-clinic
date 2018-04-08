package serenitylabs.tutorials.vetclinic.featrues;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.tasks.CheckIn;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

@RunWith(SerenityRunner.class)
public class BookingAPetIntoAHotel {

    Actor petra = Actor.named("Petra the pet owner");

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        //GIVEN
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel");

        //WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        //THEN
        petra.should(seeThat(TheRegisteredGuests.in(petHotel), hasItem(ginger)));
    }
}
