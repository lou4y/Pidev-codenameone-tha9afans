package tha9afans.services;

import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tha9afans.entities.PanierProduit;

import java.util.ArrayList;
import java.util.List;

public class ServicePanierProduit {
    ConnectionRequest req;
    static ServicePanierProduit instance = null;

    //Constructor
    private ServicePanierProduit() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static ServicePanierProduit getInstance() {
        if (instance == null) {
            instance = new ServicePanierProduit();
        }
        return instance;
    }

    //ACTIONS
    //Add
    public boolean addProduct(PanierProduit panierproduit) {
        //1
        String addURL = "https://localhost:8000/apiproduit";

        //2
        req.setUrl(addURL);

        //3
        req.setPost(true);

        //4
        req.setRequestBody("{\"panierproduits\": [{\"produit nom\": \"" + panierproduit.getProduit().getNom() + "\", \"quantite\": " + panierproduit.getQuantite() + ", \"prix_unitaire\": " + panierproduit.getProduit().getPrix() + " }]}");

        //5
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("Add product response code: " + req.getResponseCode());
                instance.req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return req.getResponseCode() == 200;
    }

    //FETCH
    public List<PanierProduit> fetchProducts() {
        req = new ConnectionRequest();

        //1
        String fetchURL = "https://127.0.0.1:8000/apiproduit";

        //2
        req.setUrl(fetchURL);

        //3
        req.setPost(false);

        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("Fetch products response code: " + req.getResponseCode());
                List<PanierProduit> panierProduits = parseProducts(new String(req.getResponseData()));
                instance.req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return null ;
    }

    //Parse
    public List<PanierProduit> parseProducts(String jsonText) {
        System.out.println(jsonText);
        List<PanierProduit> panierproduits = new ArrayList<>();
        try {
            // Parse the JSON text into a JSONObject
            JSONObject root = new JSONObject(jsonText);

            // Get the array of products from the JSONObject
            JSONArray productsArray = root.getJSONArray("panierproduits");

            // Iterate over the products array
            for (int i = 0; i < productsArray.length(); i++) {
                JSONObject productObj = productsArray.getJSONObject(i);

                // Create a new Product object
                PanierProduit panierProduit = new PanierProduit();
                panierProduit.getProduit().setNom((String) productObj.get("produit nom"));
                panierProduit.setQuantite(productObj.getInt("quantite"));

                // Add the product to the list of products
                panierproduits.add(panierProduit);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        // Return the list of Product objects
        return panierproduits;
    }

    public void removePanierProduit(PanierProduit panierProduit) {
    }
}

