package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class WhenCollectingAnimals {

    @Test
    public void a_list_of_animals_can_contain_cats_and_dogs() {

        Dog fido = Dog.called("Fido")
                        .ofBreed("Labrador")
                        .andOfColour("Black");

        Cat felix = Cat.called("Felix")
                        .ofBreed("Siamese")
                        .andOfColour("White");

        List<Animal> animals = new ArrayList();
        animals.add(fido);
        animals.add(felix);

        assertThat(animals, hasItems(fido, felix));

    }

    @Test
    public void a_dog_complains_by_growling() {

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .andOfColour("Black");

        assertThat(fido.complaint(), is(equalTo(Dog.COMPLAINT)));

    }

    @Test
    public void a_cat_complains_by_miaowing() {

        Cat felix = Cat.called("Felix")
                .ofBreed("Siamese")
                .andOfColour("White");

        assertThat(felix.complaint(), is(equalTo(Cat.COMPLAINT)));

    }
}
