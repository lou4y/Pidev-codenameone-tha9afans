package tha9afans.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Facture {
    private int id;
    private Commande commande;
    private Timestamp datefacture;
    private Double tva;
    private String refrancefacture;

    public Facture() {
    }

    public Facture(int id, Commande commande, Timestamp datefacture, Double tva, String refrancefacture) {
        this.id = id;
        this.commande = commande;
        this.datefacture = datefacture;
        this.tva = tva;
        this.refrancefacture = refrancefacture;
    }

    public Facture(Commande commande, Timestamp datefacture, Double tva, String refrancefacture) {
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

    public Timestamp getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(Timestamp datefacture) {
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
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.commande);
        hash = 41 * hash + Objects.hashCode(this.datefacture);
        hash = 41 * hash + Objects.hashCode(this.tva);
        hash = 41 * hash + Objects.hashCode(this.refrancefacture);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.refrancefacture, other.refrancefacture)) {
            return false;
        }
        if (!Objects.equals(this.commande, other.commande)) {
            return false;
        }
        if (!Objects.equals(this.datefacture, other.datefacture)) {
            return false;
        }
        return Objects.equals(this.tva, other.tva);
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
