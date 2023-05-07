package tha9afans.gui;
import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import tha9afans.services.ServiceUser;

public class LoginForm extends Form  {
    public LoginForm(){
        this.setLayout(BoxLayout.y());
        this.setTitle("SignIn");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });
        Resources theme = UIManager.initFirstTheme("/theme");
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        Button btnlogin=new Button("LogIn");
        Button mp = new Button("mot de passe oublié?");
        mp.setUIID("Label");
        /*mp.getAllStyles().setAlignment(Component.RIGHT);
        mp.getAllStyles().setMargin(2, 0,0, 5);*/



        Button signupbutton=new Button("Go Create Account");

        Label labeltitle = new Label("Sign In", "LogoLabel");
        /*labeltitle.getAllStyles().setAlignment(Component.CENTER);
        labeltitle.getAllStyles().setFgColor(0xffffff);
        Font labelFont = Font.createTrueTypeFont("native:MainLight", "native:MainLight").derive(Display.getInstance().convertToPixels(7, true), Font.STYLE_BOLD);
        labeltitle.getUnselectedStyle().setFont(labelFont);
        labeltitle.getAllStyles().setFgColor(0x001A23);
        btnlogin.getAllStyles().setBgColor(0x001A23);
        btnlogin.getAllStyles().setFgColor(0xF1FAEE);
        btnlogin.getAllStyles().setBgTransparency(255);
        btnlogin.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
        btnlogin.getAllStyles().setMargin(5, 0, 2, 2);
        btnlogin.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_DIPS);
        btnlogin.getAllStyles().setPadding(5, 5, 5, 5);
        btnlogin.getAllStyles().setAlignment(Component.CENTER);
        btnlogin.getAllStyles().setBorder(Border.createEmpty());
        btnlogin.getPressedStyle().setBgColor(0x001A23);
        btnlogin.getPressedStyle().setFgColor(0xF1FAEE);
        btnlogin.setWidth(50);*/
//        btnlogin.requestFocus();
//        //desgign for sign up button
//        signupbutton.getAllStyles().setBgColor(0x001A23);
//        signupbutton.getAllStyles().setFgColor(0xF1FAEE);
//        signupbutton.getAllStyles().setBgTransparency(255);
//        signupbutton.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
//        signupbutton.getAllStyles().setMargin(2, 5, 2, 2);
//        signupbutton.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_DIPS);
//        signupbutton.getAllStyles().setPadding(5, 5, 5, 5);
//        signupbutton.getAllStyles().setAlignment(Component.CENTER);
//        signupbutton.getAllStyles().setBorder(Border.createEmpty());
//        signupbutton.getPressedStyle().setBgColor(0x001A23);
//        signupbutton.getPressedStyle().setFgColor(0xF1FAEE);
//        signupbutton.setWidth(50);
//        signupbutton.requestFocus();
        Label doneHaveAnAccount = new Label("Vous n'avez aucune compte?");
        ImageViewer imglogo = new ImageViewer(theme.getImage("logo.png"));
        /*imglogo.setPreferredSize(new Dimension(400, 400));*/
        Container content = BoxLayout.encloseY(
                labeltitle,
                imglogo,
                new FloatingHint(email),
                new FloatingHint(password),
                btnlogin,
                signupbutton,
                mp
        );
        content.setScrollableY(true);

        btnlogin.addActionListener(e ->
        {
            ServiceUser.getInstance().signin(email , password);

        });
        signupbutton.addActionListener((evt) -> {

            new SignUpForm().show();

        });
        /*mp.addActionListener((evt) -> {

            new ForgotPassword().show();

        });*/
        this.addAll(content);
    }

}
