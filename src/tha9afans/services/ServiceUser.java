package tha9afans.services;
import java.io.*;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import tha9afans.gui.EditUser;
import tha9afans.gui.EventList;
import tha9afans.gui.SessionManager;
import tha9afans.utilities.Statics;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Vector;

public class ServiceUser {
    public static ServiceUser instance=null;
    public static boolean resultOk = true;
    String json;

    //initilisation connection request
    private ConnectionRequest req;
    public static ServiceUser getInstance() {
        if(instance == null )
            instance = new ServiceUser();
        return instance ;
    }
    public ServiceUser(){
        req=new ConnectionRequest();
    }
    //modifier profile
    public void editUser(int idUser ,TextField nom,TextField prenom,TextField cin,TextField email, ComboBox<String> genre, TextField adresse,TextField telephone ) throws UnsupportedEncodingException {
        
        String telephoneEncoded = URLEncoder.encode(telephone.getText().toString());
        String url = Statics.BASE_URL+"/user/editUser?id="+idUser+"&nom="+nom.getText().toString()+"&prenom="+prenom.getText().toString()+"&cin="+cin.getText().toString()+"&email="+email.getText().toString()+
                "&genre="+genre.getSelectedItem().toString()+"&adresse="+adresse.getText().toString()+"&telephone="+telephoneEncoded;
        req.setUrl(url);


        //Control saisi
        if(nom.getText().equals(" ") && email.getText().equals(" ") && genre.getSelectedItem().equals(" ")&& prenom.getText().equals("") && cin.getText().equals("") ) {

            Dialog.show("Erreur","Veuillez remplir tous les champs","OK",null);

        }
       
        //hethi wa9t tsir execution ta3 url
        req.addResponseListener((e)-> {

                    //njib data ly7atithom fi form
                    byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField
                    String responseData = new String(data);//ba3dika na5o content

                    System.out.println("data ===>"+responseData);
                }
        );
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    //Signup
    public void signup(TextField nom,TextField prenom,TextField cin, TextField password,TextField email,ComboBox<String> genre,TextField adresse,TextField telephone, String date ) throws UnsupportedEncodingException {
        String telephoneEncoded = URLEncoder.encode(telephone.getText().toString());
        String url = Statics.BASE_URL+"/user/signup?nom="+nom.getText().toString()+"&prenom="+prenom.getText().toString()+"&cin="+cin.getText().toString()+"&email="+email.getText().toString()+
                "&password="+password.getText().toString()+"&adresse="+adresse.getText().toString()+"&genre="+genre.getSelectedItem().toString()+ "&telephone="+telephoneEncoded+
                "&datenaissance"+date;

        req.setUrl(url);

        //Control saisi
        if(nom.getText().equals("") && password.getText().equals("") && email.getText().equals("") && genre.getSelectedItem().equals("")&& prenom.getText().equals("") && cin.getText().equals("") ) {

            Dialog.show("Erreur","Veuillez remplir tous les champs","OK",null);

        }
        else if(password.getText().length()<6){
             Dialog.show("Erreur","Votre mot de passe  doit etre de taille >6","OK",null);
                
        }
       
        else if(cin.getText().length()!=8){
            Dialog.show("Erreur","Votre cin doit contenir 8 chiffres","OK",null);
                    
        }
       
        else{
        //hethi wa9t tsir execution ta3 url
        req.addResponseListener((e)-> {

                    //njib data ly7atithom fi form
                    byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField
                    String responseData = new String(data);//ba3dika na5o content

                    System.out.println("data ===>"+responseData);
                }
        );
        }


        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);

    }
    public void signin(TextField email,TextField password) {


        String url = Statics.BASE_URL+"/user/signin?email="+email.getText().toString()+"&password="+password.getText().toString();
        req = new ConnectionRequest(url, false);
        req.setUrl(url);

        req.addResponseListener((e) ->{

            JSONParser j = new JSONParser();

            String json = new String(req.getResponseData()) + "";


            try {

                if ((json.equals("Mot de passe incorrect")) ||(json.equals("Email introuvable"))) {
                    Dialog.show("Echec d'authentification","Username ou mot de passe éronné","OK",null);
                }
                else {
                    System.out.println("data =="+json);
                    Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    float id = Float.parseFloat(user.get("id").toString());
                    SessionManager.setId((int)id);
                    SessionManager.setPassowrd(user.get("password").toString());
                    SessionManager.setNom(user.get("nom").toString());
                    SessionManager.setEmail(user.get("email").toString());
                    SessionManager.setPrenom(user.get("prenom").toString());
                    SessionManager.setCin(user.get("cin").toString());
                    SessionManager.setGenre(user.get("genre").toString());
                    SessionManager.setAdresse(user.get("adresse").toString());
                    SessionManager.setTelephone(user.get("telephone").toString());
                    //SessionManager.setDateNaissance(user.get("datenaissance").toString());
                    Dialog.show("Succes d'authentification","Bienvenue dans tha9afans","OK",null);
                    new EditUser().show();
                }

            }catch(Exception ex) {
                ex.printStackTrace();
            }

        });

        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public String getPasswordByEmail(String email) {


        String url = Statics.BASE_URL+"/user/getPasswordByEmail?email="+email;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);

        req.addResponseListener((e) ->{

            JSONParser j = new JSONParser();

            json = new String(req.getResponseData()) + "";


            try {


                System.out.println("data =="+json);

                
            }catch(Exception ex) {
                ex.printStackTrace();
            }



        });

        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
        return json;
    }


}