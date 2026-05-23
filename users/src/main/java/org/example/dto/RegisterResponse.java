package org.example.dto;

import org.example.entity.User;

public record RegisterResponse(User save, String registerSuccessful) {
}
