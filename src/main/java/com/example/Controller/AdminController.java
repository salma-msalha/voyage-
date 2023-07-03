package com.example.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	    
	   
	    @GetMapping("/ajouter-client")
	    public String adduser() {
	        return "admin/ajouter-client"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    @GetMapping("/modifier-client")
	    public String modifierclient() {
	        return "admin/modifier-client"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    
	   
	    @GetMapping("/clients")
	    public String clients() {
	        return "admin/clients";
	    }

	    @GetMapping("reservations")
	    public String reservations() {
	        return "admin/reservations"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    @GetMapping("reservation-details")
	    public String reservationsdetails() {
	        return "admin/reservation-details"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	

}
