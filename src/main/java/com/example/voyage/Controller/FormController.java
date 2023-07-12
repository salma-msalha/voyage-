package com.example.voyage.Controller;

import org.springframework.ui.ModelMap;
import com.example.voyage.entities.Hotel;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FormController {
    @PostMapping("/rechercher")
    public ModelAndView rechercher(@RequestParam String ville, 
            @RequestParam Date checkin, 
            @RequestParam Date checkout, 
            @RequestParam int g_ad, 
            @RequestParam int n_r, 
            @RequestParam int g_ch,
            HttpSession session) {

    	String des_id;
        try {
            
		switch (ville) {
			case "Marrakech": des_id = "-38833"; break;
			case "Casablanca":  des_id = "-28159";  break;
			case "Tanger": des_id = "-51554"; break;
			case "Agadir": des_id = "-20029"; break;
			case "Essaouira": des_id = "-32532"; break;
			case "Rabat": des_id = "-43376"; break;
		    case "Ifran": des_id = "-34892"; break;
		    case "Fès": des_id = "-32910"; break;
			case "Paris": des_id = "-1456928"; break;
			case "Dubaï": des_id = "-782831"; break;
		    case "Singapour": des_id = "-73635"; break;
		    case "New York": des_id = "20088325"; break;
		    case "Istanbul": des_id = "-755070"; break;
		    case "Londres": des_id = "-2601889"; break;
		    case "Tokyo": des_id = "-246227"; break;
		    case "Barcelone": des_id = "-372490"; break;
		    case "Berlin": des_id = "-1746443"; break;
		    
			default:
				des_id=" "; break;
	}
            Document HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=" + ville + "&ssne=" + ville + "&ssne_untouched=" + ville + "&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id="+des_id+"&dest_type=city&checkin=" + checkin + "&checkout=" + checkout + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
            Elements Hbody = HdocE1.select("div.d4924c9e74");
			// Créer une liste de résultats du scraping
			List<ResultatScraping> results = new ArrayList<>();
			for (Element e : Hbody.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")) {
			String img = e.select("div.f9d4f2568d img").attr("src");
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			String desc = e.select("div.d8eab2cf7f").text();
			String prix = "";
			Element priceElement = e.selectFirst("span.fcab3ed991.fbd1d3018c.e729ed5ab6");
			if (priceElement != null) {
			    prix = priceElement.text();
			}

			results.add(new ResultatScraping(img, desc, titre, prix, checkin, checkout, g_ad, g_ch, n_r));
			}

           
            
            // Set the results attribute in the session
            session.setAttribute("results", results);

            // Redirect to the /hebergements_resultats endpoint
            return new ModelAndView("redirect:/hebergements_resultats");
        } catch (Exception e) {
            // Gérer les erreurs de scraping
            e.printStackTrace();
            return new ModelAndView("erreur");
        }
    }

    @GetMapping("/hebergements_resultats")
    public String hébergements(ModelMap model, HttpSession session) {
        // Récupérer les résultats de la session
        List<ResultatScraping> results = (List<ResultatScraping>) session.getAttribute("results");
        
        // Ajouter les résultats au modèle
        model.addAttribute("results", results);

        // Retourner la vue
        return "client/hébergements";
    }
}