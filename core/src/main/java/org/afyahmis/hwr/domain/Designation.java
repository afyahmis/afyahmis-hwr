package org.afyahmis.hwr.domain;

import org.afyahmis.hwr.sharedkernel.domain.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.swing.text.Style;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Designation extends AggregateRoot<String> {

    @Column
    private String description;

    @OneToMany(mappedBy = "designation")
    private Set<Workforce> personnel = new HashSet<>();

    public String getDescription() {
        return description;
    }

    public Set<Workforce> getPersonnel() {
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
        return "Designation{" +
                "description='" + description + '\'' +
                ", personnel=" + personnel +
                '}';
    }
}
