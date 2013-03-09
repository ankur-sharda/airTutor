package controllers;

import models.Student;
import models.Tutor;
import play.mvc.Controller;
import utils.*;

public class Do extends Controller {

	public static void login(String email, String password) {
		Student student = new Student();

        Tutor tutor = new Tutor();
        if ((student = student.login(email, password))!=null) {
            session.put("loggedIn", "true");
			session.put("accountName", "STUDENT");
			Views.student(student);
		} else {
        if ((tutor = tutor.login(email, password)) != null) {
		    session.put("loggedIn", "true");
			session.put("accountName", Constants.TUTOR);
			Views.tutor(tutor);
		} else {
			Application.index();
		    }
	    }
    }


	public static void logout() {
p.rint(session.get("accountName"));
		session.remove("loggedIn");
		session.remove("accountName");

		Application.index();
	}

}
