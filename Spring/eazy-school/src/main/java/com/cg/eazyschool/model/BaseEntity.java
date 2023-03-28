package com.cg.eazyschool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //AuditingEntityListener.class comes with Spring Data and works with annotations like @LastModifiedBy @LastModifiedDate @CreatedBy and @CreatedDate
public class BaseEntity {
    @JsonIgnore //Allows us to skip sending these properties back during a rest response
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @JsonIgnore
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    @JsonIgnore
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    @JsonIgnore
    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}

//@CreatedDate and @LastModifiedBy will be known by looking at the time in the db server, @LastModifiedBy will be found by
//our auditAwareImpl class we implemented
