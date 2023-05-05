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

/**
 *
 * @author ghazo
 */
public class AddSession extends Form {

    //var
   

    public AddSession() {

        //CUSTOM
        this.setLayout(BoxLayout.y());
        this.setTitle("Add Session");
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
            new HomeForm().showBack();  
        });

        //Widgets
        TextComponent name = new TextComponent().labelAndHint("title");
        TextComponent Host = new TextComponent().labelAndHint("Host");
        TextComponent description = new TextComponent().labelAndHint("Description").multiline(true).rows(3);
        PickerComponent sdate = PickerComponent.createTime(0).label("Start");
        PickerComponent edate = PickerComponent.createTime(0).label("End");
        Button submitBtn = new Button("Submit");
        
        //actions
        submitBtn.addActionListener((evt) -> {
           
                Dialog.show("Failed", "Something Wrong! Try again", "Got it", null);
            
        });

        //end
        this.addAll(name, description,Host, sdate ,edate,submitBtn);

    }

}

