package com.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FraudCheckHistory {

    @Id
//    @SequenceGenerator(
//            name = "fraud_id_sequence",
//            sequenceName = "fraud_id_sequence"
//    )
    private UUID id;
    private UUID userId;
    private Boolean isFraudster;
    private Instant timeStamp;
}
