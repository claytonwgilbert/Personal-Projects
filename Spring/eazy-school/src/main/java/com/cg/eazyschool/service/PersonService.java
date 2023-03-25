package com.cg.eazyschool.service;

import com.cg.eazyschool.model.EazySchoolConstants;
import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.model.Roles;
import com.cg.eazyschool.repository.PersonRepository;
import com.cg.eazyschool.repository.RolesRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private RolesRepository rolesRepository;

    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
    }

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
