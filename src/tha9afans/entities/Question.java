/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.entities;

import java.io.InputStream;

/**
 *
 * @author mohamed
 */
public class Question {

    private int question_id;
    private String question;
    private String first_possible_answer;
    private String second_possible_answer;
    private String third_possible_answer;
    private String right_answer;
    private InputStream question_image;
    private int timer;

    public Question() {
    }

    public Question(String question, String right_answer , int timer,  String first_possible_answer, String second_possible_answer, String third_possible_answer, InputStream question_image) {
        this.question = question;
        this.first_possible_answer = first_possible_answer;
        this.second_possible_answer = second_possible_answer;
        this.third_possible_answer = third_possible_answer;
        this.right_answer = right_answer;
        this.timer = timer;
        this.question_image = question_image;
    }

    public Question(int question_id, String question, String right_answer , int timer,  String first_possible_answer, String second_possible_answer, String third_possible_answer, InputStream question_image) {
        this.question_id = question_id;
        this.question = question;
        this.first_possible_answer = first_possible_answer;
        this.second_possible_answer = second_possible_answer;
        this.third_possible_answer = third_possible_answer;
        this.right_answer = right_answer;
        this.timer = timer;
        this.question_image = question_image;

    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirst_possible_answer() {
        return first_possible_answer;
    }

    public void setFirst_possible_answer(String first_possible_answer) {
        this.first_possible_answer = first_possible_answer;
    }

    public String getSecond_possible_answer() {
        return second_possible_answer;
    }

    public void setSecond_possible_answer(String second_possible_answer) {
        this.second_possible_answer = second_possible_answer;
    }

    public String getThird_possible_answer() {
        return third_possible_answer;
    }

    public void setThird_possible_answer(String third_possible_answer) {
        this.third_possible_answer = third_possible_answer;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public InputStream getQuestion_image() {
        return question_image;
    }

    public void setQuestion_image(InputStream question_image) {
        this.question_image = question_image;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    
}
