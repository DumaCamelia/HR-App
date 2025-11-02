package domain.evaluation;

import domain.recruitment.Candidate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Evaluation {
    @Id
    private int id;
    private Candidate candidate;
    private int score;
    private String feedback;
    private LocalDateTime evaluatedAt;
    private EvaluationType evaluationType;
    private static int lastId = 1;

    public Evaluation(Candidate candidate, int score, String feedback, EvaluationType evaluationType, LocalDateTime evaluatedAt){
        id = lastId++;
        this.candidate = candidate;
        this.score = score;
        this.feedback = feedback;
        this.evaluationType = evaluationType;
        this.evaluatedAt = evaluatedAt;
    }
}
