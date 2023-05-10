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
        Button quizBtn = new Button ("Quiz");
        
        //actions
        addEventBtn.addActionListener((evt) -> {
           
            new AddEvent().show();
            
        });
        addSessionBtn.addActionListener((evt) -> {
           
            new AddSession().show();
            
        });
        //..
        showTaskBtn.addActionListener((evt) -> {
            new EventList().show(); 
        });
        
        quizBtn.addActionListener((evt) -> {
            new QuizHomeForm().show();
        });
        
        //end
        this.addAll(addEventBtn,addSessionBtn, showTaskBtn, quizBtn);
        
    }
    
    
    
}
