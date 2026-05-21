package org.example.users.dto;

import org.example.users.entity.User;

public record RegisterResponse(User save, String registerSuccessful) {
}
