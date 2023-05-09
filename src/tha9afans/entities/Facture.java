package tha9afans.entities;

import java.util.Objects;

public class Facture {
    private int id;
    private Commande commande;
    private String datefacture;
    private Double tva;
    private String refrancefacture;

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

  

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommande(), getDatefacture(), getTva(), getRefrancefacture());
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", commande=" + commande +
                ", datefacture=" + datefacture +
                ", tva=" + tva +
                ", refrancefacture='" + refrancefacture + '\'' +
                '}';
    }
}
