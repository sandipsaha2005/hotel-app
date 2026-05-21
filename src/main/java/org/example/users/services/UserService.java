package org.example.users.services;

import org.example.users.dto.UserDto;
import org.example.users.entity.User;
import org.example.users.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User add(UserDto userDto) {
        User user = new User();
        user.setName(userDto.username());
        user.setPassword(userDto.password());
       return userRepo.save(user);
    }
}
