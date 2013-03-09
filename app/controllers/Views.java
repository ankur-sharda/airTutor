package controllers;

import models.Student;
import models.Tutor;
import play.mvc.Controller;



public class Views extends Controller {
	
	 public static void student(Student student) {
	        render(student);
	    }

    public static void tutor(Tutor tutor){
        render(tutor);
    }

    public static void session(){
         render();
    }


}
