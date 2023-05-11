/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

public class HomeForm extends Form{
    
    
    //var

    public HomeForm() {
        
        //custom
        this.setLayout(BoxLayout.yCenter());
        this.setTitle("Home");
        
        //widgets
        Button addEventBtn = new Button("Add Event");
        Button addSessionBtn = new Button("Add Session");
        Button showTaskBtn = new Button("Show Events");
        Button showpanierBtn = new Button("Show Panier");
        Button showFactureBtn = new Button("Show Facture");

        Button signupUser=new Button("signIn");
        Button quizBtn=new Button("Quiz");
        Button addBilletBtn=new Button("ADD Panier");




        
        //actions
        addEventBtn.addActionListener((evt) -> {
           
            new AddEvent().show();
            
        });
        addSessionBtn.addActionListener((evt) -> {
           
            new AddSession().show();
            
        });
        quizBtn.addActionListener((evt) -> {
           
            new QuizHomeForm().show();
            
        });
        //..
        showTaskBtn.addActionListener((evt) -> {
            new EventList().show();
           
           
            
        });


        showpanierBtn.addActionListener((evt) -> {
            new PanierProduit().show();



        });
        showFactureBtn.addActionListener((evt) ->{
            new FactureListForm().show();
        });

        signupUser.addActionListener((evt) ->{
            new LoginForm().show();
        });

        quizBtn.addActionListener((evt) -> {
            new QuizHomeForm().show();
        });
        
        //end
        this.addAll(addEventBtn,addSessionBtn, showTaskBtn, showpanierBtn,signupUser,showFactureBtn, quizBtn);
        
    }
    
    
    
}
