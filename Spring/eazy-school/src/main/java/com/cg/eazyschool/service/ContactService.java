package com.cg.eazyschool.service;

import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.model.EazySchoolConstants;
import com.cg.eazyschool.repository.ContactsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactService {
    private ContactsRepository contactsRepository;

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

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> openContacts = contactsRepository.findByStatus(EazySchoolConstants.OPEN);

        return openContacts;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        Optional<Contact> foundContact = contactsRepository.findById(contactId);
        foundContact.ifPresent(contactRef -> {
            contactRef.setStatus(EazySchoolConstants.CLOSE);
            //Handled by auditing in base entity
            //contactRef.setUpdatedAt(LocalDateTime.now());
            //contactRef.setUpdatedBy(updatedBy);
        });
        Contact updatedContact = contactsRepository.save(foundContact.get());
        if(updatedContact != null && !updatedContact.getUpdatedBy().equals(null)){
            isUpdated = true;
        }
        return isUpdated;
    }
}
