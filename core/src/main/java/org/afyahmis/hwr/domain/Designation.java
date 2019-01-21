package org.afyahmis.hwr.domain;

import org.afyahmis.hwr.sharedkernel.domain.AggregateRoot;

import javax.persistence.*;
import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Designation extends AggregateRoot<String> {

    @Column
    private String description;

    @OneToMany(mappedBy = "designation", fetch = FetchType.LAZY)
    private List<Workforce> personnel = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public List<Workforce> getPersonnel() {
        return personnel;
    }

    private Designation() {
    }

    public Designation(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public void AddWorkforce(Workforce workforce) {
        workforce.setDesignation(this);
        this.personnel.add(workforce);
    }

    @Override
    public String toString() {
        return id + " " + description;
    }
}
