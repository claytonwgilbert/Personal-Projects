package com.cg.eazyschool.service;

import com.cg.eazyschool.model.EazySchoolConstants;
import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.model.Roles;
import com.cg.eazyschool.repository.PersonRepository;
import com.cg.eazyschool.repository.RolesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;

    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd())); //Encoding our plain text password to hash value for db saving
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
