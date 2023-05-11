package tha9afans.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class SideMenuForm extends Form {
    public SideMenuForm() {
        setTitle("Menu");

        // Create the main container for the side menu
        Container sideMenuContainer = BoxLayout.encloseY();

        // Add the tagline label
        sideMenuContainer.addComponent(new Label("Cool App Tagline...", "SidemenuTagline"));

        // Add menu items
        sideMenuContainer.add(createMenuItem("Home", FontImage.MATERIAL_HOME, e -> {
    // Handle Home menu item action
            new HomeForm().show(); // Replace "HomeForm" with the actual form you want to show
        }));



// Add more menu items and their corresponding actions


        sideMenuContainer.add(createMenuItem("Settings", FontImage.MATERIAL_SETTINGS, e -> {
            // Handle Settings menu item action
        }));

        sideMenuContainer.add(createMenuItem("About", FontImage.MATERIAL_INFO, e -> {
            // Handle About menu item action
        }));

        // Set custom UIID and style for the side menu container
        sideMenuContainer.setUIID("CustomSideMenuContainer");
        sideMenuContainer.getAllStyles().setBgColor(0xFF0000); // Set the background color to red
        Label labeltitle=new Label("onsss");
        // Set the layout and add the side menu container to the form
        setLayout(new BorderLayout());
        Container content = BoxLayout.encloseY(
                labeltitle,
                //imglogo,
                sideMenuContainer
        );
        content.setScrollableY(true);
        this.addAll(content);
    }

    private Button createMenuItem(String text, char icon, ActionListener listener) {
        Button menuItem = new Button(text);
        menuItem.setUIID("SideCommand");
        menuItem.setIcon(FontImage.createMaterial(icon, menuItem.getUnselectedStyle()));
        menuItem.addActionListener(listener);
        return menuItem;
    }
}
