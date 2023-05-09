/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.util.regex.StringReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tha9afans.entities.Billet;
import tha9afans.entities.Ticket;
import tha9afans.utilities.Statics;

/**
 *
 * @author Ibrahim
 */
public class ServiceBillet {
    
    public static ServiceBillet instance = null;
    
    private ConnectionRequest conxRequest ;
    
    private ServiceBillet(){
        conxRequest = new ConnectionRequest();
    }
    
    public ServiceBillet getConnection(){
        if (instance == null){
            instance = new ServiceBillet();
        }
        return instance;
    }
    
    public void ajouterBillet(int idEvent, Billet billet){
        String url = Statics.BASE_URL+"/apibilletreservation/"+idEvent+"/new/json";
        conxRequest.setUrl(url);
        conxRequest.setHttpMethod("POST");
// to tell to the server that we will sent you json format.
        conxRequest.setContentType("application/json");
        
        conxRequest.addArgument("type", billet.getType());
        conxRequest.addArgument("prix", String.valueOf(billet.getPrix()));
        conxRequest.addArgument("dateValidite", billet.getDateValidite().toString());
        conxRequest.addArgument("nbrBilletAvailable", String.valueOf(billet.getNbrBilletAvailable()));

        NetworkManager.getInstance().addToQueueAndWait(conxRequest);
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
    

//   public Ticket showBillet(int billetId) {
//    String url = Statics.BASE_URL+"/apibilletreservation/" + billetId + "/show/json";
//    conxRequest.setUrl(url);
//
//    conxRequest.addResponseListener((NetworkEvent evt) -> {
//        byte[] bytes = conxRequest.getResponseData();
//        String json = new String(bytes);
//        JSONParser parser = new JSONParser();
//        try {
//            Map<String, Object> data = parser.parseJSON(new StringReader(json));
//            String nomE = (String) data.get("nomE");
//            String nomC = (String) data.get("nomC");
//            String adresse = (String) data.get("adresse");
//            String code = (String) data.get("code");
//            Double prix = (Double) data.get("prix");
//            String date = (String) data.get("date");
//            String type = (String) data.get("type");
//            Integer nbrBilletAvailable = (Integer) data.get("nbrBilletAvailable");
//
//            Ticket ticket = new Ticket(nomE, nomC, adresse, code, prix, date, type, nbrBilletAvailable);
//            return ticket;
//            // display the ticket on your interface
//            // it may return the ticket if u want just return null and . You can then do whatever you need with the ticket
//            //object inside the listener, e.g. display it on the GUI.
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    });
//
//    conxRequest.setFailSilently(true);
//    NetworkManager.getInstance().addToQueue(conxRequest);
//
//    // if no ticket is returned in the listener, return null
//    return null;
//}
//
//
//   public ArrayList<Ticket> getTicketsByEventId(int eventId) throws IOException {
//    String url = Statics.BASE_URL+"/apibilletreservation/" + eventId + "/showAllByEvent/json";
//
//    conxRequest.setUrl(url);
//    conxRequest.setPost(false);
//    conxRequest.setContentType("application/json");
//
//    conxRequest.addResponseListener((NetworkEvent e) -> {
//        try {
//            JSONParser parser = new JSONParser();
//            Map<String, Object> data = parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(conxRequest.getResponseData()), "UTF-8"));
//
//            // extract the event and billet data
//            Map<String, Object> eventMap = (Map<String, Object>) data.get("event");
//            Map<String, Object>[] billetArray = (Map<String, Object>[]) data.get("billet");
//
//            // create a new list to hold the tickets
//            List<Ticket> ticketList = new ArrayList<>();
//
//            // iterate through the billet array and create Ticket objects
//            for (Map<String, Object> billetMap : billetArray) {
//                Ticket ticket = new Ticket(
//                        (String) eventMap.get("nomE"),
//                        (String) eventMap.get("nomC"),
//                        (String) eventMap.get("adresse"),
//                        (String) billetMap.get("code"),
//                        ((Double) billetMap.get("prix")).doubleValue(),
//                        (String) billetMap.get("dateValidite"),
//                        (String) billetMap.get("type"),
//                        ((Integer) billetMap.get("nbrBilletAvailable")).intValue()
//                );
//                ticketList.add(ticket);
//            }
//
//            // return the list of tickets
//            return ticketList;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    });
//
//    NetworkManager.getInstance().addToQueueAndWait(conxRequest);
//        return null;
//    }
   
}
