package com.cg.petpalace.services;

import com.cg.petpalace.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
