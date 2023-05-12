/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.entities;

import java.util.Date;

/**
 *
 * @author Ibrahim
 */
public class Billet {
    private int id;
    private String code;
    private String dateValidite;
    private double prix;
    private String type;
    private int nbrBilletAvailable;
    private int evenementId;
    private BilletReserver billetReserver;
    private String qrCodeDataUri;
    
    
    public Billet() {
    }
    
    
    public Billet(String dateValidite, float prix, String type, int nbrBilletAvailable) {
        this.dateValidite = dateValidite;
        this.prix = prix;
        this.type = type;
        this.nbrBilletAvailable = nbrBilletAvailable;
    }

    public Billet(int id, String code, String dateValidite, float prix, String type, int nbrBilletAvailable, int evenement, BilletReserver billetReserver, String qrCodeDataUri) {
        this.id = id;
        this.code = code;
        this.dateValidite = dateValidite;
        this.prix = prix;
        this.type = type;
        this.nbrBilletAvailable = nbrBilletAvailable;
        this.evenementId = evenement;
        this.billetReserver = billetReserver;
        this.qrCodeDataUri = qrCodeDataUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(String dateValidite) {
        this.dateValidite = dateValidite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbrBilletAvailable() {
        return nbrBilletAvailable;
    }

    public void setNbrBilletAvailable(int nbrBilletAvailable) {
        this.nbrBilletAvailable = nbrBilletAvailable;
    }

    public String getQrCodeDataUri() {
        return qrCodeDataUri;
    }

    public void setQrCodeDataUri(String qrCodeDataUri) {
        this.qrCodeDataUri = qrCodeDataUri;
    }

    public BilletReserver getBilletReserver() {
        return billetReserver;
    }

    public void setBilletReserver(BilletReserver billetReserver) {
        this.billetReserver = billetReserver;
    }

    public int getEvenement() {
        return evenementId;
    }

    public void setEvenement(int evenement) {
        this.evenementId = evenement;
    }

    @Override
    public String toString() {
        return "Billet{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", dateValidite=" + dateValidite +
                ", prix=" + prix +
                ", type='" + type + '\'' +
                ", nbrBilletAvailable=" + nbrBilletAvailable +
                ", evenementId=" + evenementId +
                ", billetReserver=" + billetReserver +
                ", qrCodeDataUri='" + qrCodeDataUri + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Billet billet = (Billet) o;

        return Double.compare(billet.prix, prix) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(prix);
        return (int) (temp ^ (temp >>> 32));
    }
}

