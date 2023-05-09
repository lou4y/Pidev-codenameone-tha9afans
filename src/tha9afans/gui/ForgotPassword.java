package tha9afans.gui;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.Resources;
import com.sun.mail.smtp.SMTPTransport;
import tha9afans.services.ServiceUser;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPassword extends Form {
    TextField email;
    public ForgotPassword(){
        Resources theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        this.setTitle("Reset Password");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();
        });
        ImageViewer imglogo = new ImageViewer(theme.getImage("password.png"));
        /*imglogo.setPreferredSize(new Dimension(400, 400));*/
        Label labeltitle = new Label("Mot de passe oublié?", "LogoLabel");
        /*labeltitle.getAllStyles().setAlignment(Component.CENTER);
        labeltitle.getAllStyles().setFgColor(0xffffff);*/
        Font labelFont = Font.createTrueTypeFont("native:MainLight", "native:MainLight").derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_BOLD);
        /*labeltitle.getUnselectedStyle().setFont(labelFont);
        labeltitle.getAllStyles().setFgColor(0x001A23);*/
        email = new TextField("", "Saisir votre adresse email", 20, TextField.EMAILADDR);
        Button envoiemail=new Button("envoyer un email");
        envoiemail.getAllStyles().setBgColor(0x001A23);
        envoiemail.getAllStyles().setFgColor(0xF1FAEE);
        envoiemail.getAllStyles().setBgTransparency(255);
        envoiemail.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
        envoiemail.getAllStyles().setMargin(2, 5, 0, 0);
        envoiemail.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_DIPS);
        envoiemail.getAllStyles().setPadding(5, 5, 5, 5);
        envoiemail.getAllStyles().setAlignment(Component.CENTER);
        envoiemail.getAllStyles().setBorder(Border.createEmpty());
        envoiemail.getPressedStyle().setBgColor(0x001A23);
        envoiemail.getPressedStyle().setFgColor(0xF1FAEE);
        envoiemail.setWidth(50);
        envoiemail.requestFocus();
        envoiemail.addActionListener(e -> {

            InfiniteProgress ip = new InfiniteProgress();

            final Dialog ipDialog =  ip.showInfiniteBlocking();
            sendMail();
            ipDialog.dispose();
            Dialog.show("Mot de passe","Nous avons envoyé le mot de passe a votre e-mail. Veuillez vérifier votre boite de réception",new Command("OK"));
            new LoginForm().show();

        });
        Container content = BoxLayout.encloseY(
                labeltitle,
                imglogo,
                new FloatingHint(email),
                envoiemail
        );
        content.setScrollableY(true);
        this.addAll(content);

    }
    //sendMail

    public void sendMail() {
        try {

            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp"); //SMTP protocol
            props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtps.auth", "true"); //enable authentication

            Session session = Session.getInstance(props,null); // aleh 9rahach 5ater mazlna masabinach javax.mail .jar


            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress("Reintialisation mot de passe <monEmail@domaine.com>"));
            msg.setRecipients(Message.RecipientType.TO, email.getText().toString());
            msg.setSubject("Application nom  : Confirmation du ");
            msg.setSentDate(new Date(System.currentTimeMillis()));

            String mp = ServiceUser.getInstance().getPasswordByEmail(email.getText().toString());
            String txt = "Bienvenue sur AppNom : Tapez ce mot de passe : "+mp+" dans le champs requis et appuiez sur confirmer";


            msg.setText(txt);

            SMTPTransport  st = (SMTPTransport)session.getTransport("smtps") ;

            st.connect("smtp.gmail.com",465,"fadhel.ons@esprit.tn","223AFT1600");

            st.sendMessage(msg, msg.getAllRecipients());

            System.out.println("server response : "+st.getLastServerResponse());

        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
}
