/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.list.MultiList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import tha9afans.entities.Evenement;
import tha9afans.entities.Session;
import tha9afans.services.ServiceEvenement;

/**
 *
 * @author ghazo
 */
public class ViewEvent extends Form {
        ServiceEvenement se = ServiceEvenement.getInstance();
    List<Evenement> events= se.fetchEvents();
public ViewEvent(Evenement event) {
       this.setLayout(BoxLayout.y());
        this.setTitle("Events");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();  
        });
     
// Create a multi-list container to display events and their sessions
MultiList ml = new MultiList();

// Create a data model to store the event and session data
DefaultListModel<Map<String, Object>> model = new DefaultListModel<>();

Label title =new Label("TITLE: "+event.getName());
Label des =new Label("Description: "+event.getDescription());
Label date =new Label("Date: "+event.getDate());
Label adress =new Label("Adress: "+event.getAdress());
Label category =new Label("category: "+event.getCategory());



// Loop through each session of this event
for (Session session : event.getList()) {

    // Create a new map to store session data
    Map<String, Object> sessionData = new HashMap<>();
    sessionData.put("Line1", session.getTitle());
    sessionData.put("Line2", session.getHost());
    sessionData.put("Line3", session.getStart() + " - " + session.getEnd());

model.addItem(sessionData);
}

ml.setModel(model);
this.addAll(title,des,date,adress,category,ml);
}

}

