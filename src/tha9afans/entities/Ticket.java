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
    private String nomE;
    private String nomC;
    private String adresse;
    private String code;
    private double prix;
    private String date;
    private String type;
    private int nbrBilletAvailable;
    
    public Ticket(String nomE, String nomC, String adresse, String code, double prix, String date, String type, int nbrBilletAvailable) {
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
}

