package tha9afans.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.entities.Evenement;
import tha9afans.entities.Session;
import tha9afans.services.ServiceEvenement;

public class ViewEvent extends Form {
    private ServiceEvenement se = ServiceEvenement.getInstance();
    private Evenement event;
    
    public ViewEvent(Evenement event) {
        this.event = event;
        setTitle("Event Details");
        setLayout(new BorderLayout());

        Container content = new Container(BoxLayout.y());

        Label titleLabel = new Label("Title: " + event.getName());
        titleLabel.getUnselectedStyle().setFont(Font.createTrueTypeFont("native:ItalicBold", 5));

        Label descLabel = new Label("Description: " + event.getDescription());

        Label dateLabel = new Label("Date: " + event.getDate());

        Label addressLabel = new Label("Address: " + event.getAdress());

        Label categoryLabel = new Label("Category: " + event.getCategory());

        content.add(titleLabel)
                .add(descLabel)
                .add(dateLabel)
                .add(addressLabel)
                .add(categoryLabel);

        for (Session session : event.getList()) {
            Container sessionContainer = new Container(BoxLayout.y());

            Label sessionTitleLabel = new Label("Session Title: " + session.getTitle());
            Label hostLabel = new Label("Host: " + session.getHost());
            Label timeLabel = new Label("Time: " + session.getStart() + " - " + session.getEnd());

            sessionContainer.add(sessionTitleLabel)
                    .add(hostLabel)
                    .add(timeLabel);

            content.add(sessionContainer);
        }

        add(BorderLayout.CENTER, content);

        getToolbar().setBackCommand("", e -> new HomeForm().showBack());
    }
}