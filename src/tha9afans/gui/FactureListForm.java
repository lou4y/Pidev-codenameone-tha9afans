package tha9afans.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.entities.Facture;
import tha9afans.services.ServiceFacture;

import java.util.List;

public class FactureListForm extends Form {

 /*   private List<Facture> factures;

    public FactureListForm() {
        super("Liste des factures", BoxLayout.y());

        // Create a SpanLabel to display an informative message
        SpanLabel infoLabel = new SpanLabel("Chargement des factures en cours...");
        add(infoLabel);

        // Fetch the list of factures from the web service
        ServiceFacture.getInstance().FetchFacture(((List<Facture> factures) -> {
            // Clear the form's content and update the UI with the fetched data
            removeAll();
            if (factures == null) {
                // Display an error message if no facture was retrieved
                add(new Label("Une erreur est survenue lors du chargement des factures."));
            } else if (factures.isEmpty()) {
                // Display a message if no facture was retrieved
                add(new Label("Aucune facture trouvée."));
            } else {
                // Create a Container to hold the facture details
                Container factureContainer = new Container(BoxLayout.y());
                for (Facture facture : factures) {
                    // Create a Label to display each facture's details
                    Label factureLabel = new Label(facture.getRefrancefacture() + " - " + facture.getDatefacture() + " - " + facture.getCommande().getTotal());
                    factureContainer.add(factureLabel);
                }
                // Add the facture container to the form
                add(factureContainer);
            }
            // Remove the info label from the form
            removeComponent(infoLabel);
        });


        // Add a refresh button to reload the list of factures
        getToolbar().addCommandToRightBar("Actualiser", null, e -> {
            infoLabel.setText("Chargement des factures en cours...");
            ServiceFacture.getInstance().FetchFacture(((List<Facture> factures)-> {
                removeAll();
                if (factures == null) {
                    add(new Label("Une erreur est survenue lors du chargement des factures."));
                } else if (factures.isEmpty()) {
                    add(new Label("Aucune facture trouvée."));
                } else {
                    Container factureContainer = new Container(BoxLayout.y());
                    for (Facture facture : factures) {
                        Label factureLabel = new Label(facture.getRefrancefacture() + " - " + facture.getDatefacture() + " - " + facture.getCommande().getTotal());
                        factureContainer.add(factureLabel);
                    }
                    add(factureContainer);
                }
                removeComponent(infoLabel);
            });
        });
    }*/



        public FactureListForm() {
            super("Factures", BoxLayout.y());

            // Fetch the list of invoices from the service
            List<Facture> factures = ServiceFacture.getInstance().FetchFacture();

            // Display a list of the invoices
            for (Facture facture : factures) {
                MultiButton mb = new MultiButton(facture.getRefrancefacture());
                mb.setTextLine2("Date: " + facture.getDatefacture());
                mb.setTextLine3("Total: " + facture.getCommande().getTotal());
                add(mb);
            }

            // Add a back button to return to the previous form
            Button backButton = new Button("Retour");
            backButton.addActionListener(e -> {
                new HomeForm().show();
            });
            add(backButton);
        }
    }



