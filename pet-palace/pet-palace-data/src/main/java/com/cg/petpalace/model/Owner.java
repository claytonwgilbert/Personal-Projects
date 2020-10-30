package com.cg.petpalace.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName,
                 String address, String city, String phone,
                 Set<Pet> pets){
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
