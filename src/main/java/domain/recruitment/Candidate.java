package domain.recruitment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Candidate {
    @Id
    private int id;
    private String name;
    private String email;
    private String phone;
    private String cvFile;
    private CandidateStatus status;

    public Candidate() {}

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

    public void setId (int id) {
        this.id=id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail (String email) {
        this.email=email;
    }
    public void setPhone (String phone) {
        this.phone=phone;
    }
    public void setCVfile (String cvFile) {
        this.cvFile=cvFile;
    }


    public int getId() {
       return id;
    }
    public String getName() {
       return name;
    }
    public String getEmail() {
       return email;
    }
    public String getPhone() {
       return phone;
    }
    public String getCVfile() {
        return cvFile;
    }
    public CandidateStatus getStatus(){
       return this.status;
    }

}