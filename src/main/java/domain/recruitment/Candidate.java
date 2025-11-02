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
    private LocalDateTime appliedAt;
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



}