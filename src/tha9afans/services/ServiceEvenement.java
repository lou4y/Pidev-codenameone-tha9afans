/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.services;
import tha9afans.entities.Evenement;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tha9afans.entities.Session;
import tha9afans.utilities.Statics;
/**
 *
 * @author ghazo
 */
public class ServiceEvenement {
    ConnectionRequest req;
    static ServiceEvenement instance = null;

    //util
    boolean resultOK = false;
    List<Evenement> Evenements = new ArrayList<>();

    //Constructor
    private ServiceEvenement() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }

        return instance;
    }

    //ACTIONS
    //Add
    public boolean AddEvent(Evenement ev) {

        //1
        String addURL = Statics.BASE_URL + "/event/add";

        //2
        req.setUrl(addURL);

        //3
        req.setPost(false);

        //4
        req.addArgument("name", ev.getName());
        req.addArgument("Description", ev.getDescription());
        req.addArgument("Adress", ev.getAdress());
        req.addArgument("Date", ev.getDate());
        req.addArgument("category", ev.getCategory());
        req.addArgument("User", String.valueOf(ev.getUser()));

        //5
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOK;
    }

    //FETCH
    public List<Evenement> fetchEvents() {
        
        req = new ConnectionRequest();
        
        //1
        String fetchURL = Statics.BASE_URL + "/event/get";
        
        //2
        req.setUrl(fetchURL);
        
        //3
        req.setPost(false);
        
        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Evenements = parseEvents(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Evenements;
    }

    //Parse
   public List<Evenement> parseEvents(String jsonText) {
       System.out.println(jsonText);
    // Initialize variables
    List<Evenement> evenements = new ArrayList<>();
    JSONParser parser = new JSONParser();

    try {
        // Parse the JSON text into a map
        Map<String, Object> rootMap = parser.parseJSON(new CharArrayReader(jsonText.toCharArray()));

        // Get the list of events from the map
        List<Map<String, Object>> eventsList = (List<Map<String, Object>>) rootMap.get("root");

        // Iterate over the events list
        for (Map<String, Object> eventMap : eventsList) {

            // Create a new Evenement object
            Evenement evenement = new Evenement();

            // Parse the event properties from the map
            evenement.setID((double) eventMap.get("id"));
            evenement.setName((String) eventMap.get("title"));
            evenement.setAdress((String) eventMap.get("Adress"));
            evenement.setDescription((String) eventMap.get("description"));
            evenement.setDate((String) eventMap.get("date"));
            evenement.setCategory((String) eventMap.get("category"));

            // Get the list of sessions for the event
            List<Map<String, Object>> sessionsList = (List<Map<String, Object>>) eventMap.get("sessions");

            // Iterate over the sessions list and create new Session objects
            List<Session> sessions = new ArrayList<>();
            for (Map<String, Object> sessionMap : sessionsList) {
                Session session = new Session();
                session.setID((double) sessionMap.get("id"));
                session.setTitle((String) sessionMap.get("titre"));
                session.setDescription((String) sessionMap.get("description"));
                session.setHost((String) sessionMap.get("parlant"));
                session.setStart((String) sessionMap.get("debut"));
                session.setEnd((String) sessionMap.get("fin"));
                sessions.add(session);
            }

            // Set the sessions list for the event
            evenement.setList((ArrayList<Session>) sessions);

            // Add the event to the list of Evenement objects
            evenements.add(evenement);
        }

    } catch (IOException ex) {
        ex.printStackTrace();
    }
       
    // Return the list of Evenement objects
    return evenements;
}


}


