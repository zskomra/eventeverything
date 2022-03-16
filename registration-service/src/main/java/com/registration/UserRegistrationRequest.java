package com.registration;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
