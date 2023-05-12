/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.services;

import com.codename1.io.*;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.events.ActionListener;
import com.codename1.util.regex.StringReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import tha9afans.entities.Billet;
import tha9afans.entities.Evenement;
import tha9afans.entities.Ticket;
import tha9afans.utilities.Statics;

/**
 *
 * @author Ibrahim
 */
public class ServiceBillet {

    boolean resultOK = false;
    public static ServiceBillet instance = null;
    
    private ConnectionRequest conxRequest ;
    
    private ServiceBillet(){
        conxRequest = new ConnectionRequest();
    }
    
    public static ServiceBillet getInstance(){
        if (instance == null){
            instance = new ServiceBillet();
        }
        return instance;
    }


    public boolean  ajouterBillet(int idEvent, Billet billet){
        conxRequest=new ConnectionRequest();
        String url = Statics.BASE_URL+"/apibilletreservation/"+idEvent+"/new/json";
        conxRequest.setUrl(url);
        conxRequest.setHttpMethod("POST");

        conxRequest.addArgument("type", billet.getType());
        System.out.println("type = " + billet.getType());
        conxRequest.addArgument("prix", String.valueOf(billet.getPrix()));
        System.out.println("prix = " + billet.getPrix());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(billet.getDateValidite());
        conxRequest.addArgument("dateValidite", formattedDate);
        System.out.println("dateValidite = " + formattedDate);
        conxRequest.addArgument("nbrBilletAvailable", String.valueOf(billet.getNbrBilletAvailable()));
        System.out.println("nbrBilletAvailable = " + billet.getNbrBilletAvailable());
        conxRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = conxRequest.getResponseCode() == 200;
                conxRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(conxRequest);

        return resultOK;
    }

    public ArrayList<String> getEvents(PickerComponent date) {
        ArrayList<String> listEvents = new ArrayList<>();
        String url = Statics.BASE_URL + "/apievenement/all/json";
        conxRequest.setUrl(url);
        conxRequest.setHttpMethod("GET");
        conxRequest.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> events = jsonp.parseJSON(new InputStreamReader(new ByteArrayInputStream(conxRequest.getResponseData()), "UTF-8"));
                List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("evenement");
                for (Map<String, Object> obj : list) {
                    String id = obj.get("id").toString();
                    String nom = obj.get("nom").toString();
                    String dateStr = obj.get("date").toString();
                        listEvents.add(id + " - " + nom);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date initialDate = dateFormat.parse(dateStr);
                       if (listEvents.size() == 1) {
                            date.getPicker().setDate(initialDate);
                       }
                }
                System.out.println("listEvents = " + listEvents);
            } catch (IOException ex) {
                System.out.println("error related to IO operation");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // catch (DateTimeParseException ex) {
              //  System.out.println("error parsing date: " + ex.getMessage());
            //} 
        });
        conxRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = conxRequest.getResponseCode() == 200;
                conxRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(conxRequest);
        System.out.println(resultOK);
        return listEvents;
    }


    public void editBillet(int id, Billet billet) {
        String url = Statics.BASE_URL+"/apibilletreservation/"+id+"/edit/json";
        conxRequest.setUrl(url);
        conxRequest.setHttpMethod("PUT");

        conxRequest.addArgument("prix", String.valueOf(billet.getPrix()));
        conxRequest.addArgument("nbrBilletAvailable", String.valueOf(billet.getNbrBilletAvailable()));
        NetworkManager.getInstance().addToQueueAndWait(conxRequest);
    }
    
    
    public void deleteBillet(int id) {
        String url = Statics.BASE_URL + "/apibilletreservation/" + id + "/delete/json";
        conxRequest.setUrl(url);
        conxRequest.setHttpMethod("DELETE");
        NetworkManager.getInstance().addToQueueAndWait(conxRequest);
    }

    public List<Ticket> getTicketsByEventId(int eventId) throws IOException {
        conxRequest = new ConnectionRequest();
        String url = Statics.BASE_URL+"/apibilletreservation/" + eventId + "/showAllByEvent/json";
        conxRequest.setUrl(url);
        conxRequest.setPost(false);
        conxRequest.setContentType("application/json");
        List<Ticket> ticketList = new ArrayList<>();
        conxRequest.addResponseListener((NetworkEvent e) -> {
            JSONParser j = new JSONParser();
            try {
                Map<String, Object> tickets = j.parseJSON(new CharArrayReader(new String(conxRequest.getResponseData()).toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) tickets.get("billet");
                for (Map<String, Object> obj : list) {
                    Ticket ticket = new Ticket();
                    ticket.setId(Float.parseFloat(obj.get("id").toString()));
                    ticket.setNomE(obj.get("nomE").toString());

                    if (obj.get("nomC") != null) {
                        ticket.setNomC(obj.get("nomC").toString());
                    } else {
                        ticket.setNomC("");
                    }

                    if (obj.get("address") != null) {
                        ticket.setAdresse(obj.get("address").toString());
                    } else {
                        ticket.setAdresse("");
                    }

                    if (obj.get("code") != null) {
                        ticket.setCode(obj.get("code").toString());
                    } else {
                        ticket.setCode("");
                    }

                    ticket.setPrix((int) Float.parseFloat(obj.get("prix").toString()));

                    if (obj.get("dateValidite") != null) {
                        ticket.setDate(obj.get("dateValidite").toString());
                    } else {
                        ticket.setDate("");
                    }

                    if (obj.get("type") != null) {
                        ticket.setType(obj.get("type").toString());
                    } else {
                        ticket.setType("");
                    }

                    ticket.setNbrBilletAvailable((int) Float.parseFloat(obj.get("nbrBilletAvailable").toString()));
                    ticketList.add(ticket);
                }

            } catch (IOException ex) {
                System.out.println("error related to IO operation");
            } catch (NumberFormatException ex) {
                System.out.println("error parsing number: " + ex.getMessage());
            } catch (NullPointerException ex) {
                System.out.println("got a null value from the server: " + ex.getMessage());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(conxRequest);
        return ticketList;
    }







}
