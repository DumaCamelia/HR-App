package domain.recruitment;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Data
public class HRUser {
    private int id;
    private String name;
    private String email;

    public HRUser(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public void scheduleInterview(Candidate candidate, ZonedDateTime time){
        candidate.scheduleInterviewCandidate();
    }
}