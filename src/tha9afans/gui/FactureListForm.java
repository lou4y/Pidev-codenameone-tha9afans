package tha9afans.gui;

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
        Label factureLabel = new Label(labelString);

        // Set the label's style

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
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\bla9_\\Desktop\\web\\" + facture.getRefrancefacture() + ".pdf"));
            document.open();

            // Add the facture details to the PDF document
            Paragraph paragraph = new Paragraph("Facture Details");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(new Paragraph("Référence facture: " + facture.getRefrancefacture()));
            document.add(new Paragraph("TVA: " + facture.getTva()));

            // Close the PDF document
            document.close();

            // Show a success message
            Dialog.show("Success", "The PDF file has been downloaded to C:\\Users\\bla9_\\Desktop\\web\\" + facture.getRefrancefacture() + ".pdf", "OK", null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
