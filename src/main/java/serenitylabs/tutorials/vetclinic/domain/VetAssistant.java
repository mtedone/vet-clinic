package serenitylabs.tutorials.vetclinic.domain;

public class VetAssistant {

    private final ComplaintRegister complaintRegister;

    public VetAssistant(ComplaintRegister complaintRegister) {

        this.complaintRegister = complaintRegister;
    }

    public void recordComplainFrom(Animal animal) {
        complaintRegister.addComplaint(animal.getComplaint());
    }
}
