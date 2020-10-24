package com.cg.petpalace.services;

import com.cg.petpalace.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    //Custom method...
    Owner findByLastName(String lastName);
}
