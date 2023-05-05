/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import java.util.List;
import tha9afans.entities.Evenement;
import tha9afans.services.ServiceEvenement;

/**
 *
 * @author ghazo
 */
public class EventList extends Form{
         ServiceEvenement se = ServiceEvenement.getInstance();
    List<Evenement> events= se.fetchEvents();
    public EventList() {
        this.setLayout(BoxLayout.yCenter());
        this.setTitle("Event List");
        for (Evenement event : events) {
                 Button EventBtn = new Button(event.getName());
                   EventBtn.addActionListener((evt) -> {
           
            new ViewEvent(event).show();
            
        });
                 this.add(EventBtn);
        }
        
    }
    
}
