/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.services;

import com.codename1.io.*;
import com.codename1.l10n.ParseException;
import tha9afans.entities.Reservation;
import tha9afans.entities.Ticket;
import tha9afans.gui.SessionManager;
import tha9afans.utilities.Statics;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ibrahim
 */
public class ServiceReservation {

    public static ServiceReservation instance = null;

    private ConnectionRequest conxRequest ;

    private ServiceReservation(){
        conxRequest = new ConnectionRequest();
    }

    public static ServiceReservation getInstance(){
        if (instance == null){
            instance = new ServiceReservation();
        }
        return instance;
    }

    public List<Reservation> fetchReservations() {
        int id= SessionManager.getId();
        String url = Statics.BASE_URL + "/apibilletreservation/showAllReservationByUser/json/"+id;
        conxRequest = new ConnectionRequest();
        conxRequest.setUrl(url);
        conxRequest.setPost(false);
        conxRequest.setContentType("application/json");
        List<Reservation> reservationList = new ArrayList<>();
        conxRequest.addResponseListener((NetworkEvent e) -> {
            JSONParser parser = new JSONParser();
            try {
                Map<String, Object> response = parser.parseJSON(new CharArrayReader(new String(conxRequest.getResponseData()).toCharArray()));
                List<Map<String, Object>> reservations = (List<Map<String, Object>>) response.get("reservation");
                System.out.println("rrrrrrrrrrrrrr :  "+reservations.size());
                        for (Map<String, Object> reservation : reservations) {
                            Reservation r = new Reservation();
                            System.out.println(reservation.get("id").toString());
                            r.setId(Float.parseFloat(reservation.get("id").toString()));
                            r.setEventName(reservation.get("evenement").toString());
                            r.setDateReservation(reservation.get("dateReservation").toString());
                            Object nombreBilletObject = reservation.get("nombreBillet");
                            if (nombreBilletObject instanceof Number) {
                                r.setNombreBillet(((Number)nombreBilletObject).intValue());
                            } else {
                                r.setNombreBillet(0);
                            }
                            r.setPaymentStatus(reservation.get("paymentStatus").toString());
                            r.setNom(reservation.get("nom").toString());
                            r.setPrenom(reservation.get("prenom").toString());
                            r.setEmail(reservation.get("email").toString());
                            r.setTelephone(reservation.get("telephone").toString());
                            r.setAddress(reservation.get("adresse").toString());
                            Object totalPriceObject = reservation.get("totalPrice");
                            if (totalPriceObject instanceof Number) {
                                r.setTotalPrice(((Number)totalPriceObject).intValue());
                            } else {
                                r.setTotalPrice(0);
                            }

                            System.out.println(r);
                            reservationList.add(r);
                        }
            } catch (IOException ex) {
                System.out.println("Error related to IO operation: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Error parsing number: " + ex.getMessage());
            } catch (NullPointerException ex) {
                System.out.println("Got a null value from the server: " + ex.getMessage());
            }
        });

        // Make the request
        NetworkManager.getInstance().addToQueueAndWait(conxRequest);
        return reservationList;
    }

}
    

