package com.cg.inboxapp.emailslist;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface EmailsListRepository extends CassandraRepository<EmailsList, EmailsListPrimaryKey> {
    //The _ indicates we need to look another level deep before accessing the property we are looking for
    //We look inside the id of the EmailsList, which is of type EmailsListPrimaryKey and then find the userId and label
    //inside that object
    List<EmailsList> findAllById_UserIdAndId_Label(String id, String label);

    @Query("update emails_list set isread = ?0 where created_time_uuid = ?1 and label = ?2")
    void updateEmailListItemReadStatus(boolean status, String id, String label);
}
