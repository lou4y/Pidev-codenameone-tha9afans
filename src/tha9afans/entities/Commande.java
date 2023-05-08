package tha9afans.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Commande {
    private int id;
    private Timestamp dateCommande;
    private Double total;
    private User user;

    public Commande() {
    }

    public Commande(int id, Timestamp dateCommande, Double total, User user) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.total = total;
        this.user = user;
    }

    public Commande(Timestamp dateCommande, Double total, User user) {
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

    public Timestamp getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Timestamp dateCommande) {
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
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dateCommande, other.dateCommande)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return Objects.equals(this.user, other.user);
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
