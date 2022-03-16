package com.registration;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record UserService(UserRepository userRepository) {

    public void registerUser(UserRegistrationRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .id(UUID.randomUUID())
                .build();
        //todo check if email valid
        //todo check if email not taken
        userRepository.save(user);
    }
}
