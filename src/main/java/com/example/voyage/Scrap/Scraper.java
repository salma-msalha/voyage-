package com.example.voyage.Scrap;
import com.example.voyage.entities.Hotel;
import com.example.voyage.repository.HotelRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class Scraper {
    @Autowired
    private HotelRepository hotelRepository;

    public void scrapeAndSaveData() throws ParseException, IOException {

        String ville;
        Date checkin;
        Date checkout;
        int g_ad;
        int g_ch;
        int n_r;
        
            Scanner scan = new Scanner(System.in);
            //checkin=2023-07-05&checkout=2023-07-06&group_adults=2&no_rooms=1&group_children=0


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

            System.out.print("group_children : ");
            g_ch = scan.nextInt();

            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");


            checkin = dateFormat.parse(checkin1);
            checkout = dateFormat.parse(checkout1);
            Document HdocE1;
           /* switch (ville) {
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
            }*/

        HdocE1 = Jsoup.connect("https://www.booking.com/searchresults.fr.html?ss=Casablanca&ssne=Casablanca&ssne_untouched=Casablanca&label=fr-iRbsdywwVIW92KCp85hipgS349832748924%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-303403373504%3Alp1009974%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9YURcq_26dhSxO_kD28P4Rwg&sid=91eaaf84c9bd8149a1c96dc76ca4a219&aid=1610680&lang=fr&sb=1&src_elem=sb&src=searchresults&dest_id=-28159&dest_type=city&checkin=" + checkin.toString() + "&checkout=" + checkout.toString() + "&group_adults=" + g_ad + "&no_rooms=" + n_r + "&group_children=" + g_ch).get();



        Elements Hbody = HdocE1.select("div.d4924c9e74");



            for (Element e : Hbody.select("div.a826ba81c4.fa2f36ad22.afd256fc79.d08f526e0d.ed11e24d01.ef9845d4b3.da89aeb942")) {
                String img = e.select("div.f9d4f2568d img").attr("src");
                String titre = e.select("div.f9d4f2568d img").attr("alt");

                Hotel hotel = new Hotel();
                hotel.setNom_h(titre);
                hotel.setG_ch(g_ch);
                hotel.setG_ad(g_ad);
                hotel.setN_r(n_r);
                // Définissez d'autres attributs de l'objet Hotel...

                hotelRepository.save(hotel);
            }
        
    }
}

