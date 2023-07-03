package com.example.voyage;

import ch.qos.logback.core.CoreConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class VoyageApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(VoyageApplication.class, args);
		System.out.println("hebergement");
		System.out.println("Marrakech");
		System.out.println("Marrakech");
		Document HdocE1= Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Marrakech&ssne=Marrakech&ssne_untouched=Marrakech&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-38833&dest_type=city&checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0").get();
		Elements Hbody = HdocE1.select("div.d4924c9e74");
		for(Element e : Hbody.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")){
			String img = e.select("div.f9d4f2568d img").attr("src");
			System.out.println(img);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
		}

      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("CASABLANCA");
		System.out.println("CASABLANCA");
		Document HdocE2= Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0").get();
		Elements Hbody2 = HdocE2.select("div.d4924c9e74");
		for(Element e : Hbody2.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")){
			String img = e.select("div.f9d4f2568d img").attr("src");
			System.out.println(img);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("AGADIR");
		System.out.println("AGADIR");
		Document HdocE3= Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Agadir&ssne=Agadir&ssne_untouched=Agadir&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-20029&dest_type=city&checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0").get();
		Elements Hbody3 = HdocE3.select("div.d4924c9e74");
		for(Element e : Hbody3.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")){
			String img = e.select("div.f9d4f2568d img").attr("src");
			System.out.println(img);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
		}
		System.out.println("TANGER");
		System.out.println("TANGER");
		Document HdocE4= Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Tanger&ssne=Tanger&ssne_untouched=Tanger&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-51554&dest_type=city&checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0").get();
				Elements Hbody4 = HdocE4.select("div.d4924c9e74");
		for(Element e : Hbody4.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")){
			String img = e.select("div.f9d4f2568d img").attr("src");
			System.out.println(img);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
		}
		System.out.println("Essaouira");
		System.out.println("Essaouira");
		Document HdocE5= Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Essaouira&ssne=Essaouira&ssne_untouched=Essaouira&label=gog235jc-1DCAEoggI46AdIDVgDaIwBiAEBmAENuAEXyAEV2AED6AEB-AECiAIBqAIDuAL0qoylBsACAdICJGI2MjgyYjY1LTlmOWQtNDAxMS05YjY2LWFjNzU0ZGVkNTczONgCBOACAQ&aid=397594&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-32532&dest_type=city&checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0").get();
				Elements Hbody5 = HdocE5.select("div.d4924c9e74");
		for(Element e : Hbody5.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")){
			String img = e.select("div.f9d4f2568d img").attr("src");
			System.out.println(img);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
		}
		System.out.println("vol");
		Document Vdoc= Jsoup.connect("https://booking.kayak.com/flights/CMN-PAR/2023-08-02/2023-09-05?sort=price_a").get();
				Elements Vbody = Vdoc.select("div#efACLWBhFY-1");
		for(Element e : Vbody.select("div.Base-Results-HorizonResult Flights-Results-FlightResultItem")){
			String img = e.select("div.f9d4f2568d img").attr("src");
			System.out.println(img);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
		}



	}

}

