package com.example.voyage;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.voyage.entities.Client;
import com.example.voyage.entities.Compte;
import com.example.voyage.entities.Hotel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.voyage.Controller" , "com.example.voyage.repository" , "com.example.voyage.services"})
public class VoyageApplication {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(VoyageApplication.class, args);
		System.out.println("hello");
		Scanner scan = new Scanner(System.in);
		//checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0
		String ville;
		Date checkin;
		Date checkout;
		int g_ad;
		int g_ch;
		int n_r;
		String Aheured;
		String Aheurea;
		String Rheured;
		String Rheurea;
		/*LocalTime Aheured;
		LocalTime Aheurea;
		LocalTime Rheured;
		LocalTime Rheurea;*/
		String typeA;
		String typeR;
		String avionA;
		String avionR;
		String villeD;
		String villeA;
		Date dateD;
		Date dateA;
		String prixV;
		String durationA;
		String durationR;
		System.out.println("Veuillez entrez les données : ");
		System.out.print("ville (la première lettre en majuscule et les autres en miniscule) : ");
		ville = scan.nextLine();
		System.out.print("checkin (YYYY-MM-DD) : ");
		String checkin1 = scan.nextLine();
		System.out.print("checkout (YYYY-MM-DD) : ");
		String checkout1 = scan.nextLine();
		System.out.print("group_adults : ");
		g_ad = scan.nextInt();
		System.out.print("no_rooms : ");
		n_r = scan.nextInt();
		//System.out.print("Veuillez entrez ville d'arrivée : ");
		//villeA=scan.next();
		System.out.print("group_children : ");
		g_ch = scan.nextInt();
		//System.out.print("Veuillez entrez ville de départ : ");
		//villeD=scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		//System.out.print("Veuillez entrez date de départ : ");
		//String dateD1=scan.next();
		//dateD=dateFormat.parse(dateD1);
		//System.out.print("Veuillez entrez date d'arrivée : ");
		//String dateA1=scan.next();
		//dateA=dateFormat.parse(dateA1);
		checkin = dateFormat.parse(checkin1);
		checkout = dateFormat.parse(checkout1);
		Document HdocE1;
		switch (ville) {
			case "Marrakech"://https://www.booking.com/searchresults.fr.html?ss=Marrakech&ssne=Marrakech&ssne_untouched=Marrakech&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-38833&dest_type=city&checkin" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Marrakech&ssne=Marrakech&ssne_untouched=Marrakech&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-38833&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;                    //https://www.booking.com/searchresults.fr.html?ss=Marrakech&ssne=Marrakech&ssne_untouched=Marrakech&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-38833&dest_type=city&checkin=2023-08-09&checkout=2023-09-05&group_adults=2&no_rooms=2&group_children=0
			case "Casablanca":            //https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=" + checkin.toString() + "&checkout=2023-08-11&group_adults=2&no_rooms=1&group_children=0
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;//https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
			case "Tanger"://https://www.booking.com/searchresults.fr.html?ss=Tanger&ssne=Tanger&ssne_untouched=Tanger&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-51554&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Tanger&ssne=Tanger&ssne_untouched=Tanger&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-51554&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;//https://www.booking.com/searchresults.fr.html?ss=Tanger&ssne=Tanger&ssne_untouched=Tanger&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-51554&dest_type=city&checkin=2023-08-09&checkout=2023-09-05&group_adults=2&no_rooms=2&group_children=0
			case "Agadir"://https://www.booking.com/searchresults.fr.html?ss=Agadir&ssne=Agadir&ssne_untouched=Agadir&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-20029&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Tanger&ssne=Tanger&ssne_untouched=Tanger&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-51554&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;//https://www.booking.com/searchresults.fr.html?ss=Tanger&ssne=Tanger&ssne_untouched=Tanger&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-51554&dest_type=city&checkin=2023-08-09&checkout=2023-09-05&group_adults=2&no_rooms=2&group_children=0
			case "Essaouira"://https://www.booking.com/searchresults.fr.html?ss=Essaouira&ssne=Essaouira&ssne_untouched=Essaouira&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-32532&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Essaouira&ssne=Essaouira&ssne_untouched=Essaouira&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-32532&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;//https://www.booking.com/searchresults.fr.html?ss=Essaouira&ssne=Essaouira&ssne_untouched=Essaouira&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-32532&dest_type=city&checkin=2023-08-09&checkout=2023-09-05&group_adults=2&no_rooms=2&group_children=0
			case "Rabat"://https://www.booking.com/searchresults.fr.html?ss=Rabat&ssne=Rabat&ssne_untouched=Rabat&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-43376&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Rabat&ssne=Rabat&ssne_untouched=Rabat&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-43376&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;//https://www.booking.com/searchresults.fr.html?ss=Rabat&ssne=Rabat&ssne_untouched=Rabat&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-43376&dest_type=city&checkin=2023-08-09&checkout=2023-09-05&group_adults=2&no_rooms=2&group_children=0
			case "Ifran"://https://www.booking.com/searchresults.fr.html?ss=Ifrane&ssne=Ifrane&ssne_untouched=Ifrane&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-34892&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Ifrane&ssne=Ifrane&ssne_untouched=Ifrane&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-34892&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;//https://www.booking.com/searchresults.fr.html?ss=Ifrane&ssne=Ifrane&ssne_untouched=Ifrane&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-34892&dest_type=city&checkin=2023-08-09&checkout=2023-09-05&group_adults=2&no_rooms=2&group_children=0
			case "Fès"://https://www.booking.com/searchresults.fr.html?ss=Fès&ssne=Fès&ssne_untouched=Fès&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-32910&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Fès&ssne=Fès&ssne_untouched=Fès&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-32910&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
						break;//
			default:
				System.out.println("ville non trouvée");
				HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();
				break;                   // https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=2023-08-10&checkout=2023-08-11&group_adults=2&no_rooms=1&group_children=0
				// https://www.booking.com/searchresults.fr.html?ss=Casablaca&ssne=France&ssne_untouched=France&label=gen173rf-1BCAEoggI46AdIM1gDaIwBiAEBmAENuAEXyAEV2AEB6AEBiAIBmAIiqAIDuALQxLGlBsACAdICJGU5ZjIwNjI4LWMxNWEtNGQ5Yi05MmZhLWFiMjg2MjNiMTJiNdgCBeACAQ&sid=306db4aa850bb4d03ba16de56aa2fe8b&aid=304142&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&ac_position=0&ac_click_type=b&ac_langcode=fr&ac_suggestion_list_length=5&search_selected=true&search_pageview_id=0ffb8c34b17a005a&ac_meta=GhAwZmZiOGMzNGIxN2EwMDVhIAAoATICZnI6CUNhc2FibGFjYUABSgpjYXNhYmxhbmNhUNiOAQ%3D%3D&checkin=2023-08-10&checkout=2023-08-11&group_adults=2&no_rooms=1&group_children=0;
				// https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=2023-09-10&checkout=2023-09-16&group_adults=2&no_rooms=1&group_children=0
		}


