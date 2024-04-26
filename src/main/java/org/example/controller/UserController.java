package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Movie;
import org.example.service.MovieService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
