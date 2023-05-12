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
public class Reservation {
    private float id;
    private String dateReservation;
    private String status;
    private String paymentInfo;
    private int totalPrice;
    private String paymentStatus;
    private User user;
    private String location;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String address;
    private BilletReserver billetReservers;
    private int nombreBillet;
    public Reservation() {
    }

    public Reservation(float id, String dateReservation,int nombreBillet, String status, String paymentInfo, int totalPrice, String paymentStatus, User user, String location, String nom, String prenom, String email, String telephone, String address, BilletReserver billetReservers) {
        this.id = id;
        this.dateReservation = dateReservation;
        this.status = status;
        this.paymentInfo = paymentInfo;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.user = user;
        this.location = location;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.billetReservers = billetReservers;
        this.nombreBillet=nombreBillet;
    }
    public Reservation(String dateReservation, String status, String paymentInfo, int totalPrice, String paymentStatus, User user, String location, String nom, String prenom, String email, String telephone, String address, BilletReserver billetReservers) {
        this.dateReservation = dateReservation;
        this.status = status;
        this.paymentInfo = paymentInfo;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.user = user;
        this.location = location;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.billetReservers = billetReservers;
    }

    public String getAddress() {
        return address;
    }

    public BilletReserver getBilletReservers() {
        return billetReservers;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public String getEmail() {
        return email;
    }

    public int getNombreBillet() {
        return nombreBillet;
    }



    public float getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLocation() {
        return location;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getStatus() {
        return status;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBilletReservers(BilletReserver billetReservers) {
        this.billetReservers = billetReservers;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setNombreBillet(int nombreBillet) {
        this.nombreBillet = nombreBillet;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateReservation='" + dateReservation + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", nombreBillet=" + nombreBillet +
                '}';
    }
}
