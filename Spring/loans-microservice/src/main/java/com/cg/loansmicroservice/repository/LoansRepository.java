package com.cg.loansmicroservice.repository;

import com.cg.loansmicroservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}
