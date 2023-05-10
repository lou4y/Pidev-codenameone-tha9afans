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
        
        String url = Statics.BASE_URL+"/apifacture";
        req = new ConnectionRequest(url, false);
       
        req.setUrl(url);
        
        req.addResponseListener((e) ->{

            JSONParser j = new JSONParser();

            String json = new String(req.getResponseData()) + "";
            try {
                    Map<String,Object> mapFactures =  j.parseJSON(new CharArrayReader(json.toCharArray()));
                    List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapFactures.get("root");

                    for (int i = 0; i < listOfMaps.size(); i++) {
                        Map<String, Object> obj = listOfMaps.get(i);
                        Facture fact = new Facture();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
   
                        String refrancefacture = obj.get("refrancefacture").toString();
                        Double tva=(Double)obj.get("tva");
                        String nomproduit= obj.get("nomproduit").toString();
                        String useremail=obj.get("useremail").toString();
                        Double totale=(Double) obj.get("totale");
                        String datefacture=obj.get("datefacture").toString();
                        
                        fact.setId((int)id);
                        fact.setRefrancefacture(refrancefacture);
                        fact.setTva(tva);
                        fact.setDatefacture(datefacture);
                        fact.setNomproduit(nomproduit);
                        fact.setUseremail(useremail);
                        fact.setTotale(totale);
                    
                        //insert data into ArrayList result
                        result.add(fact);
                        System.out.println(fact);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        System.out.println("result"+result);
        return result;
        
        
    }

}
