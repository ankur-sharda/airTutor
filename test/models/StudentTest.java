package models;

import org.bson.types.ObjectId;
import org.junit.*;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testLogin(){
        Student s = Student.login("leo@hotmail.com","boohoo");
        assertNotNull(s.email);
        assertNotNull(s.email);
        assertNotNull(s.email);
        assertNotNull(s.email);    }

    @Test
    public void testReadById(){
        Student s = Student.read(new ObjectId("513b25917257733d08a92eaa"));
        assertNotNull(s);
    }
}
