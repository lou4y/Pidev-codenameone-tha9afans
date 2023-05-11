package tha9afans.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.plaf.Style;
import tha9afans.services.ServiceUser;
import com.codename1.ui.Component;
import com.codename1.ui.plaf.Border;

import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class EditUser extends Form {
    public EditUser() {
        this.setLayout(BoxLayout.y());
        this.setTitle("Modifier votre profile");
        Resources theme = UIManager.initFirstTheme("/theme");
        ImageViewer imglogo = new ImageViewer(theme.getImage("logo.png"));
        imglogo.setPreferredSize(new Dimension(300, 300));
        Toolbar tb = this.getToolbar();
        //Image icon = theme.getImage("icon.png");
        Label labeltha9afans=new Label("Tha9afans");
        labeltha9afans.getAllStyles().setAlignment(Component.CENTER);
        labeltha9afans.getAllStyles().setFgColor(0xffffff);
        Container topBar = BorderLayout.east(labeltha9afans);
        //topBar.add(BorderLayout.SOUTH, labeltha9afans);
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar); 
        Container sideMenuContainer = BorderLayout.center(new Label());
        sideMenuContainer.setUIID("SideCommand");
        sideMenuContainer.add(BorderLayout.NORTH, imglogo);
       // Set the preferred height to 1 pixel

        // Add the separator to the side menu container
        //sideMenuContainer.add(separator);

        // Add the menu items (Home, Produit, Evenement)

        // Create the separator component
        
        tb.addComponentToSideMenu(sideMenuContainer);

        tb.addMaterialCommandToSideMenu("Evenement", FontImage.MATERIAL_HOME, e -> {
                new EventList().show();
        }); 
        //sideMenuContainer.add(separator);
        tb.addMaterialCommandToSideMenu("Billet", FontImage.MATERIAL_WEB, e -> {});
        tb.addMaterialCommandToSideMenu("Produit", FontImage.MATERIAL_SHOPPING_BAG, e -> {
        // Add your logic for the "Produit" menu item here
        });

        tb.addMaterialCommandToSideMenu("Facture", FontImage.MATERIAL_INFO, e -> {
            new FactureListForm().show();
        });
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_PERSON, e -> {
                 new EditUser().show();
        });

        tb.addMaterialCommandToSideMenu("Quiz", FontImage.MATERIAL_GAMEPAD, e -> {
           
                new QuizHomeForm().show();
        });
        tb.addMaterialCommandToSideMenu("Déconnecter", FontImage.MATERIAL_EXIT_TO_APP, e -> {
            ServiceUser.getInstance().deconnecter();
        // Add your logout logic here
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
        ImageViewer imguser = new ImageViewer(theme.getImage("user.png"));
        imguser.setPreferredSize(new Dimension(350, 350));

        Button modifuserbutton = new Button("Modifier profile");

        modifuserbutton.getAllStyles().setBgColor(0x001A23);
        modifuserbutton.getAllStyles().setFgColor(0xF1FAEE);
        modifuserbutton.getAllStyles().setBgTransparency(255);
        modifuserbutton.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
        modifuserbutton.getAllStyles().setMargin(5, 0, 2, 2);
        modifuserbutton.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_DIPS);
        modifuserbutton.getAllStyles().setPadding(5, 5, 5, 5);
        modifuserbutton.getAllStyles().setAlignment(Component.CENTER);
        modifuserbutton.getAllStyles().setBorder(Border.createEmpty());
        modifuserbutton.getPressedStyle().setBgColor(0x001A23);
        modifuserbutton.getPressedStyle().setFgColor(0xF1FAEE);
        modifuserbutton.setWidth(50);
        modifuserbutton.requestFocus();
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
                imguser,
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
