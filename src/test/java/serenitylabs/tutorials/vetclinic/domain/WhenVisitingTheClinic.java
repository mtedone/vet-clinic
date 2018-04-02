package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complain_to_the_assistant() {

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .andOfColour("Black");

        Cat felix = Cat.called("Felix")
                .ofBreed("Siamese")
                .andOfColour("White");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant assistant = new VetAssistant(complaintRegister);

        assistant.recordComplainFrom(fido);
        assistant.recordComplainFrom(felix);

        assertThat(complaintRegister.getComplaints(), hasItems(Dog.COMPLAINT, Cat.COMPLAINT));

    }
}
