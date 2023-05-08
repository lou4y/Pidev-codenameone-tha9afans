package tha9afans.gui;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.util.List;
import tha9afans.entities.Facture;
import tha9afans.services.ServiceFacture;

public class FactureListForm extends Form {

    public FactureListForm() {
        super("Liste des factures");

        // Use a vertical BoxLayout for the form's content pane
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        // Get the list of factures from the web service
        List<Facture> factures = ServiceFacture.getFactures();
        System.out.println(factures);

        // Create a container to hold the facture labels
        Container factureContainer = new Container();
        factureContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        // Add a label for each facture to the container
        for (Facture facture : factures) {
            factureContainer.addComponent(createFactureLabel(facture));
        }
        // Add the facture container to the form's content pane
        this.addComponent(factureContainer);
    }

    private Component createFactureLabel(Facture facture) {
        // Create a label to display the facture's details
        String labelString = String.format("Référence: %s | Date: %s | Total: %.2f",
                facture.getRefrancefacture(), facture.getDatefacture().toString(), facture.getCommande().getTotal());
        Label factureLabel = new Label(labelString);

        // Set the label's style
        /*factureLabel.getStyle().setPadding(10, 10, 0, 10);
        factureLabel.getStyle().setFont(Display.getInstance().getSystemFont());*/

        return factureLabel;
    }
}


