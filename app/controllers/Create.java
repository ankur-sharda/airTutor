package controllers;

import models.Student;
import models.Tutor;

import org.bson.types.ObjectId;

import play.mvc.Controller;
import utils.p;

public class Create extends Controller{

	public static void student(Student student) {
		ObjectId id = student.save();

		Views.student(student);
	}

	public static void tutor(Tutor tutor) {
		ObjectId id = tutor.save();
		
p.rint(tutor.email);
p.rint(tutor.name);
p.rint(tutor.password);

		Views.tutor(tutor);
	}

}
