package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public interface NeedsVaccination {
    void wasVaccinated(LocalDate lastVaccinationDate);

    LocalDate nextVaccinationDue();
}
