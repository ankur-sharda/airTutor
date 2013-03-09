package models;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.annotations.Id;

import daos.Dao;

public class Session {

	@Id
	public ObjectId id;

	public Student student;

	public Tutor tutor;

	public Date startDateTime;

	public Date endDateTime;

	public ObjectId save() {

		Dao.instance().getDatabase().save(this);
		return this.id;
	}

	public static Session read(ObjectId id) {
		Datastore ds = Dao.instance().getDatabase();
		return ds.find(Session.class).field("id").equal(id).get();
	}

	public static Session read(String id) {
		Datastore ds = Dao.instance().getDatabase();
		return ds.find(Session.class).field("id").equal(id).get();
	}

	public static void deleteAll() {
		Datastore ds = Dao.instance().getDatabase();
		ds.delete(ds.createQuery(Session.class));
	}

	public static List<Session> listAll() {
		Datastore ds = Dao.instance().getDatabase();
		return ds.createQuery(Session.class).order("-id").asList();
	}
}
