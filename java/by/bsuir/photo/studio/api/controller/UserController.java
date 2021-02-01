package by.bsuir.photo.studio.api.controller;

import by.bsuir.photo.studio.api.entity.User;
import by.bsuir.photo.studio.api.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public User login(User user) {
//        return userService.
//    }
}