		Elements Hbody = HdocE1.select("div.d4924c9e74");
		Elements prixTD = Hbody.select("div.b978843432 div.a1b3f50dcd.be36d14cea.f7c6687c3d.f996d8c258");
		System.out.println(prixTD);
		/*for (Element e : Hbody.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")) {
			String img = e.select("div.f9d4f2568d img").attr("src");//f9d4f2568d c90a25d457 ib9a
			System.out.println(img);
			//Elements prixTD = e.select("div.b978843432 div.a1b3f50dcd.be36d14cea.f7c6687c3d.f996d8c258");
			String prix = prixTD.select("div.e6e585da68").text();//span.fcab3ed991.fbd1d3018c.e729ed5ab6
			System.out.println(prix);
			String titre = e.select("div.f9d4f2568d img").attr("alt");
			System.out.println(titre);
			String desc = prixTD.select("div.d8eab2cf7f").text();
			System.out.println(desc);
			}*/
		/*String vd=villeD;
		String va=villeA;
		Date dd=dateD;
		Date da=dateA;
		System.out.println("vd : "+vd+" va :"+va+" dd :"+dd+" da :"+da);

		String url = "https://booking.kayak.com/flights/"+vd+"-"+va+"/"+dd.toString()+"/"+da.toString()+"?sort=price_a";
		//String url = "https://booking.kayak.com/flights/CMN-PAR/2023-08-08/2023-09-14?sort=price_a";


		try {
			Document doc = Jsoup.connect(url).get();
			Elements flights = doc.select("div.resultInner");

			for (Element flight : flights) {
				Elements part11 = flight.select("li.flight.with-gutter");
				Elements part12 = flight.select("li.flight");

				avionA = part11.select("div.col-field.carrier").text();
				Aheured = part11.select("div.col-field.time.depart span.depart-time.base-time").text();
				Aheurea = part11.select("div.col-field.time.return span.arrival-time.base-time").text();
				typeA = part11.select("div.col-field.stops").text();
				durationA = part11.select("div.col-field.duration").text();

				avionR = part12.select("div.col-field.carrier").text();
				Rheured = part12.select("div.col-field.time.depart span.depart-time.base-time").text();
				Rheurea = part12.select("div.col-field.time.return span.arrival-time.base-time").text();
				typeR = part12.select("div.col-field.stops").text();
				durationR = part12.select("div.col-field.duration").text();

				prixV = flight.select("div.col-price.result-column.js-no-dtog span.price-text").text();

				System.out.println("Avion Aller : " + avionA);
				System.out.println("Heure de départ Aller : " + Aheured);
				System.out.println("Heure d'arrivée Aller : " + Aheurea);
				System.out.println("Type Aller : " + typeA);
				System.out.println("Durée Aller : " + durationA);
				System.out.println("Avion Retour : " + avionR.split(" ")[1]);
				System.out.println("Heure de départ Retour : " + Rheured.split(" ")[1]);
				System.out.println("Heure d'arrivée Retour : " + Rheurea.split(" ")[1]);
				System.out.println("Type Retour : " + typeR.split(" ")[1]);
				System.out.println("Durée Retour : " + durationR.split(" ")[1]);
				System.out.println("Prix : " + prixV);
				System.out.println("///////////");
				System.out.println("///////////");
				System.out.println("///////////");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/

}

}

