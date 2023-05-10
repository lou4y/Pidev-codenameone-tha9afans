/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tha9afans.services;

import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
//import com.codename1.util.Base64;
import tha9afans.entities.Quiz;
import tha9afans.utilities.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceQuizHome {

    public static ServiceQuizHome instance = null;
    private ConnectionRequest req;

    public static ServiceQuizHome getInstance(){
        if(instance == null){
            instance = new ServiceQuizHome();
        }
        return instance;
    }

    public ServiceQuizHome(){
        req = new ConnectionRequest();
        req.setInsecure(true);
    }

    public ArrayList<Quiz> getAllQuizzes () {
    ArrayList<Quiz> result = new ArrayList<>();
    String url = Statics.BASE_URL+"/apiquiz";
    req.setUrl(url);

    req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent networkEvent) {
            JSONParser jsonParser = new JSONParser();
            try {
                Map<String, Object> mapQuizzes = jsonParser.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapQuizzes.get("root");

                for (Map<String, Object> obj : listOfMaps) {
                    Quiz quiz = new Quiz();

                    float id = Float.parseFloat(obj.get("id").toString());
                    String name = obj.get("name").toString();
                    String description = obj.get("description").toString();
//                    String imageData = obj.get("image").toString();
//                    byte[] decodedImage = Base64.getDecoder().decode(imageData);
                    float numberOfQuestions = Float.parseFloat(obj.get("numberOfQuestions").toString());

                    quiz.setQuiz_id((int) id);
                    quiz.setQuiz_name(name);
                    quiz.setQuiz_description(description);
//                    quiz.setQuiz_cover(decodedImage);
                    quiz.setNumber_of_questions((int) numberOfQuestions);

                    result.add(quiz);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } }) ;
    NetworkManager.getInstance().addToQueueAndWait(req);
    return result;
}
    }
