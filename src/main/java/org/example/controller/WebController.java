package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.entity.Movie;
import org.example.service.MovieService;
import org.example.service.UserService;
import org.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class WebController {
private final UserService userService;
private final MovieService movieService;
//@GetMapping("/persons")
//    public String persons(Model page){
//
//    page.addAttribute("color","red");
//    page.addAttribute("persons",userService.getAllUser());
//    return "user.html";
//}

@GetMapping("/movies")
    public String movies(Model modal){
    List<Movie> movies=movieService.getAllMovies();
    List<User> users=userService.getAllUser();
    movies.add(new Movie(1,"Marvel"));
    users.add(new User(1,"Nurbakyt","qwerty1234"));
    modal.addAttribute("movies",movies);
    modal.addAttribute("color","red");
    modal.addAttribute("users",users);
    return "user.html";
}
}
