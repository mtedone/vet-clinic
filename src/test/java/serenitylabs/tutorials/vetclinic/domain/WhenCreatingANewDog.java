package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCreatingANewDog {

    @Test
    public void itShoudHaveAName() throws Exception {

        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = Dog.called("Fido")
                      .ofBreed("Poodle")
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
