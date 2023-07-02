package com.example.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class ClientController {

	 @GetMapping("/index")
	    public String index() {
	        return "client/index"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/contact")
	    public String contact() {
	        return "client/contact"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/about")
	    public String about() {
	        return "client/about"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/booking")
	    public String booking() {
	        return "client/booking"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/hébergements")
	    public String hébergements() {
	        return "client/hébergements"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/services")
	    public String services() {
	        return "client/services"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/vols")
	    public String vols() {
	        return "client/vols"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	 @GetMapping("/login")
	    public String login() {
	        return "client/login"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	
	 @GetMapping("/réservations")
	    public String réservations() {
	        return "client/réservations"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	
	
}
