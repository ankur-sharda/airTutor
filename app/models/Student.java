package models;

import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;


import java.util.List;


public class Student {

    @Id
    public ObjectId id;

    public List<Tutor> tutors;

}
