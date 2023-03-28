package com.cg.eazyschool.rest;

import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.model.EazySchoolConstants;
import com.cg.eazyschool.model.Response;
import com.cg.eazyschool.repository.ContactsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*") //Allows any other server to communicate with this server, can specify specific address such as http://localhost:8080
public class ContactRestController {

    private ContactsRepository contactsRepository;

    public ContactRestController(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @GetMapping("/getMessagesByStatus")
    //@ResponseBody not needed with @restController annotation
    public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status){
        return contactsRepository.findByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> save(@RequestHeader("invocationForm") String invocationForm,
                                         @Valid @RequestBody Contact contact){
        log.info(String.format("Header Invocation Form: %s", invocationForm));
        contactsRepository.save(contact);
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Successful save of message.");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isMsgSaved", "true")
                .body(response);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> save(RequestEntity<Contact> requestEntity){
        HttpHeaders headers = requestEntity.getHeaders();
        headers.forEach((key, value) ->
                log.info(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|")))));
        Contact contact = requestEntity.getBody();
        contactsRepository.delete(contact);
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Successful deletion of message.");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<Response> closeMsg(@RequestBody Contact contactReq){
        Response response = new Response();
        Optional<Contact> contact = contactsRepository.findById(contactReq.getContactId());
        if(contact.isPresent()){
            contact.get().setStatus(EazySchoolConstants.CLOSE);
            contactsRepository.save(contact.get());
        }else{
            response.setStatusCode("400");
            response.setStatusMsg("Invalid Contact ID received");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully closed");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
