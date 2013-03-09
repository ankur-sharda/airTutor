package controllers;

import models.Student;
import models.Tutor;
import play.mvc.Controller;
import utils.*;

public class Do extends Controller {

	public static void login(String email, String password) {
		Student student = new Student();
		if (student.login(email, password) != null) {
p.rint(email+" - "+password);
			session.put("loggedIn", "true");
			session.put("accountName", "STUDENT");
			 Views.student(student);
		} else {
			Tutor tutor = new Tutor();
			if (tutor.login(email, password) != null) {
p.rint(email+" - "+password);
				session.put("loggedIn", "true");
				session.put("accountName", Constants.TUTOR);
p.rint(tutor.name);
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
