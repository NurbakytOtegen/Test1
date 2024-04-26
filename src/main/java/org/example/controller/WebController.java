package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.entity.Movie;
import org.example.service.MovieService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller
//@RequestMapping("/ui")
//@RequiredArgsConstructor
//public class WebController {
//private final UserService userService;
//private final MovieService movieService;


///////////////

//@GetMapping("/persons")
//    public String persons(Model page){
//
//    page.addAttribute("color","red");
//    page.addAttribute("persons",userService.getAllUser());
//    return "user.html";
//}

//@GetMapping("/movies")
//    public String movies(Model modal){
//    List<Movie> movies=movieService.getAllMovies();
//    List<User> users=userService.getAllUser();
//    movies.add(new Movie(1,"SpiderMan"));
//    users.add(new User(1,"Nurbakyt","qwerty1234"));
//    modal.addAttribute("movies",movies);
//    modal.addAttribute("color","red");
//    modal.addAttribute("users",users);
//    return "user.html";
//}



//////////////
//    @GetMapping("/movies")
//    public String viewMovies(Model model){
//        var movies=movieService.getAllMovies();
//        model.addAttribute("movies",movies);
//        return "user.html";
//    }
//@PostMapping("/movies")
//public String addMovie(
//@RequestParam String title,@RequestParam String description,
//Model model){
//Movie m=new Movie();
//m.setTitle(title);
//m.setDescription(description);
//movieService.addMovie(m);
//var movies=movieService.getAllMovies();
//model.addAttribute("movies",movies);
//return "user.html";
//    }
//
//@GetMapping("/login")
//    public String login(){
//    return "login.html";
//}
//}
