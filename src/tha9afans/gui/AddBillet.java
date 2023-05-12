/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.gui;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

import com.google.zxing.WriterException;
import tha9afans.entities.Billet;
import tha9afans.entities.Evenement;
import tha9afans.entities.Ticket;
import tha9afans.services.ServiceBillet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ibrahim
 */
public class AddBillet  extends Form{
    ServiceBillet serviceBillet = ServiceBillet.getInstance();
    private int idEvent;
    public AddBillet(){
        this.setLayout(BoxLayout.y());
        this.setTitle("Add Billet");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });

        // Retrieve the list of events from the server
        PickerComponent date = PickerComponent.createDate(null).label("Date");
        List<String> events = serviceBillet.getEvents(date);
        PickerComponent eventPicker = PickerComponent.createStrings(events.toArray(new String[0])).label("Event");


        // todo just to initialiser the idEvent
        String selectedEvent0 = eventPicker.getPicker().getSelectedString().trim();
        idEvent = (int)Double.parseDouble(selectedEvent0.substring(0, selectedEvent0.indexOf("-")));
        System.out.println(idEvent);
        // todo just to initialiser the idEvent


// get the value of the selected event
        eventPicker.getPicker().addActionListener((evt) -> {
            String selectedEvent = eventPicker.getPicker().getSelectedString().trim();
            idEvent = (int)Double.parseDouble(selectedEvent.substring(0, selectedEvent.indexOf("-")));
            System.out.println(idEvent);
        });

        // todo TYPE
        Label typeLabel = new Label("Type : ");
        Image vipIcon = FontImage.createMaterial(FontImage.MATERIAL_STAR, "Checkbox VIP", 4.0f);
        Image normalIcon = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_ON, "Checkbox normal", 4.0f);
        Image studentIcon = FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, "Checkbox student", 4.0f);
        RadioButton rb1 = new RadioButton("Normal", normalIcon);
        RadioButton rb2 = new RadioButton("VIP", vipIcon);
        RadioButton rb3 = new RadioButton("Etudiant", studentIcon);
        ButtonGroup group = new ButtonGroup(rb1, rb2, rb3);


        // todo PRICE
        Label prixLabel = new Label("Prix : ");
        TextField prixField = new TextField("","price of the billet");

        // todo NUMBER OF TICKETS
        Label nbrBilletLabel = new Label("Nombre de billet : ");
        TextField nbrBilletField = new TextField("","number of the billet");



        Button submitBtn = new Button("Submit");
        submitBtn.addActionListener(e -> {
            // Get the values from the fields
            String selectedType = group.getSelected().getText();
            String priceText = prixField.getText();
            String nbrBilletText = nbrBilletField.getText();

            // controle de saisie  checkbox
            if (!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected()) {
                Dialog.show("Error", "Please select at least one type of ticket", "OK", null);
                return;
            }
            // controle de saisie the price
            double price = 0;
            try {
                price = Double.parseDouble(priceText);
                if (price < 0) {
                    Dialog.show("Invalid Input", "Price cannot be negative", "OK", null);
                    return;
                }
            } catch (NumberFormatException ex) {
                Dialog.show("Invalid Input", "Please enter a valid price", "OK", null);
                return;
            }
            // controle de saisie the number of tickets
            int nbrBillet = 0;
            try {
                nbrBillet = Integer.parseInt(nbrBilletText);
                if (nbrBillet < 0) {
                    Dialog.show("Invalid Input", "Number of tickets cannot be negative", "OK", null);
                    return;
                }
            } catch (NumberFormatException ex) {
                Dialog.show("Invalid Input", "Please enter a valid number of tickets", "OK", null);
                return;
            }
            // here we will create new billet with our data
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(date.getPicker().getDate());
            Billet billet = new Billet(formattedDate,Float.parseFloat(priceText), selectedType, Integer.parseInt(priceText));
            System.out.println("billllettt date : "+billet.getDateValidite());
            System.out.println(billet);
            serviceBillet.ajouterBillet(idEvent, billet);
        });

        Button showAllBtn = new Button("Show all");
        showAllBtn.addActionListener(e -> {
            List<Ticket> list = new ArrayList<>();

            try {
                list = serviceBillet.getTicketsByEventId(idEvent);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                new ShowAllTickets(list).show();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });



        // todo add weidgts to the form
        Container radioButtonsContainer = new Container(BoxLayout.x());
        radioButtonsContainer.addAll(typeLabel,rb1, rb2, rb3);
        this.addAll(eventPicker, date,  radioButtonsContainer,prixLabel, prixField,nbrBilletLabel, nbrBilletField, submitBtn, showAllBtn);
    }
}
