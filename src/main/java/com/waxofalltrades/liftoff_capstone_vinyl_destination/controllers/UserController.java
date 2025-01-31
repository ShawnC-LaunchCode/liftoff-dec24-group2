package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.UserDto;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.User;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.UserRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;


@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, RedirectAttributes redirectAttributes) {
        userService.save(userDto);
        redirectAttributes.addFlashAttribute("message", "Registered successfully");

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login (){
        return "login";
    }

    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return  "/";
    }

    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return  "admin";
    }


    @GetMapping("/")
    public String home(Model model, Principal principal) {
        if (principal != null) {
            User user = userRepository.findByEmail(principal.getName());

            if (user != null) {
                model.addAttribute("user", user);
            }
        }
        return "index";
    }

}
