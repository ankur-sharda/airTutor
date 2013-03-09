package daos;

import models.Session;
import models.Student;
import models.Tutor;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class Dao {

	private static final Dao INSTANCE = new Dao();

	private final Datastore datastore;
	public static final String DB_NAME = "dev.airtutor";

	private Dao() {
		try {
			String mongoUriStr = "mongodb://heroku:1a7b8e53693a09702d8450aeacf59f76@linus.mongohq.com:10073/app13081503";

			Mongo mongo;
			final MongoURI mongoUri = new MongoURI(mongoUriStr);
			mongo = new Mongo(mongoUri);
			datastore = new Morphia()
					.map(Session.class)
					.map(Student.class)
					.map(Tutor.class)
					.createDatastore(mongo, mongoUri.getDatabase(),
							mongoUri.getUsername(), mongoUri.getPassword());
			datastore.ensureIndexes();
		} catch (Exception e) {
			throw new RuntimeException("Error initializing MongoDB", e);
		}
	}

	public static Dao instance() {
		return INSTANCE;
	}

	public Datastore getDatabase() {
		return datastore;
	}
}