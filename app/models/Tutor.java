package models;

import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.annotations.Id;

import daos.Dao;

import org.bson.types.ObjectId;

import utils.*;

public class Tutor {

	@Id
	public ObjectId id;

	public double rate;
	public String name;
	public String email;
	public String password;
    public String key;
    public String mobile;

	public ObjectId save() {

		if ((this.name.length() > 0) && (this.email.length() > 0)
				&& (this.password.length() > 0) && (read(this.email) == null)) {
			Dao.instance().getDatabase().save(this);
			return this.id;
		} else {
			return null;
		}
	}

	public static Tutor read(ObjectId id) {
		Datastore ds = Dao.instance().getDatabase();
		return ds.find(Tutor.class).field("id").equal(id).get();
	}

	public static Tutor read(String key) {
		Datastore ds = Dao.instance().getDatabase();
		return ds.find(Tutor.class).field("key").equal(key).get();
	}

	public static void deleteAll() {
		Datastore ds = Dao.instance().getDatabase();
		ds.delete(ds.createQuery(Tutor.class));
	}

	public void delete() {
		Datastore ds = Dao.instance().getDatabase();
		ds.delete(ds.createQuery(Tutor.class).field("email").equal(email));
	}

	public static List<Tutor> listAll() {
		Datastore ds = Dao.instance().getDatabase();
		return ds.createQuery(Tutor.class).order("-id").asList();
	}

	public static Tutor login(String em, String pa) {
		Datastore ds = Dao.instance().getDatabase();
		Tutor tutor = ds.find(Tutor.class).field("email").equal(em)
				.field("password").equal(pa).get();
		if (tutor != null) {
		p.rint("tutor IS NOT null");	
			return tutor;
		} else {
		p.rint("tutor IS null");
			return null;
		}
	}

}
