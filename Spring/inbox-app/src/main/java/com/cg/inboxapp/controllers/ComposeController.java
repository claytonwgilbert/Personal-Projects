package com.cg.inboxapp.controllers;

import com.cg.inboxapp.email.Email;
import com.cg.inboxapp.email.EmailService;
import com.cg.inboxapp.folders.Folder;
import com.cg.inboxapp.folders.FolderRepository;
import com.cg.inboxapp.folders.FolderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class ComposeController {

    private FolderRepository folderRepository;
    private FolderService folderService;
    private EmailService emailService;

    public ComposeController(FolderRepository folderRepository, FolderService folderService, EmailService emailService) {
        this.folderRepository = folderRepository;
        this.folderService = folderService;
        this.emailService = emailService;
    }

    @GetMapping("/compose")
    public String getComposePage(@AuthenticationPrincipal OAuth2User principal, Model model,
                                 @RequestParam(required = false) String recipients){
        if(principal == null || StringUtils.hasText(principal.getAttribute("login"))){
            return "index";
        }
        //Get user folders
        String userId = principal.getAttribute("login");

        List<Folder> userFolders = folderRepository.findAllById(userId);
        model.addAttribute("userFolders", userFolders);

        List<Folder> defaultFolders = folderService.initDefaultUserFolders(userId);
        model.addAttribute("defaultFolders", defaultFolders);

        //Split ids
        List<String> recipientList = splitIds(recipients);
        model.addAttribute("toIds", String.join(", ", recipientList));

        return "compose-page";
    }

    @PostMapping("/sendEmail")
    public ModelAndView sendEmail(@AuthenticationPrincipal OAuth2User principal,
                                  @RequestBody MultiValueMap<String, String> formData){
        if(principal == null || StringUtils.hasText(principal.getAttribute("login"))){
            return new ModelAndView("redirect:/");
        }

        String from = formData.getFirst("from");
        List<String> recipientList = splitIds(formData.getFirst("toIds"));
        String subject = formData.getFirst("subject");
        String body = formData.getFirst("body");

        emailService.sendEmail(from, recipientList, subject, body);

        return new ModelAndView("redirect:/");
    }

    private List<String> splitIds(String recipients) {
        if(!StringUtils.hasText(recipients)){
            return new ArrayList<>();
        }
        String[] recipientArray = recipients.split(",");
        List<String> recipientList = Arrays.asList(recipientArray)
                .stream()
                .map(i -> StringUtils.trimWhitespace(i))
                .filter(i -> StringUtils.hasText(i))
                .distinct()
                .collect(Collectors.toList());
        return recipientList;
    }
}
