package tha9afans.entities;

import java.util.Objects;

public class Commande {
    private int id;
    private String dateCommande;
    private Double total;
    private User user;

    public Commande() {
    }

    public Commande(int id, String dateCommande, Double total, User user) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.total = total;
        this.user = user;
    }

    public Commande(String dateCommande, Double total, User user) {
        this.dateCommande = dateCommande;
        this.total = total;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.dateCommande);
        hash = 61 * hash + Objects.hashCode(this.total);
        hash = 61 * hash + Objects.hashCode(this.user);
        return hash;
    }



    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", dateCommande=" + dateCommande +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
