package models;

import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;


public class Account {

    @Id public ObjectId id;

    public String name;
    public String email;
    public String password;

}
