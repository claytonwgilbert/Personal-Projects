package com.cg.inboxapp.controllers;

import com.cg.inboxapp.emailslist.EmailsList;
import com.cg.inboxapp.emailslist.EmailsListRepository;
import com.cg.inboxapp.folders.*;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class InboxController {

    private FolderRepository folderRepository;
    private FolderService folderService;
    private EmailsListRepository emailsListRepository;
    private UnreadEmailStatsRepository unreadEmailStatsRepository;

    public InboxController(FolderRepository folderRepository, FolderService folderService, EmailsListRepository emailsListRepository, UnreadEmailStatsRepository unreadEmailStatsRepository) {
        this.folderRepository = folderRepository;
        this.folderService = folderService;
        this.emailsListRepository = emailsListRepository;
        this.unreadEmailStatsRepository = unreadEmailStatsRepository;
    }

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model,
                           @RequestParam(required = false) String folder){
        if(principal == null || StringUtils.hasText(principal.getAttribute("login"))){
            return "index";
        }
        //Get user folders
        String userId = principal.getAttribute("login");

        List<Folder> userFolders = folderRepository.findAllById(userId);
        model.addAttribute("userFolders", userFolders);

        List<Folder> defaultFolders = folderService.initDefaultUserFolders(userId);
        model.addAttribute("defaultFolders", defaultFolders);

        model.addAttribute("stats", folderService.mapCountToLabels(userId));

        //Get messages for user folders to display
        if(!StringUtils.hasText(folder)){
            folder = "Inbox";
        }
        List<EmailsList> folderEmailItems = emailsListRepository.findAllById_UserIdAndId_Label(userId, folder);

        //Format
        PrettyTime prettyTime = new PrettyTime();
        folderEmailItems.stream().forEach(item -> {
            UUID timeStamp = item.getId().getTimeId();
            Date date = new Date(Uuids.unixTimestamp(timeStamp));
            String messageReceivedDate = prettyTime.format(date);
            item.setAgoTimeString(messageReceivedDate);
        });

        model.addAttribute("folderEmails", folderEmailItems);

        return "inbox-page";
    }

}
