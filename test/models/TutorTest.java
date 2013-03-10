package models;


import org.bson.types.ObjectId;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 10/03/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class TutorTest {

    @Test
    public void testTutor(){

        Tutor t = Tutor.read("bruccsie");

        assertNotNull(t);

    }
}
