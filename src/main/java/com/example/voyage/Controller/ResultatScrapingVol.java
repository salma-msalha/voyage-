package com.example.voyage.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ResultatScrapingVol {
    private Date dateA;
    private Date dateR;
    private String typeA;
    private String typeB;
    private String Aheured;
    private String Aheurea;
    private String Rheured;
    private String Rheurea;
    private String avionA;
    private String avionR;
    private String villeA;
    private String villeR;
    private String prixV;
    private String durationR;
    private String durationA;
    

   

  
    public ResultatScrapingVol(Date dateA, Date dateR, String typeA, String typeB, String aheured, String aheurea,
			String rheured, String rheurea, String avionA, String avionR, String villeA, String villeR, String prixV,
			String durationR, String durationA) {
		super();
		this.dateA = dateA;
		this.dateR = dateR;
		this.typeA = typeA;
		this.typeB = typeB;
		Aheured = aheured;
		Aheurea = aheurea;
		Rheured = rheured;
		Rheurea = rheurea;
		this.avionA = avionA;
		this.avionR = avionR;
		this.villeA = villeA;
		this.villeR = villeR;
		this.prixV = prixV;
		this.durationR = durationR;
		this.durationA = durationA;
	}

    public ResultatScrapingVol(LocalDate dateA2, LocalDate dateR2, String typeA2, String typeR, String aheured2, String aheurea2, String rheured2, String rheurea2, String avionA2, String avionR2, String villeA2, String villeR2, String prixV2, String durationR2, String durationA2) {
        this.dateA = Date.from(dateA2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.dateR = Date.from(dateR2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.typeA = typeA2;
        this.typeB = typeR;
        this.Aheured = aheured2;
        this.Aheurea = aheurea2;
        this.Rheured = rheured2;
        this.Rheurea = rheurea2;
        this.avionA = avionA2;
        this.avionR = avionR2;
        this.villeA = villeA2;
        this.villeR = villeR2;
        this.prixV = prixV2;
        this.durationR = durationR2;
        this.durationA = durationA2;
    }


	public Date getDateA() {
        return dateA;
    }

    public void setDateA(Date dateA) {
        this.dateA = dateA;
    }

    public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getAheured() {
        return Aheured;
    }

    public void setAheured(String Aheured) {
        this.Aheured = Aheured;
    }

    public String getAheurea() {
        return Aheurea;
    }

    public void setAheurea(String Aheurea) {
        this.Aheurea = Aheurea;
    }

    public String getRheured() {
        return Rheured;
    }

    public void setRheured(String Rheured) {
        this.Rheured = Rheured;
    }

    public String getRheurea() {
        return Rheurea;
    }

    public void setRheurea(String Rheurea) {
        this.Rheurea = Rheurea;
    }

    public String getAvionA() {
        return avionA;
    }

    public void setAvionA(String avionA) {
        this.avionA = avionA;
    }

    public String getAvionR() {
        return avionR;
    }

    public void setAvionR(String avionR) {
        this.avionR = avionR;
    }

    public String getVilleA() {
        return villeA;
    }

    public void setVilleA(String villeA) {
        this.villeA = villeA;
    }

    public String getVilleR() {
        return villeR;
    }

    public void setVilleR(String villeR) {
        this.villeR = villeR;
    }

    public String getPrixV() {
        return prixV;
    }

    public void setPrixV(String prixV) {
        this.prixV = prixV;
    }

    public String getDurationR() {
        return durationR;
    }

    public void setDurationR(String durationR) {
        this.durationR = durationR;
    }

    public String getDurationA() {
        return durationA;
    }

    public void setDurationA(String durationA) {
        this.durationA = durationA;
    }
}
