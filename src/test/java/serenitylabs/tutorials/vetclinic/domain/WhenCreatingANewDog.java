package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCreatingANewDog {

    @Test
    public void itShoudBeALargeDog() throws Exception {

        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = DogBuilder.aLargeDog().called("Fido")
                      .ofColour("Black")
                      .withFavouriteFoodOf("Pizza")
                      .bornOn(dateOfBirth);

        assertThat(fido.getName(), is("Fido"));
        assertThat(fido.getBreed(), is("Labrador"));
        assertThat(fido.getFavouriteFood(), is("Pizza"));
        assertThat(fido.getDateOfBirth(), is(dateOfBirth));
        assertThat(fido.getColour(), is("Black"));
    }

    @Test
    public void itShoudBeASmallDog() throws Exception {

        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = DogBuilder.aSmallDog().called("Fido")
                .ofColour("Black")
                .withFavouriteFoodOf("Pizza")
                .bornOn(dateOfBirth);

        assertThat(fido.getName(), is("Fido"));
        assertThat(fido.getBreed(), is("Poodle"));
        assertThat(fido.getFavouriteFood(), is("Pizza"));
        assertThat(fido.getDateOfBirth(), is(dateOfBirth));
        assertThat(fido.getColour(), is("Black"));
    }


}
