/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.entities;

/**
 *
 * @author Ibrahim
 */
public class BilletReserver {
    
   private int id ;
   private int number;
   private Billet billet;
   private Reservation reservation;
   
   public BilletReserver( int number, Billet billet, Reservation reservation){
       this.number=number;
       this.billet=billet;
       this.reservation=reservation;
}

   public BilletReserver() {
    }

   public BilletReserver(int id, int number, Billet billet, Reservation reservation) {
        this.id = id;
        this.number = number;
        this.billet = billet;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
 
}
