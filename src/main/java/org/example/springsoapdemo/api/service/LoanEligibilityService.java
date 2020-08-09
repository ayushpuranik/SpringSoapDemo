package org.example.springsoapdemo.api.service;

import org.example.springsoapdemo.api.loaneligibility.CustomerRequest;
import org.example.springsoapdemo.api.loaneligibility.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityService {
    public CustomerResponse checkLoanEligibility(CustomerRequest customerRequest) {
        CustomerResponse response = new CustomerResponse();
        if (customerRequest.getAge() < 20 || customerRequest.getAge() > 60) {
            response.getCriteriaMismatch().add("Age is not between required limit");
        }
        if (customerRequest.getIncome() < 500000) {
            response.getCriteriaMismatch().add("Income is less than required criteria");
        }

        if (response.getCriteriaMismatch().isEmpty()) {
            response.setIsEligible(true);
            response.setApprovedAmount(1000000);
        } else {
            response.setIsEligible(false);
            response.setApprovedAmount(0);

        }

        return response;
    }
}
