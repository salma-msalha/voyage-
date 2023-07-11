package com.example.voyage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.voyage.entities.Client;
import com.example.voyage.services.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller

public class ClientController {

	 @Autowired
	 private UserService userService;
	   
	 
	 
	 @GetMapping("/index")
	    public String index() {
	        return "client/index";  
	    }
	 @GetMapping("/contact")
	    public String contact() {
	        return "client/contact";  
	    }
	 @GetMapping("/about")
	    public String about() {
	        return "client/about";  
	    }
	 @GetMapping("/booking")
	    public String booking() {
	        return "client/booking";  
	    }
	 @GetMapping("/hébergements")
	    public String hébergements() {
	        return "client/hébergements";  
	    }
	 @GetMapping("/services")
	    public String services() {
	        return "client/services";  
	    }
	 @GetMapping("/vols")
	    public String vols() {
	        return "client/vols";  
	    }
	 @GetMapping("/login")
	    public String login() {
	        return "client/login";  
	    }
	
	 @GetMapping("/réservations")
	    public String réservations() {
	        return "client/réservations";  
	    }
	 
	 @GetMapping("/register")
	    public String register(){
	        return "client/register";
	    }
	 
	 
	 @PostMapping("/createUser")
	 public String createuser(@ModelAttribute Client user, HttpSession session) {

         boolean f=userService.checkEmail(user.getEmail());

        if (f) {
           session.setAttribute("msg","Email Id already exist");
           session.setAttribute("color","red");
        }else {


        	Client userDtls =userService.createUser(user);

        if(userDtls!=null){
            session.setAttribute("msg","Compte créer avec succés ! ");
            session.setAttribute("color","green");
        }else {
            session.setAttribute("msg","Something error in server");
            }}
        return "redirect:/register";
    }
	 
	 @PostMapping("/addClient")
	public Client addclient_admin (@RequestBody Client client) {
		return userService.createUser(client) ;
	}
	 
	
	
	 @GetMapping("/Clients")
	 public String readClients(ModelMap model) {
	     List<Client> clients = userService.getClients();
	     model.addAttribute("clients", clients);
	     return "admin/clients";
	 }



	 @GetMapping("/clients/{nom}")
	 public Client findClientByName(@PathVariable String nom) {
	        return userService.getClientByName(nom);
	    }
	 
	 @PutMapping("/updateClient/{id}")
		public Client updateclient_admin (@RequestBody Client client) {
			return userService.updateClient(client) ;
		}
	 
	 @DeleteMapping("/clients/{id}")
	 public String deleteclient (@PathVariable int id) {
		 return userService.deleteClient(id) ;
	 }
	 
}


