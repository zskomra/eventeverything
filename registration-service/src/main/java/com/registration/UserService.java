package com.registration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public record UserService(UserRepository userRepository,
                          RestTemplate restTemplate) {

    public void registerUser(UserRegistrationRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .id(UUID.randomUUID())
                .build();
        userRepository.saveAndFlush(user);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-check/{userId}",
                FraudCheckResponse.class,
                user.getId()
        );
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //todo check if email valid
        //todo check if email not taken

    }
}
