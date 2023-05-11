package tha9afans.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
import tha9afans.entities.Facture;
import tha9afans.services.ServiceFacture;

public class FactureListForm extends Form {

    public FactureListForm() {
        super("Liste des factures");

        // Use a vertical BoxLayout for the form's content pane
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        // Add a back button to the toolbar
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });

        // Get the list of factures from the web service
        List<Facture> factures = ServiceFacture.getInstance().affichageFactures();
        
        // Create a container to hold the facture labels and the PDF buttons
        Container content = new Container();
        content.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        // Add a label and PDF button for each facture to the container
        if (factures.isEmpty()) {
            // Display a label if there are no factures to show
            content.addComponent(new Label("No factures to display"));
        } else {
            // Display a label and PDF button for each facture
            for (Facture facture : factures) {
                content.addComponent(createFactureLabel(facture));
                content.addComponent(createPDFButton(facture));
            }
        }

        // Add the container to the form's content pane
        this.addComponent(content);
    }

    private Component createFactureLabel(Facture facture) {
        // Create a label to display the facture's details
        String labelString = facture.getRefrancefacture();
        //String useremail="Votre email: "+facture.getUseremail();
        String nomproduit="Votre produit: "+facture.getNomproduit();
        String datefacture="La date de facture: "+facture.getDatefacture();
        String tva="TVA : "+facture.getTva();
        String total="le total est: "+facture.getTotale();
        String factureText = labelString + "\n" + datefacture + "\n" + nomproduit + "\n" + tva + "\n" + total;
    
        SpanLabel factureLabel = new SpanLabel(factureText);

        // Set the SpanLabel's style

        return factureLabel;
    }
    
    private Button createPDFButton(Facture facture) {
        // Create a PDF button for the given facture
        Button pdfButton = new Button("Export PDF");
        pdfButton.addActionListener((e) -> {
            // Generate the PDF for the given facture
            generatePDF(facture);
        });
        return pdfButton;
    }
private void generatePDF(Facture facture) {
    try {
        // Initialize the PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\fadhe\\OneDrive\\Bureau\\" + "facture" + facture.getRefrancefacture() + ".pdf"));
        document.open();
        
        // Add the facture details to the PDF document
        document.add(new Paragraph("Facture Details"));
        document.add(new Paragraph("Référence facture: " + facture.getRefrancefacture()));
        //document.add(new Paragraph("Votre email: " + facture.getUseremail()));
        document.add(new Paragraph("Votre produit: " + facture.getNomproduit()));
        document.add(new Paragraph("La date de facture: " + facture.getDatefacture()));
        document.add(new Paragraph("TVA: " + facture.getTva()));
        document.add(new Paragraph("Le total est: " + facture.getTotale()));
        
        // Close the PDF document
        document.close();
        
        // Show a success message
        Dialog.show("Success", "The PDF file has been downloaded to C:\\Users\\fadhe\\OneDrive\\Bureau\\" + facture.getRefrancefacture() + ".pdf", "OK", null);

    } catch (Exception e) {
        e.printStackTrace();
    }
}




}
