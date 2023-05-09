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
import java.util.ArrayList;
import java.util.List;
//import com.codename1.ui.List;

import java.util.Map;

public class ServiceFacture {
    
    ConnectionRequest req;
    static ServiceFacture instance = null;

    //util
    boolean resultOK = false;

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
    public ArrayList<Facture>affichageFactures() {
        ArrayList<Facture> result = new ArrayList<>();
        
        String url = "https://127.0.0.1:8000/apifacture";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object> mapFactures = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapFactures.get("root");

                    for (int i = 0; i < listOfMaps.size(); i++) {
                        Map<String, Object> obj = listOfMaps.get(i);
                        Facture fact = new Facture();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        System.out.println("id:"+id);
                        
                       
                        
                        String refrancefacture = obj.get("refrancefacture").toString();
                        float etat = Float.parseFloat(obj.get("etat").toString());
                        Double tva=Double.parseDouble(obj.get("tva").toString());
                        
                        fact.setId((int)id);
                        fact.setRefrancefacture(refrancefacture);
                        fact.setTva((Double) tva);
                       
                        
                       
                
                        
                        //insert data into ArrayList result
                        result.add(fact);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        System.out.println("result"+result);
        return result;
        
        
    }

}
