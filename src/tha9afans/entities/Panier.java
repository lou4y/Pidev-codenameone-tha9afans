package tha9afans.entities;

import java.util.Objects;

public class Panier {
    private int id;
    private double total;
    private User user;

    public Panier() {
    }

    public Panier(int id, double total, User user) {
        this.id = id;
        this.total = total;
        this.user = user;
    }

    public Panier(double total, User user) {
        this.total = total;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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
        hash = 89 * hash + this.id;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
