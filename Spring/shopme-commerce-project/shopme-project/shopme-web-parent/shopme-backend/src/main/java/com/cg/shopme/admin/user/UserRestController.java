package com.cg.shopme.admin.user;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // - REST call called from html form before form is submitted.
    @PostMapping("/users/check_email")
    public String doesEmailAlreadyExist(@Param("userId") Integer userId, @Param("email") String email){
        String result = userService.checkIfEmailIsUnique(userId, email) ? "OK" : "DUPLICATE";
        return result;
    }

}
