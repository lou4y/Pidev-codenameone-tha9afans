/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.entities;

import java.util.ArrayList;


/**
 *
 * @author ghazo
 */
public class Evenement {
    private double ID;
    private String name;
    private String Description;
    private String Adress;
    private String Date ;
    private String category;
    private ArrayList<Session> list;
    private int user;
    public Evenement() {
    }

    public Evenement(String name, String Description, String Adress, String Date, String category, int user) {
        this.name = name;
        this.Description = Description;
        this.Adress = Adress;
        this.Date = Date;
        this.category = category;
        this.list = list;
        this.user = user;
    }

    public Evenement(double ID, String name, String Description, String Adress, String Date, String category, ArrayList<Session> list, int user) {
        this.ID =  ID;
        this.name = name;
        this.Description = Description;
        this.Adress = Adress;
        this.Date = Date;
        this.category = category;
        this.list = list;
        this.user = user;
    }


 

    

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public ArrayList<Session> getList() {
        return list;
    }

    public void setList(ArrayList<Session> list) {
        this.list = list;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Evenement{" + "ID=" + ID + ", name=" + name + ", Description=" + Description + ", Adress=" + Adress + ", Date=" + Date + ", category=" + category  + ", list=" + list + ", user=" + user + '}';
    }

   

 
            
    
}
