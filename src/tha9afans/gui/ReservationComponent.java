package tha9afans.gui;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.entities.Reservation;

public class ReservationComponent extends Container {
    public ReservationComponent(Reservation reservation) {

        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label l4 =new Label("Nom : " + reservation.getNom());
        Label l = new Label ("Event Name : " + reservation.getEventName());
        Label l1 = new Label("Date Reservation : " + reservation.getDateReservation());
        Label l3 = new Label("Nombre de billet : " + reservation.getNombreBillet());
        Label l2 = new Label("Paiment Status : " + reservation.getPaymentStatus());
        Label l5 = new Label("Prix : " + reservation.getTotalPrice());
        this.add(l4);
        this.add(l);
        this.add(l1);
        this.add(l3);
        this.add(l2);
        this.add(l5);




    }
}
