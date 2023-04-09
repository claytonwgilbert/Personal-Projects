package com.cg.loansmicroservice.controller;

import com.cg.loansmicroservice.config.LoanServiceConfig;
import com.cg.loansmicroservice.model.Customer;
import com.cg.loansmicroservice.model.Loan;
import com.cg.loansmicroservice.model.Properties;
import com.cg.loansmicroservice.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    private LoansRepository loansRepository;
    private LoanServiceConfig loanServiceConfig;

    public LoansController(LoansRepository loansRepository, LoanServiceConfig loanServiceConfig) {
        this.loansRepository = loansRepository;
        this.loanServiceConfig = loanServiceConfig;
    }

    @PostMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody Customer customer) {
        List<Loan> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }

    //Retrieving config properties from config server
    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loanServiceConfig.getMsg(), loanServiceConfig.getBuildVersion(),
                loanServiceConfig.getMailDetails(), loanServiceConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
