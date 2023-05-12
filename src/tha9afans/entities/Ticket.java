/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.entities;

/**
 *
 * @author Ibrahim
 */
public class Ticket {
    private  float id;
    private String nomE;
    private String nomC;
    private String adresse;
    private String code;
    private double prix;
    private String date;
    private String type;
    private int nbrBilletAvailable;

    public Ticket() {
    }
    public Ticket(float id,String nomE, String nomC ,String code,String date, double prix, String type, int nbrBilletAvailable, String adresse) {
        this.id=id;
        this.nomE = nomE;
        this.nomC = nomC;
        this.adresse = adresse;
        this.code = code;
        this.prix = prix;
        this.date = date;
        this.type = type;
        this.nbrBilletAvailable = nbrBilletAvailable;
    }
    
    // getters and setters for all fields


    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", nomE='" + nomE + '\'' +
                ", nomC='" + nomC + '\'' +
                ", adresse='" + adresse + '\'' +
                ", code='" + code + '\'' +
                ", prix=" + prix +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", nbrBilletAvailable=" + nbrBilletAvailable +
                '}';
    }
}

