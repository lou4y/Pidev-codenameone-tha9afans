package tha9afans.services;

import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import tha9afans.entities.Facture;
import tha9afans.utilities.Statics;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ServiceFacture {

    ConnectionRequest req;
    static ServiceFacture instance = null;

    //util
    boolean resultOK = false;
    List<Facture> Factures = new ArrayList<>();

    //Constructor
    private ServiceFacture() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static ServiceFacture getInstance() {
        if (instance == null) {
            instance = new ServiceFacture();
        }

        return instance;
    }

    //ACTIONS
    //Add
    public boolean AddFacture(Facture fc) {

        //1
        String addURL = Statics.BASE_URL + "";

        //2
        req.setUrl(addURL);

        //3
        req.setPost(false);

        //4



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
    public List<Facture> FetchFacture() {

        req = new ConnectionRequest();

        //1
        String fetchURL = Statics.BASE_URL + "/apiproduit";

        //2
        req.setUrl(fetchURL);

        //3
        req.setPost(false);

        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Factures = parseEvents(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return Factures;
    }

    //Parse
    public List<Facture> parseEvents(String jsonText) {
        System.out.println(jsonText);
        // Initialize variables
        List<Facture> factures = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            // Parse the JSON text into a map
            Map<String, Object> rootMap = parser.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            // Get the list of facture from the map
            List<Map<String, Object>> facturesList = (List<Map<String, Object>>) rootMap.get("root");

            // Iterate over the events list
            for (Map<String, Object> factureMap : facturesList) {

                // Create a new Facture object
                Facture facture = new Facture();

                // Parse the event properties from the map

                facture.setRefrancefacture((String) factureMap.get("ref"));
                facture.setDatefacture((Timestamp) factureMap.get("date"));
                facture.getCommande().setTotal((double) factureMap.get("total"));


                // Add the event to the list of facture objects
                factures.add(facture);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Return the list of facture objects
        return factures;
    }


}

