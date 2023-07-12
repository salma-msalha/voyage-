package com.example.voyage.Controller;

import java.util.Date;

public class ResultatScraping {
    private String img;
    private String nom_h;
    private String titre;
    private Date checkin;
    private Date checkout;
    private int g_ad;
    private String prix  ;
    private int g_ch;
    private int n_r;
	public String getNom_h() {
		return nom_h;
	}

	public void setNom_h(String nom_h) {
		this.nom_h = nom_h;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}



	private String descrip;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getG_ad() {
        return g_ad;
    }

    public void setG_ad(int g_ad) {
        this.g_ad = g_ad;
    }

    public int getG_ch() {
        return g_ch;
    }

    public void setG_ch(int g_ch) {
        this.g_ch = g_ch;
    }

    public int getN_r() {
        return n_r;
    }

    public void setN_r(int n_r) {
        this.n_r = n_r;
    }



    public ResultatScraping(String img,String desc ,String titre, String  prix, Date checkin, Date checkout, int g_ad, int g_ch, int n_r) {
        this.img = img;
        this.descrip=desc;
        this.prix = prix ;
        this.nom_h = titre;
        this.checkin = checkin;
        this.checkout = checkout;
        this.g_ad = g_ad;
        this.g_ch = g_ch;
        this.n_r = n_r;
    }



}
