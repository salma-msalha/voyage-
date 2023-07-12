package com.example.voyage.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	    
	   
	    @GetMapping("/ajouter-client")
	    public String adduser() {
	        return "admin/ajouter-client"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    
	    
	   
	   
	    @GetMapping("reservations")
	    public String reservations() {
	        return "admin/reservations"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    @GetMapping("reservation-details")
	    public String reservationsdetails() {
	        return "admin/reservation-details"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    
	    @GetMapping("reservation-vols")
	    public String reservation_vols() {
	        return "admin/reservation-vols"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    
	    @GetMapping("reservations-vol-details")
	    public String reservation1_vols_details() {
	        return "admin/reservations-vol-details"; // Le nom de la vue (template) à afficher, sans l'extension
	    }
	    
	

}
