package com.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    boolean isFraudulentUser(UUID userId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .userId(userId)
                        .isFraudster(false)
                        .timeStamp(Instant.now())
                        .id(UUID.randomUUID())
                        .build()
        );
        return false;
    }
}
