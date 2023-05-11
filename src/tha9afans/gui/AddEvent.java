/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.gui;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import tha9afans.entities.Evenement;
import tha9afans.services.ServiceEvenement;

/**
 *
 * @author ghazo
 */
public class AddEvent extends Form {

    //var
   ServiceEvenement se = ServiceEvenement.getInstance();

    public AddEvent() {

        //CUSTOM
        this.setLayout(BoxLayout.y());
        this.setTitle("Add Event");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();  
        });

        //Widgets
        TextComponent name = new TextComponent().labelAndHint("Name");
        TextComponent description = new TextComponent().labelAndHint("Description").multiline(true).rows(3);
        PickerComponent date = PickerComponent.createDate(null).label("Date");
        TextComponent Address = new TextComponent().labelAndHint("Address");
        PickerComponent category = PickerComponent.createStrings("art","music").label("category");
        Button submitBtn = new Button("Submit");
        String str="2015-03-31";   
        Evenement ev =new Evenement(name.getText(),description.getText(),Address.getText(),str,"music",1);
        System.out.println(ev);
        ////////////////////////////////////
        //actions
        submitBtn.addActionListener((evt) -> {
               if (se.AddEvent(ev)) {
                Dialog.show("Success", "event added successfully", "Got it", null);
            } else {
                Dialog.show("Failed", "Something Wrong! Try again", "Got it", null);
            }
        });

        //end
        this.addAll(name,category, description,Address, date,submitBtn);

    }

}
