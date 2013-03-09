package models;

import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;


public class Tutor {

    @Id
    public ObjectId id;

    public double rate;

}
