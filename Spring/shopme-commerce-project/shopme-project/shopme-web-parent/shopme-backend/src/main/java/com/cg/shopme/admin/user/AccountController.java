package com.cg.shopme.admin.user;

import com.cg.shopme.admin.FileUploadUtil;
import com.cg.shopme.admin.security.ShopmeUserDetails;
import com.cg.shopme.common.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class AccountController {

    private UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public String viewAccountDetails(@AuthenticationPrincipal ShopmeUserDetails loggedInUser, Model model){
        String userEmail = loggedInUser.getUsername();

        User user = userService.getUserByEmail(userEmail);

        model.addAttribute("user", user);

        return "account_form";
    }

    @PostMapping("/account/update")
    public String updateUserAccount(User user, RedirectAttributes redirectAttributes,
                                    @RequestParam("image") MultipartFile multipartFile,
                                    @AuthenticationPrincipal ShopmeUserDetails loggedInUser) throws IOException {
        if(!multipartFile.isEmpty()){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename()); // - Get simple filename
            fileName = fileName.replace(' ', '-'); // - Remove space and replace with dash
            user.setPhotos(fileName); // - Assign photo to user from form
            User newUserWithPhoto = userService.updateUserAccount(user);

            String uploadDir = "user-photos/" + newUserWithPhoto.getId(); // - Create directory path for photo
            FileUploadUtil.cleanDirectory(uploadDir); // - Remove old photos before adding new one...
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); // - Save new photo for user
        }else{
            if(user.getPhotos().isEmpty()) user.setPhotos(null);
            this.userService.updateUserAccount(user);
        }

        loggedInUser.setFirstName(user.getFirstName());
        loggedInUser.setLastName(user.getLastName());

        redirectAttributes.addFlashAttribute("message", "The user was updated successfully.");

        return "redirect:/account";
    }
}
