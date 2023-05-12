package tha9afans.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.entities.Reservation;
import tha9afans.services.ServiceReservation;

import java.util.List;

public class ShowReservation extends Form {
    public ShowReservation() {
        this.setTitle("Show Reservation");
        this.setLayout(BoxLayout.y());
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });

        ServiceReservation serviceReservation = ServiceReservation.getInstance();
        List<Reservation> reservations = serviceReservation.fetchReservations();
        int x = reservations.size();
        Label l1 = new Label("******************** Reservations ********************");
        this.add(l1);
        for (Reservation reservation : reservations) {
            Image studentIcon = FontImage.createMaterial(FontImage.MATERIAL_STAR, "Checkbox student", 4.0f);
            int index = reservations.indexOf(reservation)+1;
            Label l = new Label("Reservation N° : " + index);
            this.add(studentIcon);
            this.add(l);
            //create a ReservationComponent for each reservation
            this.add(new ReservationComponent(reservation));
            Label l2 = new Label(" ");
            this.add(l2);

        }
    }
}
