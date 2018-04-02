package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRegister {


    private List<String> complaints = new ArrayList<>();

    public List<String> getComplaints() {
        return complaints;
    }

    public void addComplaint(String complaint) {
        complaints.add(complaint);
    }
}
