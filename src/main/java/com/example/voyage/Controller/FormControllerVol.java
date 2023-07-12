package com.example.voyage.Controller;
import com.example.voyage.entities.Vol;

import jakarta.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FormControllerVol {

	@PostMapping("/rechercher_vol")
	public ModelAndView rechercher(@RequestParam("villeR") String villeR,
	        @RequestParam("villeA") String villeA,
	        @RequestParam("dateA") String dateAStr,
	        @RequestParam("dateR") String dateRStr,
	        HttpSession session) {
	    try {
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        LocalDate dateA = LocalDate.parse(dateAStr, inputFormatter);
	        LocalDate dateR = LocalDate.parse(dateRStr, inputFormatter);

	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDateA = dateA.format(outputFormatter);
	        String formattedDateR = dateR.format(outputFormatter);

	        String encodedDateA = URLEncoder.encode(formattedDateA, "UTF-8");
	        String encodedDateR = URLEncoder.encode(formattedDateR, "UTF-8");

	        String url = "https://booking.kayak.com/flights/" + villeR + "-" + villeA + "/" + encodedDateA + "/" + encodedDateR + "?sort=price_a";
	        Document HdocE2 = Jsoup.connect(url).get();
	        Elements flights = HdocE2.select("div.resultInner");

	        // Créer une liste de résultats du scraping
	        List<ResultatScrapingVol> results = new ArrayList<>();
	        for (Element flight : flights) {
	            Elements part11 = flight.select("li.flight.with-gutter");
	            Elements part12 = flight.select("li.flight");

	            String avionA = part11.select("div.col-field.carrier").text();
	            String Aheured = part11.select("div.col-field.time.depart span.depart-time.base-time").text();
	            String Aheurea = part11.select("div.col-field.time.return span.arrival-time.base-time").text();
	            String typeA = part11.select("div.col-field.stops").text();
	            String durationA = part11.select("div.col-field.duration").text();

	            String avionR = part12.select("div.col-field.carrier").text();
	            String Rheured = part12.select("div.col-field.time.depart span.depart-time.base-time").text();
	            String Rheurea = part12.select("div.col-field.time.return span.arrival-time.base-time").text();
	            String typeR = part12.select("div.col-field.stops").text();
	            String durationR = part12.select("div.col-field.duration").text();

	            String prixV = flight.select("div.col-price.result-column.js-no-dtog span.price-text").text();

	            results.add(new ResultatScrapingVol(dateA, dateR, typeA, typeR, Aheured, Aheurea, Rheured, Rheurea, avionA, avionR, villeA, villeR, prixV, durationR, durationA));
	        }

	       
            session.setAttribute("results", results);

            // Redirect to the /hebergements_resultats endpoint
            return new ModelAndView("redirect:/vols_resultats");
	    } catch (Exception e) {
	        // Gérer les erreurs de scraping
	        e.printStackTrace();
	        return new ModelAndView("erreur");
	    }
	}


	@GetMapping("/vols_resultats")
	public String vols(ModelMap model, HttpSession session) {
	    // Récupérer les résultats de la session
	    List<ResultatScrapingVol> results = (List<ResultatScrapingVol>) session.getAttribute("results");

	    // Ajouter les résultats au modèle
	    model.addAttribute("results", results);

	    // Retourner la vue
	    return "client/vols";
	}

}
