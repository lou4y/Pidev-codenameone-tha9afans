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
    private Date dateValidite;
    private float prix;
    private String type;
    private int nbrBilletAvailable;
    private Evenement evenement;
    private BilletReserver billetReserver;
    private String qrCodeDataUri;
    
    
    public Billet() {
    }
    
    
    public Billet(String code, Date dateValidite, float prix, String type, int nbrBilletAvailable, Evenement evenement, BilletReserver billetReserver, String qrCodeDataUri) {
        this.code = code;
        this.dateValidite = dateValidite;
        this.prix = prix;
        this.type = type;
        this.nbrBilletAvailable = nbrBilletAvailable;
        this.evenement = evenement;
        this.billetReserver = billetReserver;
        this.qrCodeDataUri = qrCodeDataUri;
    }

    public Billet(int id, String code, Date dateValidite, float prix, String type, int nbrBilletAvailable, Evenement evenement, BilletReserver billetReserver, String qrCodeDataUri) {
        this.id = id;
        this.code = code;
        this.dateValidite = dateValidite;
        this.prix = prix;
        this.type = type;
        this.nbrBilletAvailable = nbrBilletAvailable;
        this.evenement = evenement;
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

    public Date getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Date dateValidite) {
        this.dateValidite = dateValidite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
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

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}

