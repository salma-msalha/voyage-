package com.example.voyage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpSession;
import com.example.voyage.entities.Client;
import com.example.voyage.services.UserService;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	 public String createuser(@ModelAttribute Client user, HttpSession session , ModelMap model) {

		 user.setRole("user");
         boolean f=userService.checkEmail(user.getEmail());

         if (f) {
        	 session.setAttribute("msg", "L'adresse e-mail existe déjà");
        	 session.setAttribute("color", "red");
        	 return "redirect:/register";
        	}
else {


        	Client userDtls =userService.createUser(user);

        if(userDtls!=null){
            session.setAttribute("msg","Compte créé avec succès ! ! ");
            session.setAttribute("color","#3ae067");
            return "redirect:/login";
        }else {
            session.setAttribute("msg","Something error in server");
            return "redirect:/register";
            }
        
        }
       
    }
	 
	 @Transactional
	 @PostMapping("/addClient")
	 public String addclient_admin(@ModelAttribute Client client, HttpSession session) {
	     System.out.println("hi");
	     client.setRole("user");
	     client.setMdp("12345678");
	     userService.createUser(client);
	     session.setAttribute("message", "Client ajouté avec succès!");
	     return "redirect:/Clients";
	 }

	
	 @GetMapping("/Clients")
		public String readClients(ModelMap model, HttpSession session) {
		    List<Client> clients = userService.getClients();
		    model.addAttribute("clients", clients);

		    String message = (String) session.getAttribute("message");
		    if (message != null) {
		        model.addAttribute("message", message);
		        session.removeAttribute("message");
		    }

		    return "admin/clients";
		}




	 @GetMapping("/clients/{nom}")
	 public Client findClientByName(@PathVariable String nom) {
	        return userService.getClientByName(nom);
	    }
	 
	 @PostMapping("/updateClient/{id}")
	 public String updateClient(@PathVariable("id") long clientId, @ModelAttribute("client") @Validated Client updatedClient, BindingResult bindingResult, HttpSession session) {
	     if (bindingResult.hasErrors()) {
	         // Gérer les erreurs de validation
	     }
	     
	     Client existingClient = userService.getClientById(clientId);
	     if (existingClient != null) {
	         existingClient.setNom(updatedClient.getNom());
	         existingClient.setPrenom(updatedClient.getPrenom());
	         existingClient.setEmail(updatedClient.getEmail());
	         existingClient.setN_Cin(updatedClient.getN_Cin());
	         existingClient.setTele(updatedClient.getTele());

	         userService.updateClient(existingClient);
	         session.setAttribute("message", "Client modifié avec succès!");
	     }

	     return "redirect:/Clients";
	 }


	 @GetMapping("/modifierClient/{id}")
	 public String showUpdateForm(@PathVariable("id") long clientId, Model model) {
	     Client client = userService.getClientById(clientId);
	     model.addAttribute("client", client);
	     return "admin/modifier-client";
	 }


	 
	 @Transactional
		@GetMapping("/delete/{id}")
		public String deleteClient(@PathVariable Long id, HttpSession session) {
		    userService.deleteClient(id);
		    session.setAttribute("message", "Client supprimé avec succès!");
		    return "redirect:/Clients";
		}



	 @PostMapping("/login")
	 public String login(@RequestParam("email") String email,
	                     @RequestParam("password") String password , HttpSession session) {
	     // Votre logique de traitement de la connexion ici
	     // Par exemple, vérifier les informations d'identification, créer une session utilisateur, etc.
	     Client utilisateur = userService.getByEmail(email);
	     if (utilisateur != null && utilisateur.getMdp().equals(password)) {
	         String role = utilisateur.getRole();
	         
	         session.setAttribute("loggedIn", true);
	         
	         if (role.equals("admin")) {
	        	 return "redirect:/Clients"; // Rediriger vers le tableau de bord de l'administrateur
	         } else if (role.equals("user")) {
	        	 return "client/réservations";   // Rediriger vers le tableau de bord de l'utilisateur
	         }
	     }
	     return "redirect:/user/login?error"; // Rediriger vers la page de connexion avec un message d'erreur
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
	     // Invalidate the session
	     session.invalidate();

	     // Redirect to the login page or any other page you prefer
	     return "redirect:/login";
	 }


	 
	

	
	 
}


