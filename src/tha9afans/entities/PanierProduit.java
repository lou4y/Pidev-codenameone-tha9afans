package tha9afans.entities;

import java.util.Objects;

public class PanierProduit {

    private Panier panier;
    private Produit produit;
    private int quantite;

    private int id;
    private float Subtotal;

    public PanierProduit() {
    }

    public PanierProduit(Panier panier, Produit produit, int quantite, int id, float subtotal) {
        this.panier = panier;
        this.produit = produit;
        this.quantite = quantite;
        this.id = id;
        Subtotal = subtotal;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float subtotal) {
        Subtotal = subtotal;
    }

   

    @Override
    public int hashCode() {
        return Objects.hash(getPanier(), getProduit(), getQuantite(), getId(), getSubtotal());
    }

    @Override
    public String toString() {
        return "PanierProduit{" +
                "panier=" + panier +
                ", produit=" + produit +
                ", quantite=" + quantite +
                ", id=" + id +
                ", Subtotal=" + Subtotal +
                '}';
    }
}
