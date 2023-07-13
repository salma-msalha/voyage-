package com.example.voyage.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtils {
	
	public static Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the exception or return a default value if the parsing fails
        }
        return null; // Return null or handle the error case appropriately
    }

}
