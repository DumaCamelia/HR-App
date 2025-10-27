package domain.recruitment;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class HRUser {
    private String id;
    private String name;
    private String email;

    protected HRUser() {}
    public HRUser(String id, String name, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setId(String newId){
        id = newId;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }
}