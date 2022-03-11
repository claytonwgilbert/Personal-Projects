package com.cg.inboxapp.email;

import com.cg.inboxapp.emailslist.EmailsList;
import com.cg.inboxapp.emailslist.EmailsListPrimaryKey;
import com.cg.inboxapp.emailslist.EmailsListRepository;
import com.cg.inboxapp.folders.UnreadEmailStatsRepository;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EmailService {

    private EmailRepository emailRepository;
    private EmailsListRepository emailsListRepository;
    private UnreadEmailStatsRepository unreadEmailStatsRepository;

    public EmailService(EmailRepository emailRepository, EmailsListRepository emailsListRepository, UnreadEmailStatsRepository unreadEmailStatsRepository) {
        this.emailRepository = emailRepository;
        this.emailsListRepository = emailsListRepository;
        this.unreadEmailStatsRepository = unreadEmailStatsRepository;
    }

    public void sendEmail(String from, List<String> to, String subject, String body){
        //send email to database
        Email emailToSend = new Email();
        emailToSend.setId(Uuids.timeBased());
        emailToSend.setFrom(from);
        emailToSend.setTo(to);
        emailToSend.setSubject(subject);
        emailToSend.setBody(body);

        emailRepository.save(emailToSend);

        for(String person : to){
            //send email item to person sending to inbox
            EmailsListPrimaryKey key = new EmailsListPrimaryKey();
            key.setTimeId(emailToSend.getId());
            key.setUserId(person);
            key.setLabel("Inbox");
            EmailsList emailItemTo = new EmailsList();
            emailItemTo.setId(key);
            emailItemTo.setTo(to);
            emailItemTo.setFrom(from);
            emailItemTo.setRead(false);
            emailItemTo.setSubject(subject);

            emailsListRepository.save(emailItemTo);
            unreadEmailStatsRepository.incrementUnreadCount(person, "Inbox");
        }

        //send email item to your own sent folder
        EmailsListPrimaryKey key2 = new EmailsListPrimaryKey();
        key2.setTimeId(emailToSend.getId());
        key2.setUserId(from);
        key2.setLabel("Sent Items");
        EmailsList emailItemSent = new EmailsList();
        emailItemSent.setId(key2);
        emailItemSent.setTo(to);
        emailItemSent.setFrom(from);
        emailItemSent.setRead(true);
        emailItemSent.setSubject(subject);

        emailsListRepository.save(emailItemSent);
    }

    public void markEmailReadAndDecrement(UUID emailId, String userId, String label){
        emailsListRepository.updateEmailListItemReadStatus(true, userId, label);
        unreadEmailStatsRepository.decrementUnreadCount(userId, label);
    }

}
