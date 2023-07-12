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
    	
        
        try {
            Document HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=" + ville + "&ssne=" + ville + "&ssne_untouched=" + ville + "&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-38833&dest_type=city&checkin=" + checkin + "&checkout=" + checkout + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
            Elements Hbody = HdocE1.select("div.d4924c9e74");

            // Créer une liste de résultats du scraping
            List<ResultatScraping> results = new ArrayList<>();
            for (Element e : Hbody.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")) {
                String img = e.select("div.f9d4f2568d img").attr("src");
                String titre = e.select("div.f9d4f2568d img").attr("alt");
                String desc = e.select("div.d8eab2cf7f").text();
                Element priceElement = e.selectFirst("span.fcab3ed991.fbd1d3018c.e729ed5ab6");
                String prix = priceElement.text();


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
