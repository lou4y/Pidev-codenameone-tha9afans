package tha9afans.gui;
import com.codename1.io.Preferences;

public class SessionManager {
    public static Preferences pref ; // 3ibara memoire sghira nsajlo fiha data



    // hethom données ta3 user lyt7b tsajlhom fi session  ba3d login
    private static int id ;
    private static String nom ;
    private static String email;
    private static String prenom;
    private static String cin;
    private static String telephone;
    private static String genre;
    private static String adresse;

    private static String passowrd ;
    private static String datenaissance;
    /*private static String photo;*/

    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static int getId() {
        return pref.get("id",id);// kif nheb njib id user connecté apres njibha men pref
    }

    public static void setId(int id) {
        pref.set("id",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }

    public static String getNom() {
        return pref.get("nom",nom);
    }

    public static void setNom(String nom) {
        pref.set("nom",nom);
    }

    public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
        pref.set("email",email);
    }

    public static String getPassowrd() {
        return pref.get("passowrd",passowrd);
    }

    public static void setPassowrd(String passowrd) {
        pref.set("passowrd",passowrd);
    }

    public static String getPrenom() {
        return pref.get("prenom",prenom);
    }

    public static void setPrenom(String prenom) {
        pref.set("prenom",prenom);
    }

    public static String getCin() {
        return pref.get("cin",cin);
    }

    public static void setCin(String cin) {
        pref.set("cin",cin);
    }

    public static String getTelephone() {
        return pref.get("telephone",telephone);
    }

    public static void setTelephone(String telephone) {
        pref.set("telephone",telephone);
    }

    public static String getGenre() {
        return pref.get("genre",genre);
    }

    public static void setGenre(String genre) {
        pref.set("genre",genre);
    }

    public static String getAdresse() {
        return pref.get("adresse",adresse);
    }

    public static void setAdresse(String adresse) {
        pref.set("adresse",adresse);
    }
    /*public static String getPhoto() {
        return pref.get("photo",photo);
    }

    public static void setPhoto(String photo) {
        pref.set("photo",photo);
    }*/

    public static String getDateNaissance() {
        return pref.get("datenaissance",datenaissance);
    }

    public static void setDateNaissance(String dateNaissance) {
        pref.set("datenaissance",datenaissance);
    }
}