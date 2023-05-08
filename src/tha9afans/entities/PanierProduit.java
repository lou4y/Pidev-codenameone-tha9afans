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
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.panier);
        hash = 37 * hash + Objects.hashCode(this.produit);
        hash = 37 * hash + this.quantite;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Float.floatToIntBits(this.Subtotal);
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
        final PanierProduit other = (PanierProduit) obj;
        if (this.quantite != other.quantite) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.Subtotal) != Float.floatToIntBits(other.Subtotal)) {
            return false;
        }
        if (!Objects.equals(this.panier, other.panier)) {
            return false;
        }
        return Objects.equals(this.produit, other.produit);
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
