/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.entities;

import java.util.Date;

/**
 *
 * @author ghazo
 */
public class Session {
     private double   ID;
    private String title;
    private String host;
    private String Description;
    private String start;
    private String end;

    public Session() {
    }

    public Session(String title, String host, String Description, String start, String end) {
        this.title = title;
        this.host = host;
        this.Description = Description;
        this.start = start;
        this.end = end;
    }

    public Session(double ID, String title, String host, String Description, String start, String end) {
        this.ID = ID;
        this.title = title;
        this.host = host;
        this.Description = Description;
        this.start = start;
        this.end = end;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Session{" + "ID=" + ID + ", title=" + title + ", host=" + host + ", Description=" + Description + ", start=" + start + ", end=" + end + '}';
    }
         

}
