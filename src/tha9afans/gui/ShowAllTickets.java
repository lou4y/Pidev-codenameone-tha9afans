package tha9afans.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.google.zxing.WriterException;
import tha9afans.entities.Ticket;

import java.io.IOException;
import java.util.List;

public class ShowAllTickets extends Form {

    public ShowAllTickets(List<Ticket> list) throws IOException, WriterException {
        this.setLayout(BoxLayout.y());
        this.setTitle("show Billet of the event");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new AddBillet().showBack();
        });

        // here i'll try to display all the tickets of the event
        Label l1 = new Label("********************* TICKETS *********************");
        this.add(l1);
        for (Ticket ticket : list) {
            Label l2 = new Label(" ");
            this.add(l2);
            // label that take the  number of iteration of the loop
            Label l = new Label("Ticket N° : " + list.indexOf(ticket)+1);
            this.add(l);
            this.add(new TicketComponent(ticket));
        }

    }
}
