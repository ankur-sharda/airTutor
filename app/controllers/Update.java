package controllers;

import models.Student;
import models.Tutor;
import org.bson.types.ObjectId;
import play.mvc.Controller;

import java.util.ArrayList;


public class Update extends Controller{

    public static void addtutor(String email, String key){

        Student s = Student.read(email);
        if(s.tutorKeys==null){
            s.tutorKeys = new ArrayList<String>();
        }

        s.tutorKeys.add(key);
        s.save();

        Views.student(s);
    }

}
