package com.cg.eazyschool.service;

import com.cg.eazyschool.config.EazySchoolProps;
import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.model.EazySchoolConstants;
import com.cg.eazyschool.repository.ContactsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactService {
    private ContactsRepository contactsRepository;

    //Practicing @ConfigurationProperties
    @Autowired
    private EazySchoolProps eazySchoolProps;

    public ContactService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        //Handled by auditing in base entity
        //contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        //contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = contactsRepository.save(contact);
        if(savedContact.getContactId() > 0){
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        //Creating pagination object to send back to the UI
        //Setting page size to global one...
        int pageSize = eazySchoolProps.getPageSize();
        //Checking if we have a contact specific page size and if so...set page size to that in configuration file
        if(eazySchoolProps.getContact() != null || eazySchoolProps.getContact().get("pageSize") != null){
            pageSize = Integer.parseInt(eazySchoolProps.getContact().get("pageSize").trim());
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());

        Page<Contact> foundContacts = contactsRepository.findByStatusQuery(EazySchoolConstants.OPEN, pageable);

        return foundContacts;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int rows = contactsRepository.updateStatusById(EazySchoolConstants.CLOSE, contactId);
        if(rows > 0){
            isUpdated = true;
        }
        return isUpdated;
    }
}
