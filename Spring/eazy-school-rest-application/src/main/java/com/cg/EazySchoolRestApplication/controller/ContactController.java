package com.cg.EazySchoolRestApplication.controller;

import com.cg.EazySchoolRestApplication.model.Contact;
import com.cg.EazySchoolRestApplication.model.Response;
import com.cg.EazySchoolRestApplication.proxy.ContactProxy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ContactController {
    private ContactProxy contactProxy;
    private RestTemplate restTemplate;
    private WebClient webClient;

    public ContactController(ContactProxy contactProxy, RestTemplate restTemplate, WebClient webClient) {
        this.contactProxy = contactProxy;
        this.restTemplate = restTemplate;
        this.webClient = webClient;
    }

    //Using Feign...using the feign interface in contactproxy
    //getMessageByStatus has to match exactly the same method name located in the eazy-school application, parameters must match too
    @GetMapping("/getMessages")
    public List<Contact> getMessages(@RequestParam("status") String status) {
        return contactProxy.getMessagesByStatus(status);
    }

    //Rest template...deprecated
    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestBody Contact contact){
        String uri = "http://localhost:8080/api/contact/saveMsg";
        HttpHeaders headers = new HttpHeaders();
        headers.add("invocationFrom","RestTemplate");
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact, headers);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(uri, HttpMethod.POST,
                httpEntity,Response.class);
        return responseEntity;
    }

    //Web Client
    @PostMapping("/saveMessage")
    public Mono<Response> saveMessage(@RequestBody Contact contact){
        String uri = "http://localhost:8080/api/contact/saveMsg";
        return webClient.post().uri(uri) //Specifying post request
                .header("invocationFrom","WebClient")//Can specify header values
                .body(Mono.just(contact),Contact.class)//Must wrap the contact bean in a mono in order to be non-blocking
                .retrieve() //Actually do operation
                .bodyToMono(Response.class); //return results
    }
}
