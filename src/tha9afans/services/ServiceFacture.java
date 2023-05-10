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
        req.setInsecure(true);
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
                        System.out.println("id:"+id);
                        
                       
                        
                        String refrancefacture = obj.get("refrancefacture").toString();
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
            
            
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        System.out.println("result"+result);
        return result;
        
        
    }

}
