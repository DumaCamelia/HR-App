package domain.recruitment;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class HRUser {
    private int id;
    private String name;
    private String email;

    protected HRUser() {}

    public HRUser(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }


    public void setId(int newId){
        id = newId;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }


    public void scheduleInterview(Candidate candidate, ZonedDateTime time){
        candidate.scheduleInterviewCandidate();
    }
}