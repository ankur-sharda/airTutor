package controllers;

import models.Student;
import models.Tutor;
import play.mvc.Controller;
import utils.p;

import java.util.ArrayList;
import java.util.List;

public class Views extends Controller {

    public static void student(Student student) {
        List<Tutor> tutors = new ArrayList<Tutor>();
        for(String key:student.tutorKeys){
            Tutor t = Tutor.read(key);
            tutors.add(t);
        }

        render(student, tutors);
    }

    public static void tutor(Tutor tutor){
        render(tutor);
    }

    public static void session(){
        render();
    }

    public static void sessionWithWhiteboard(){
        render();
    }

    public static void VideoChat(){
        render();
    }


}
