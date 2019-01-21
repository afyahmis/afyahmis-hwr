package org.afyahmis.hwr.domain;

import org.afyahmis.hwr.sharedkernel.domain.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Workforce extends AggregateRoot<UUID> {

    @Column
    private String code;
    @Column
    private String firstName;
    @Column
    private String middleName;
    @Column
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    public String getCode() {
        return code;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Designation getDesignation() {
        return designation;
    }

    private Workforce(){
    }

    public Workforce(String code, String firstName, String middleName, String lastName, Designation designation) {
        this.code = code;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.designation = designation;
    }
}
