package tha9afans.services;

import com.codename1.io.*;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import tha9afans.entities.Commande;
import tha9afans.entities.Facture;
import tha9afans.utilities.Statics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceFacture {

    public static List<Facture> getFactures() {
        List<Facture> factures = new ArrayList<>();

        // Make an HTTP GET request to the Symfony web service endpoint
        String url = "https://127.0.0.1:8000/apifacture";
        ConnectionRequest request = new ConnectionRequest();
        request.setUrl(url);
        request.setHttpMethod("GET");

        // Handle the response from the Symfony web service
        request.addResponseListener(evt -> {
            try {
                // Parse the JSON response into a list of facture objects
                JSONParser parser = new JSONParser();
                Map<String, Object> result = parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(request.getResponseData())));
                List<Map<String, Object>> factureMaps = (List<Map<String, Object>>) result.get("root");
                for (Map<String, Object> factureMap : factureMaps) {
                    Facture facture = new Facture();
                    facture.setRefrancefacture((String) factureMap.get("ref"));
                    facture.setDatefacture((Timestamp) factureMap.get("date"));
                    facture.getCommande().setTotal((double) factureMap.get("total"));
                    factures.add(facture);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Handle errors
        request.addResponseCodeListener(evt -> {
            if (evt.getResponseCode() >= 400) {
                System.out.println("Error response code: " + evt.getResponseCode());
                Dialog.show("Error", "An error occurred while communicating with the server", "OK", null);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(request);

        return factures;
    }
}