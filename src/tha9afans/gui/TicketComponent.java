package tha9afans.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.google.zxing.EncodeHintType;
import tha9afans.entities.Ticket;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TicketComponent extends Container {



    public TicketComponent(Ticket ticket) {
//        String qrCodeText = ticket.getCode();
//        System.out.println("QR Code text: " + qrCodeText);
//        Map<EncodeHintType, Object> hints = new HashMap<>();
//        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//        try {
//            QRCodeWriter writer = new QRCodeWriter();
//            BitMatrix bitMatrix = writer.encode(qrCodeText, BarcodeFormat.QR_CODE, 512, 512, hints);
//            int width = bitMatrix.getWidth();
//            int height = bitMatrix.getHeight();
//            byte[] pixels = new byte[width * height];
//            System.out.println("Pixel data: " + Arrays.toString(pixels));
//            for (int y = 0; y < height; y++) {
//                int offset = y * width;
//                for (int x = 0; x < width; x++) {
//                    pixels[offset + x] = (byte) (bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
//                }
//            }
//            EncodedImage image = EncodedImage.create(pixels);
//            System.out.println("Image dimensions: " + image.getWidth() + "x" + image.getHeight());
//            Image scaledImage = image.scaled(50, 50);
//            ImageViewer qrCodeImageViewer = new ImageViewer(scaledImage);
//            this.add(qrCodeImageViewer);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//
//        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        this.setLayout(BoxLayout.y());
        Image studentIcon = FontImage.createMaterial(FontImage.MATERIAL_NOTIFICATIONS_ON, "Checkbox student", 4.0f);
        this.add(studentIcon);
        Label nomELabel = new Label(ticket.getNomE());
        Label nomCLabel = new Label(ticket.getNomC());
        Label adresseLabel = new Label(ticket.getAdresse());
        Label codeLabel = new Label(ticket.getCode());
        Label prixLabel = new Label(String.valueOf(ticket.getPrix()));
        Label dateLabel = new Label(ticket.getDate());
        Label typeLabel = new Label(ticket.getType());
        Label nbrBilletAvailableLabel = new Label("Nombre de place disp : "+String.valueOf(ticket.getNbrBilletAvailable()));
        this.addAll(nomELabel, nomCLabel, adresseLabel, codeLabel, prixLabel, dateLabel, typeLabel, nbrBilletAvailableLabel);
    }
}

