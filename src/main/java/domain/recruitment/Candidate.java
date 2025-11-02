package domain.recruitment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class Candidate {
    @Id
    private int id;
    private String name;
    private String email;
    private String phone;
    private String cvFile;
    private CandidateStatus status;

    public Candidate(int id, String name, String email, String phone, String cvFile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cvFile = cvFile;
        this.status = CandidateStatus.CREATED;
        LocalDateTime createdAt = LocalDateTime.now();
    }

    public boolean applyCandidate(){
        if(id == 0 || name.isEmpty() || email.isEmpty() || phone.isEmpty() || cvFile == null){
            System.out.println("Candidate's data is incomplete!");
            return false;
        }
        status = CandidateStatus.APPLIED;
        LocalDateTime appliedAt = LocalDateTime.now();
        return true;
    }

    public boolean scheduleInterviewCandidate(){
        if(status != CandidateStatus.APPLIED){
            System.out.println("Candidate's status must be APPLIED!");
            return false;
        }
        status = CandidateStatus.INTERVIEWED;
        return true;
    }

    public boolean hireCandidate(){
        if(status != CandidateStatus.INTERVIEWED){
            System.out.println("Candidate's status must be INTERVIEWED!");
            return false;
        }
        status = CandidateStatus.HIRED;
        return true;
    }

    public boolean rejectCandidate(){
        if(status != CandidateStatus.INTERVIEWED){
            System.out.println("Candidate's status must be INTERVIEWED!");
            return false;
        }
        status = CandidateStatus.REJECTED;
        return true;
    }

    public String getCVfile() {
        return cvFile;
    }

}