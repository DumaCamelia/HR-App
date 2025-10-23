package domain.recruitment;

import java.time.LocalDateTime;

public class Candidate {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String cvFile;
    private CandidateStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime appliedAt;
    private LocalDateTime updatedAt;

    public Candidate() {}

    public Candidate(int id, String name, String email, String phone, String cvFile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cvFile = cvFile;
        this.status = CandidateStatus.APPLIED;
    }

    public void applyCandidate(){
        if(id == 0 || name.isEmpty() || email.isEmpty() || phone.isEmpty() || cvFile == null){
            throw new IllegalStateException("Candidate's data is incomplete!");
        }
        status = CandidateStatus.APPLIED;
    }

    public void scheduleInterview(){
        if(status != CandidateStatus.APPLIED){
            throw new IllegalStateException("Candidate's status must be APPLIED!");
        }
        status = CandidateStatus.INTERVIEWED;
    }

    public void hire(){
        if(status != CandidateStatus.INTERVIEWED){
            throw new IllegalStateException("Candidate's status must be INTERVIEWED!");
        }
        status = CandidateStatus.HIRED;
    }

    public void reject(){
        if(status != CandidateStatus.INTERVIEWED){
            throw new IllegalStateException("Candidate's status must be INTERVIEWED!");
        }
        status = CandidateStatus.REJECTED;
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