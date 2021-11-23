package com.cg.shopme.admin.user;

import com.cg.shopme.common.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model){
        List<User> allUsers = userService.getAllUsers();

        model.addAttribute("users", allUsers);

        return "users";
    }

    @GetMapping("/users/new")
    public String createNewUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", userService.getAllRoles());

        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveNewUser(User user, RedirectAttributes redirectAttributes){
        this.userService.saveNewUser(user);

        redirectAttributes.addFlashAttribute("message", "The user was saved successfully.");

        return "redirect:/users";
    }
}
