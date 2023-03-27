package com.cg.eazyschool.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

//We let Spring know about this class in the main application file in order to get the info needed for the @LastModifiedBy and @CreatedBy annotations
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    //Gets the name of the current logged in user
    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
