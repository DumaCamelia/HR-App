package domain.evaluation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Evaluation {
    @Id
    private int id;
    private String candidateName;
    private int score;
    private String feedback;
    private LocalDateTime evaluatedAt;
    private EvaluationType evaluationType;
    private static int lastId = 1;

    public Evaluation(){}

    public Evaluation(String candidateName, int score, String feedback, EvaluationType evaluationType, LocalDateTime evaluatedAt){
        id = lastId++;
        this.candidateName = candidateName;
        this.score = score;
        this.feedback = feedback;
        this.evaluationType = evaluationType;
        this.evaluatedAt = evaluatedAt;
    }

    public int getId(){
        return id;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public int getScore(){
        return score;
    }

    public String getFeedback(){
        return feedback;
    }

    public EvaluationType getEvaluationType(){
        return evaluationType;
    }

    public LocalDateTime getEvaluatedAt(){
        return evaluatedAt;
    }
}
