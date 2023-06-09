package tha9afans.entities;

import java.util.Objects;

public class Facture {
    private int id;
    private Commande commande;
    private String datefacture;
    private Double tva;
    private String refrancefacture;
    private String useremail;
    private String nomproduit;
    private Double totale;

    public Facture() {
    }

    public Facture(int id, Commande commande,String datefacture, Double tva, String refrancefacture) {
        this.id = id;
        this.commande = commande;
        this.datefacture = datefacture;
        this.tva = tva;
        this.refrancefacture = refrancefacture;
    }

    public Facture(Commande commande, String datefacture, Double tva, String refrancefacture) {
        this.commande = commande;
        this.datefacture = datefacture;
        this.tva = tva;
        this.refrancefacture = refrancefacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public String getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(String datefacture) {
        this.datefacture = datefacture;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public String getRefrancefacture() {
        return refrancefacture;
    }

    public void setRefrancefacture(String refrancefacture) {
        this.refrancefacture = refrancefacture;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.commande);
        hash = 41 * hash + Objects.hashCode(this.datefacture);
        hash = 41 * hash + Objects.hashCode(this.tva);
        hash = 41 * hash + Objects.hashCode(this.refrancefacture);
        return hash;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", commande=" + commande + ", datefacture=" + datefacture + ", tva=" + tva + ", refrancefacture=" + refrancefacture + ", useremail=" + useremail + ", nomproduit=" + nomproduit + ", totale=" + totale + '}';
    }

    
    

   
}
