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
    private LocalDateTime createdAt;
    public Candidate() {}

    public Candidate(int id, String name, String email, String phone, String cvFile, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cvFile = cvFile;
        this.status = CandidateStatus.CREATED;
        this.createdAt = LocalDateTime.now();;
    }

    public String applyCandidate(){
        if(id == 0 || name.isEmpty() || email.isEmpty() || phone.isEmpty() || cvFile == null){
            return "Candidate's data is incomplete!";
        }
        status = CandidateStatus.APPLIED;
        LocalDateTime appliedAt = LocalDateTime.now();
        return "Success!";
    }

    public String scheduleInterviewCandidate(){
        if(status != CandidateStatus.APPLIED){
            return "Candidate's status must be APPLIED!";
        }
        status = CandidateStatus.INTERVIEWED;
        return "Success!";
    }

    public String hireCandidate(){
        if(status != CandidateStatus.INTERVIEWED){
            return "Candidate's status must be INTERVIEWED!";
        }
        status = CandidateStatus.HIRED;
        return "Success!";
    }

    public String rejectCandidate(){
        if(status != CandidateStatus.INTERVIEWED){
            return "Candidate's status must be INTERVIEWED!";
        }
        status = CandidateStatus.REJECTED;
        return "Success!";
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