package com.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, UUID> {
}
