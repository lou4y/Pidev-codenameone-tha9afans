package tha9afans.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.param.PaymentMethodCreateParams;
import tha9afans.entities.Produit;
import tha9afans.services.ServicePanierProduit;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PanierProduit extends Form {

    private List<tha9afans.entities.PanierProduit> panierProduits;
    private double prixTotal = 0;
    private Label prixTotalLabel = new Label();

    public PanierProduit() {
        setTitle("Panier");
        setLayout(BoxLayout.y());

        // Retrieve the data from the service
        panierProduits = ServicePanierProduit.getInstance().fetchProducts();

        // Iterate over the list of products and add them to the interface
        for (tha9afans.entities.PanierProduit panierProduit : panierProduits) {
            Container container = new Container(new BorderLayout());
            container.add(BorderLayout.WEST, new Label(panierProduit.getProduit().getNom()));
            container.add(BorderLayout.EAST, new Label(panierProduit.getProduit().getPrix() + "€"));
            container.add(BorderLayout.SOUTH, new Label("Quantité: " + panierProduit.getQuantite()));
            Button removeButton = new Button("Supprimer");
            removeButton.addActionListener((evt) -> {
                // Remove the product from the cart
                ServicePanierProduit.getInstance().removePanierProduit(panierProduit);
                panierProduits.remove(panierProduit);
                // Remove the container from the interface and update the total price
                removeComponent(container);
                prixTotal -= panierProduit.getSubtotal();
                prixTotalLabel.setText("Prix total: " + prixTotal + "€");
            });
            container.add(BorderLayout.CENTER, removeButton);
            add(container);
            prixTotal += panierProduit.getSubtotal();
        }

        // Display the total price
        prixTotalLabel.setText("Prix total: " + prixTotal + "€");
        add(prixTotalLabel);

    }



    private void ajouterProduitAuPanier(Produit produit) {
        // TODO: Implement this method to add a product to the cart
    }

    private void supprimerProduitDuPanier(Produit produit) {
        // TODO: Implement this method to remove a product from the cart
    }
}