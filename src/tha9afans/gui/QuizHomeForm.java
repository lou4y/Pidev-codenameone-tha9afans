/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import tha9afans.entities.Quiz;
import tha9afans.services.ServiceQuizHome;

import java.util.ArrayList;

public class QuizHomeForm extends Form {
    

    private Resources theme;
    private ArrayList<Quiz> quizzes;

    public QuizHomeForm() {
        super(new BorderLayout());
        this.setTitle("Quiz Home");
        theme = UIManager.initFirstTheme("/theme");

        quizzes = ServiceQuizHome.getInstance().getAllQuizzes();

        // Create a container for the quiz list
        // Create a container for the quiz list
        Container quizListContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        quizListContainer.setScrollableY(true);

        // Loop through the quizzes and add each one to the list container
        for (Quiz quiz : quizzes) {
            Container quizContainer = new Container(new BorderLayout());

            // Create a card-like container for the quiz information
            Container quizInfoContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            quizInfoContainer.getStyle().setBgColor(0xffffff); // set background color
            quizInfoContainer.getStyle().setPadding(10, 10, 10, 10); // add padding

            // Display the quiz name and description
            Label quizNameLabel = new Label(quiz.getQuiz_name(), "BoldLabel");
            Label quizDescriptionLabel = new Label(quiz.getQuiz_description(), "SmallLabel");
            Label quizNumberOfQuestionsLabel = new Label(quiz.getNumber_of_questions() + " questions", "SmallLabel");

            quizInfoContainer.add(quizNameLabel);
            quizInfoContainer.add(quizDescriptionLabel);
            quizInfoContainer.add(quizNumberOfQuestionsLabel);

        //    // Display the quiz cover image
        //    ImageViewer quizCoverImageViewer = new ImageViewer(theme.getImage("quiz_cover.png"));
        //    quizCoverImageViewer.setPreferredH(100);
        //    quizCoverImageViewer.setPreferredW(100);

            // Add the quiz information container and cover image to the quiz container
            quizContainer.add(BorderLayout.CENTER, quizInfoContainer);
        //    quizContainer.add(BorderLayout.WEST, quizCoverImageViewer);

            // Add the quiz container to the list container
            quizListContainer.add(quizContainer);
        }

        // Add the quiz list container to the form
        add(BorderLayout.CENTER, quizListContainer);
       //this is a show method
        show();

    }
}
