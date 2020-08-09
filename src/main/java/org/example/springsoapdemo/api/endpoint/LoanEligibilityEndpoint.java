package org.example.springsoapdemo.api.endpoint;

import org.example.springsoapdemo.api.loaneligibility.CustomerRequest;
import org.example.springsoapdemo.api.loaneligibility.CustomerResponse;
import org.example.springsoapdemo.api.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityEndpoint {

    private static final String NAMESPACE = "http://www.example.org/SpringSoapDemo/api/LoanEligibility";

    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public CustomerResponse checkLoanEligibility(@RequestPayload CustomerRequest request) {
        return service.checkLoanEligibility(request);
    }
}
