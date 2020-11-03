package com.cg.petpalace.services;

import com.cg.petpalace.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    //Custom method...
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
