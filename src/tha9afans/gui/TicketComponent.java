package tha9afans.gui;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.entities.Ticket;
import com.codename1.ui.Image;
import com.codename1.ui.Label;



public class TicketComponent extends Container {

    public TicketComponent(Ticket ticket)  {
//        String text = String.valueOf(ticket.getCode()); // The text to encode in the QR code
//        int size = 256; // The size of the QR code image
//        QRCodeWriter qrWriter = new QRCodeWriter();
//        BitMatrix bitMatrix;
//        try {
//            bitMatrix = qrWriter.encode(text, BarcodeFormat.QR_CODE, size, size);
//        } catch (WriterException ex) {
//            // Handle the exception
//            return;
//        }
//// Convert the bit matrix to an image
//        int matrixWidth = bitMatrix.getWidth();
//        int matrixHeight = bitMatrix.getHeight();
//        int[] pixels = new int[matrixWidth * matrixHeight];
//        for (int y = 0; y < matrixHeight; y++) {
//            int offset = y * matrixWidth;
//            for (int x = 0; x < matrixWidth; x++) {
//                pixels[offset + x] = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
//            }
//        }
//        Image image = Image.createImage(pixels, matrixWidth, matrixHeight);
//        Label label = new Label(image);
//        this.add(label);


        // TODO  QR CODE


        this.setLayout(BoxLayout.y());
        Image studentIcon = FontImage.createMaterial(FontImage.MATERIAL_NOTIFICATIONS_ON, "Checkbox student", 4.0f);
        this.add(studentIcon);
        Label nomELabel = new Label(ticket.getNomE());
        Label nomCLabel = new Label(ticket.getNomC());
        Label adresseLabel = new Label(ticket.getAdresse());
        Label prixLabel = new Label(String.valueOf(ticket.getPrix()));
        Label dateLabel = new Label(ticket.getDate());
        Label typeLabel = new Label(ticket.getType());
        Label nbrBilletAvailableLabel = new Label("Nombre de place disp : "+String.valueOf(ticket.getNbrBilletAvailable()));
        this.addAll(nomELabel, nomCLabel, adresseLabel, prixLabel, dateLabel, typeLabel, nbrBilletAvailableLabel);
    }
}

