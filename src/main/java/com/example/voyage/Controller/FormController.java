package com.example.voyage.Controller;

import org.springframework.ui.ModelMap;
import com.example.voyage.entities.Hotel;
import org.springframework.stereotype.Controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FormController {
    @PostMapping("/rechercher")
    public ModelAndView rechercher(@RequestBody Hotel entite, ModelMap model) {
        // Récupération des données saisies par le client
        String ville = entite.getVille();
        Date checkin = entite.getCheckin();
        Date checkout = entite.getCheckout();
        int g_ad = entite.getG_ad();
        int n_r = entite.getN_r();
        int g_ch = entite.getG_ch();

        try {
            Document HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=" + ville + "&ssne=" + ville + "&ssne_untouched=" + ville + "&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-38833&dest_type=city&checkin=" + checkin + "&checkout=" + checkout + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
            Elements Hbody = HdocE1.select("div.d4924c9e74");

            // Créer une liste de résultats du scraping
            List<ResultatScraping> results = new ArrayList<>();
            for (Element e : Hbody.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")) {
                String img = e.select("div.f9d4f2568d img").attr("src");
                String titre = e.select("div.f9d4f2568d img").attr("alt");
                String desc = e.select("div.d8eab2cf7f").text();
                results.add(new ResultatScraping(img, desc,titre,checkin,checkout,g_ad,g_ch,n_r));
            }

            ModelAndView modelAndView = new ModelAndView("redirect:/hébergements_résultats");
            modelAndView.addObject("results", results);

            return modelAndView;
        } catch (Exception e) {
            // Gérer les erreurs de scraping
            e.printStackTrace();
            return new ModelAndView("erreur");
        }
    }

    @GetMapping("/hébergements_résultats")
    public String hébergements(ModelMap model) {
        // Rien à faire ici, les résultats du scraping sont déjà ajoutés au modèle dans la méthode rechercher
        return "client/hébergements";
    }

}
