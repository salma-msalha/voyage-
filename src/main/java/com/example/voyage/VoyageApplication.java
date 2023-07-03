package com.example.voyage;

import ch.qos.logback.core.CoreConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class VoyageApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(VoyageApplication.class, args);
		System.out.println("hello");
	}

}

