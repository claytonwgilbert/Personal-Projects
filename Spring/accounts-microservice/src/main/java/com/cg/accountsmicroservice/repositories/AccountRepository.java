package com.cg.accountsmicroservice.repositories;

import com.cg.accountsmicroservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByCustomerId(int id);
}
