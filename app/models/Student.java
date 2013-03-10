package models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.annotations.Id;

import daos.Dao;
import utils.p;

public class Student {

	@Id
	public ObjectId id;

	public String name;
	public String email;
	public String password;
	public List<String> tutorKeys = new ArrayList<String>();

	public ObjectId save() {

		if ((this.name.length() > 0) && (this.email.length() > 0) && (this.password.length() > 0)
				&& (read(this.email) == null)) {
			Dao.instance().getDatabase().save(this);
			return this.id;
		} else {
			return null;
		}
	}

	public static Student read(ObjectId id) {
		Datastore ds = Dao.instance().getDatabase();
		return ds.find(Student.class).field("id").equal(id).get();
	}

	public static Student read(String email) {
		Datastore ds = Dao.instance().getDatabase();
		return ds.find(Student.class).field("email").equal(email).get();
	}

	public static void deleteAll() {
		Datastore ds = Dao.instance().getDatabase();
		ds.delete(ds.createQuery(Student.class));
	}

	public void delete() {
		Datastore ds = Dao.instance().getDatabase();
		ds.delete(ds.createQuery(Student.class).field("email").equal(email));
	}

	public static List<Student> listAll() {
		Datastore ds = Dao.instance().getDatabase();
		return ds.createQuery(Student.class).order("-id").asList();
	}

	public static Student login(String em, String pa) {
		Datastore ds = Dao.instance().getDatabase();
		Student student = ds.find(Student.class).field("email").equal(em).field("password").equal(pa).get();
        if(student!=null){
            return student;
        }
        else{
p.rint("student is null");
            return null;
        }
	}


}