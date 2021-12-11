package com.cg.shopme.admin.user;

import com.cg.shopme.admin.FileUploadUtil;
import com.cg.shopme.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showFirstPage(Model model){
        return listByPage(1,"id", "asc", null, model);
    }

    @GetMapping("/users/page/{number}")
    public String listByPage(@PathVariable(name="number") int pageNumber, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, @RequestParam(name="keyword", required = false) String searchTerm, Model model){
        Page<User> userPage = userService.listByPage(pageNumber, sortField, sortDir, searchTerm);
        List<User> users = userPage.getContent();

        long startCount = (pageNumber - 1) * UserService.USERS_PER_PAGE + 1;
        long endingCount = startCount + UserService.USERS_PER_PAGE - 1;
        if(endingCount > userPage.getTotalElements()){
            endingCount = userPage.getTotalElements();
        }

        String reverseSortOrder = sortDir.equals("asc") ? "desc" : "asc";

        model.addAttribute("startCount", startCount);
        model.addAttribute("endingCount", endingCount);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalElements", userPage.getTotalElements());
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", reverseSortOrder);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/users/new")
    public String createNewUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", userService.getAllRoles());
        model.addAttribute("pageTitle", "Create New User");

        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveNewUser(User user, RedirectAttributes redirectAttributes, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename()); // - Get simple filename
            fileName = fileName.replace(' ', '-'); // - Remove space and replace with dash
            user.setPhotos(fileName); // - Assign photo to user from form
            User newUserWithPhoto = userService.saveNewUser(user);
            String uploadDir = "user-photos/" + newUserWithPhoto.getId(); // - Create directory path for photo
            FileUploadUtil.cleanDirectory(uploadDir); // - Remove old photos before adding new one...
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); // - Save new photo for user
        }else{
            if(user.getPhotos().isEmpty()) user.setPhotos(null);
            this.userService.saveNewUser(user);
        }

        redirectAttributes.addFlashAttribute("message", "The user was saved successfully.");

        return "redirect:/users/page/1?sortField=id&sortDir=asc&keyword=" + user.getEmail().split("@")[0];
    }

    @GetMapping("/users/edit/{id}")
    public String editExistingUser(@PathVariable("id") Integer userId, Model model, RedirectAttributes redirectAttributes) throws UserNotFoundException{
        User user = new User();
        try{
            user = this.userService.findUserById(userId);
            userService.getAllRoles();
            model.addAttribute("user", user);
            model.addAttribute("listRoles", userService.getAllRoles());
            model.addAttribute("pageTitle", "Edit User (ID: " + userId +")");
            return "user_form";
        }catch (UserNotFoundException ex){
            redirectAttributes.addFlashAttribute("error", ex.getMessage());

            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer userId, RedirectAttributes redirectAttributes) throws UserNotFoundException{
        try {
            userService.deleteUser(userId);
            redirectAttributes.addFlashAttribute("message", "Deleting user with ID of " + userId + " was deleted successfully.");
        }catch (UserNotFoundException ex){
            redirectAttributes.addFlashAttribute("message", ex.getMessage().toString());
            return "redirect:/users";
        }
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/enabled/{status}")
    public String enableDisableUser(@PathVariable("id") Integer id, @PathVariable("status") boolean status, RedirectAttributes redirectAttributes) throws UserNotFoundException{
        userService.updateUserStatus(id, status);

        redirectAttributes.addFlashAttribute("message", "User status has been updated");
        return "redirect:/users";
    }

    @GetMapping("/users/export/csv")
    public void exportUserToCsv(HttpServletResponse httpServletResponse) throws IOException {
        UserCsvExporter exporter = new UserCsvExporter();
        exporter.export(userService.getAllUsers(), httpServletResponse);
    }


}
