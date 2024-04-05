package org.example.controller;

import org.example.entity.Movie;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.MovieService;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final UserService userService;
    private final MovieService movieService;

    public HomeController(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @GetMapping
    public String getHome(){
        return "Hello Welcome Here!";
    }
//    @GetMapping("/{user}")
//    public String HiUser(@PathVariable String user){
//        return "Hello "+user;
//    }
//    @PostMapping("/user")
//    public String addUser(@RequestBody User user){
//        return userService.addUser(user);
//    }
//    @GetMapping("/users")
//    public List<User> getAllUsers(){
//        return userService.getAllUser();
//    }

//    @PostMapping("/movie")
//    public String addMovie(@RequestBody Movie movie){
//        return movieService.addMovie(movie);
//    }
//    @GetMapping("/movies")
//    private List<Movie> getAllMovies(){
//        return movieService.getAllMovies();
//    }
}
