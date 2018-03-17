package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCreatingANewDog {

    @Test
    public void itShoudHaveAName() throws Exception {

        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = new Dog("Fido", "Poodle", dateOfBirth);
        assertThat(fido.getName(), is("Fido"));
        assertThat(fido.getBreed(), is("Poodle"));
        assertThat(fido.getDateOfBirth(), is(dateOfBirth));
    }
}
