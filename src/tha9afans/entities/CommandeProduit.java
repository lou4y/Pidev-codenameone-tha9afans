package tha9afans.entities;

import java.util.Objects;

public class CommandeProduit {
    private  int id;
    private Commande commande;
    private int quantite;
    private Produit produit;

    public CommandeProduit() {
    }

    public CommandeProduit(int id, Commande commande, int quantite, Produit produit) {
        this.id = id;
        this.commande = commande;
        this.quantite = quantite;
        this.produit = produit;
    }

    public CommandeProduit(Commande commande, int quantite, Produit produit) {
        this.commande = commande;
        this.quantite = quantite;
        this.produit = produit;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.commande);
        hash = 97 * hash + this.quantite;
        hash = 97 * hash + Objects.hashCode(this.produit);
        return hash;
    }

    @Override
    public String toString() {
        return "CommandeProduit{" +
                "id=" + id +
                ", commande=" + commande +
                ", quantite=" + quantite +
                ", produit=" + produit +
                '}';
    }
}
