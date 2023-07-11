package com.example.voyage.Controller;

import com.example.voyage.entities.Client;
import com.example.voyage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/client/")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String email = p.getName();
        Client user = userRepo.findByEmail(email);

        m.addAttribute("user", user);

    }
    @GetMapping("/réservations")
    public String réservations() {
        return "client/réservations";  
    }
}
