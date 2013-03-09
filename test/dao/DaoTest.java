package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.code.morphia.Datastore;

import daos.Dao;

public class DaoTest {
	
	@Test
	public void testDao(){
		Datastore ds = Dao.instance().getDatabase();
		assertNotNull(ds);
	}

}
