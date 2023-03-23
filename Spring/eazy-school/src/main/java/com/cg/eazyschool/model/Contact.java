package com.cg.eazyschool.model;
import lombok.Data;

import javax.validation.constraints.*;


@Data
public class Contact {
    @NotBlank(message = "Name must not be blank")
    @Size(min=3, message = "Name must be at least 3 characters long")
    private String name;
    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Please enter a(n) mobile number in proper format")
    private String mobileNum;
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please enter an email in the proper format")
    private String email;
    @NotBlank(message = "Subject must not be blank")
    @Size(min=3, message = "Subject must be at least 3 characters long")
    private String subject;
    @NotBlank(message = "Message must not be blank")
    @Size(min=5, message = "Message must be at least 6 characters long")
    private String message;
}
