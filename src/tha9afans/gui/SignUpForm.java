package tha9afans.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources; 
import com.codename1.ui.FontImage;
import com.codename1.ui.Component;
import tha9afans.services.ServiceUser;

import java.util.Vector;

public class SignUpForm extends Form{

    public SignUpForm() {
        this.setLayout(BoxLayout.y());
        this.setTitle("SignUp");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });
        TextField nom = new TextField("", "nom", 20, TextField.ANY);
        TextField prenom = new TextField("", "prenom", 20, TextField.ANY);
        TextField cin = new TextField("", "cin", 20, TextField.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        TextField confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
        TextField adresse=new TextField("","adresse",20, TextField.ANY);
        TextField telephone=new TextField("","telephone",20, TextField.ANY);
        //Role
        //Vector 3ibara ala array 7atit fiha roles ta3na ba3d nzidouhom lel comboBox
        Vector<String> vectorGenre;
        vectorGenre = new Vector();

        vectorGenre.add("homme");
        vectorGenre.add("femme");
        vectorGenre.add("autre");

        ComboBox<String>genre = new ComboBox<>(vectorGenre);




        nom.setSingleLineTextArea(false);
        prenom.setSingleLineTextArea(false);
        cin.setSingleLineTextArea(false);
        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        confirmPassword.setSingleLineTextArea(false);
        adresse.setSingleLineTextArea(false);
        telephone.setSingleLineTextArea(false);

        //signIn.addActionListener(e -> new SignInForm(res).show());
        //signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        Button signup = new Button("Sign Up");

        //signup.getAllStyles().setFgColor(0xF1FAEE);
//        signup.getAllStyles().setBgTransparency(255);
//        signup.getAllStyles().setAlignment(Component.CENTER);
//        signup.getAllStyles().setBorder(Border.createEmpty())
//        signup.getPressedStyle().setBgColor(0x001A23);
//        signup.getPressedStyle().setFgColor(0xF1FAEE);
//        signup.setWidth(50);
//        signup.requestFocus();
        signup.addActionListener((e) -> {
            ServiceUser.getInstance().signup(nom,prenom,cin, password, email, confirmPassword, genre,adresse,telephone);
            Dialog.show("Success","account is saved","OK",null);
            //new SignInForm(res).show();
        });
        /*ImageViewer imglogo = new ImageViewer(this.getImage("logo.png"));
        imglogo.setPreferredSize(new Dimension(400, 400));*/

        Label labeltitle = new Label("Sign Up", "LogoLabel");
        /*labeltitle.getAllStyles().setAlignment(Component.CENTER);
        labeltitle.getAllStyles().setFgColor(0xffffff);
        Font labelFont = Font.createTrueTypeFont("native:MainLight", "native:MainLight").derive(Display.getInstance().convertToPixels(7, true), Font.STYLE_BOLD);
        labeltitle.getUnselectedStyle().setFont(labelFont);
        labeltitle.getAllStyles().setFgColor(0x001A23);*/



        Container content = BoxLayout.encloseY(
                labeltitle,
                //imglogo,
                new FloatingHint(nom),
                new FloatingHint(prenom),
                new FloatingHint(email),
                new FloatingHint(cin),
                new FloatingHint(password),
                new FloatingHint(adresse),
                new FloatingHint(telephone),
                genre,
                signup
        );
        content.setScrollableY(true);
        this.addAll(content);


    }
}
