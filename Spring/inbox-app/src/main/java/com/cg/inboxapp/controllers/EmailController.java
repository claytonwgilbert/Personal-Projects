package com.cg.inboxapp.controllers;

import com.cg.inboxapp.email.Email;
import com.cg.inboxapp.email.EmailRepository;
import com.cg.inboxapp.email.EmailService;
import com.cg.inboxapp.emailslist.EmailsList;
import com.cg.inboxapp.emailslist.EmailsListPrimaryKey;
import com.cg.inboxapp.emailslist.EmailsListRepository;
import com.cg.inboxapp.folders.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class EmailController {

    private FolderRepository folderRepository;
    private FolderService folderService;
    private EmailRepository emailRepository;
    private EmailService emailService;
    private UnreadEmailStatsRepository unreadEmailStatsRepository;
    private EmailsListRepository emailsListRepository;

    public EmailController(FolderRepository folderRepository, FolderService folderService, EmailRepository emailRepository, EmailService emailService, UnreadEmailStatsRepository unreadEmailStatsRepository, EmailsListRepository emailsListRepository) {
        this.folderRepository = folderRepository;
        this.folderService = folderService;
        this.emailRepository = emailRepository;
        this.emailService = emailService;
        this.unreadEmailStatsRepository = unreadEmailStatsRepository;
        this.emailsListRepository = emailsListRepository;
    }

    @GetMapping("/email/{emailId}")
    public String viewEmail(@PathVariable UUID emailId,
                            @AuthenticationPrincipal OAuth2User principal, Model model,
                            @RequestParam(required = false) String folder){
        if(principal == null || StringUtils.hasText(principal.getAttribute("login"))){
            return "index";
        }

        String userId = principal.getAttribute("login");

        //Mark email read and decrement unread total
        emailService.markEmailReadAndDecrement(emailId, userId, folder);

        //Retrieve email to view
        Optional<Email> optionalEmail = emailRepository.findById(emailId);
        if(!optionalEmail.isPresent()){
            return "inbox-page";
        }
        Email emailToView = optionalEmail.get();
        String toIds = String.join(",", emailToView.getTo());
        model.addAttribute("email", emailToView);
        model.addAttribute("toIds", toIds);

        EmailsListPrimaryKey emailsListPrimaryKey = new EmailsListPrimaryKey();
        emailsListPrimaryKey.setUserId(userId);
        emailsListPrimaryKey.setLabel(folder);
        emailsListPrimaryKey.setTimeId(emailToView.getId());

        //Check if email has already been read or not
        Optional<EmailsList> findById = emailsListRepository.findById(emailsListPrimaryKey);
        if(findById.isPresent()){
            EmailsList item = findById.get();
            if(item.isRead() == false){
                item.setRead(true);
                emailsListRepository.save(item);
                unreadEmailStatsRepository.decrementUnreadCount(userId, folder);
            }
        }
        model.addAttribute("stats", folderService.mapCountToLabels(userId));

        //Get user folders
        List<Folder> userFolders = folderRepository.findAllById(userId);
        model.addAttribute("userFolders", userFolders);

        List<Folder> defaultFolders = folderService.initDefaultUserFolders(userId);
        model.addAttribute("defaultFolders", defaultFolders);

        model.addAttribute("stats", folderService.mapCountToLabels(userId));

        return "email-page";
    }
}
