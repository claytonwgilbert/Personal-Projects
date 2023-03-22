package com.cg.eazyschool.service;

import com.cg.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        log.info(contact.toString());
        return isSaved = true;
    }
}
