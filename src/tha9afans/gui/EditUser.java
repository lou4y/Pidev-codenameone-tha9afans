package tha9afans.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.services.ServiceUser;

import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class EditUser extends Form {
    public EditUser() {
        this.setLayout(BoxLayout.y());
        this.setTitle("Modifier votre profile");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });
        TextField nom = new TextField("", "nom", 20, TextField.ANY);
        TextField prenom = new TextField("", "prenom", 20, TextField.ANY);
        TextField cin = new TextField("", "cin", 20, TextField.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField adresse=new TextField("","adresse",20, TextField.ANY);
        TextField telephone=new TextField("","telephone",20, TextField.ANY);
        //Vector 3ibara ala array 7atit fiha roles ta3na ba3d nzidouhom lel comboBox
        Vector<String> vectorGenre;
        vectorGenre = new Vector();
        vectorGenre.add("homme");
        vectorGenre.add("femme");
        vectorGenre.add("autre");

        ComboBox<String> genre = new ComboBox<>(vectorGenre);

        nom.setText(SessionManager.getNom());
        prenom.setText(SessionManager.getPrenom());

        cin.setText(SessionManager.getCin());
        email.setText(SessionManager.getEmail());
        adresse.setText(SessionManager.getAdresse());
        telephone.setText(SessionManager.getTelephone());

        nom.setSingleLineTextArea(false);
        prenom.setSingleLineTextArea(false);
        cin.setSingleLineTextArea(false);
        email.setSingleLineTextArea(false);
        adresse.setSingleLineTextArea(false);
        telephone.setSingleLineTextArea(false);

        Button modifuserbutton = new Button("Modifier profile");

        //signup.getAllStyles().setFgColor(0xF1FAEE);
//        signup.getAllStyles().setBgTransparency(255);
//        signup.getAllStyles().setAlignment(Component.CENTER);
//        signup.getAllStyles().setBorder(Border.createEmpty())
//        signup.getPressedStyle().setBgColor(0x001A23);
//        signup.getPressedStyle().setFgColor(0xF1FAEE);
//        signup.setWidth(50);
//        signup.requestFocus();
        int id=SessionManager.getId();
        modifuserbutton.addActionListener((e) -> {
            try {
                ServiceUser.getInstance().editUser(id,nom,prenom,cin,email,genre,adresse,telephone);
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }
            Dialog.show("Succes","Utilisateur modifie avec succes","OK",null);
        });
        /*ImageViewer imglogo = new ImageViewer(this.getImage("logo.png"));
        imglogo.setPreferredSize(new Dimension(400, 400));*/

        Label labeltitle = new Label("Modifier votre profile", "LogoLabel");
        /*labeltitle.getAllStyles().setAlignment(Component.CENTER);
        labeltitle.getAllStyles().setFgColor(0xffffff);
        Font labelFont = Font.createTrueTypeFont("native:MainLight", "native:MainLight").derive(Display.getInstance().convertToPixels(7, true), Font.STYLE_BOLD);
        labeltitle.getUnselectedStyle().setFont(labelFont);
        labeltitle.getAllStyles().setFgColor(0x001A23);*/
        Container content = BoxLayout.encloseY(
                labeltitle,
                //imglogo,
                new FloatingHint(cin),
                new FloatingHint(nom),
                new FloatingHint(prenom),
                new FloatingHint(email),
                new FloatingHint(adresse),
                new FloatingHint(telephone),
                genre,
                modifuserbutton
        );
        content.setScrollableY(true);
        this.addAll(content);

    }
}
