package tha9afans.entities;

/**
 *
 * @author ons
 */
import java.io.InputStream;
import java.util.Date;
public class User {
    private int id;
    private String email;
    private String[] roles;
    private boolean isBlocked;
    private String password,cin,nom,prenom,telephone,adresse;
    private Date dateNaissance;
    private InputStream photo;
    private boolean isVerified;
    private String resetToken,genre;
    private boolean twofactor;

    public User(int id, String email, String[] roles, String password, String cin, String nom, String prenom, String telephone, String adresse, Date dateNaissance, InputStream photo, String genre) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.genre = genre;
    }

    public User(String email, String[] roles, String password, String cin, String nom, String prenom, String telephone, String adresse, Date dateNaissance, InputStream photo, String genre) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isTwofactor() {
        return twofactor;
    }

    public void setTwofactor(boolean twofactor) {
        this.twofactor = twofactor;
    }
}
