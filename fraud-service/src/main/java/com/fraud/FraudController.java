package com.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @PostMapping(path = "{userId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("userId")UUID userId){
        boolean fraudulentUser = fraudCheckService.isFraudulentUser(userId);
        return new FraudCheckResponse(fraudulentUser);
    }
}
