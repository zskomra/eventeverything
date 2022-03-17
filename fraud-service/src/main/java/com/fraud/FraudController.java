package com.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{userId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("userId")UUID userId){
        boolean fraudulentUser = fraudCheckService.isFraudulentUser(userId);
        return new FraudCheckResponse(fraudulentUser);
    }
}
