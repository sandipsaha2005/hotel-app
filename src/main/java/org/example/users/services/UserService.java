package org.example.users.services;

import org.example.users.dto.LoginResponse;
import org.example.users.dto.RegisterResponse;
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

    public RegisterResponse register(UserDto userDto) {
        User currentUser = userRepo.findByName(userDto.username());
        System.out.println(currentUser);
        if (currentUser == null) {
            User user = new User();
            user.setName(userDto.username());
            user.setPassword(userDto.password());

            return new RegisterResponse(userRepo.save(user), "Register successful");
        }

        return new RegisterResponse(null, "username already exist");
    }

    public LoginResponse login(UserDto userDto) {
        User currentUser = userRepo.findByName(userDto.username());
        if (currentUser == null) {
            return new LoginResponse("invalid username");
        }
        if (currentUser.getPassword().equals(userDto.password()) && currentUser.getName().equals(userDto.username())) {
            return new LoginResponse("Login successful");
        }
        return new LoginResponse("invalid crenditials");
    }
}
