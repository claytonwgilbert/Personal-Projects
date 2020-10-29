package com.cg.petpalace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class PetType extends BaseEntity{

    @Column(name="name")
    private String name;

    public String getPetType() {
        return name;
    }

    public void setPetType(String petType) {
        this.name = petType;
    }
}
