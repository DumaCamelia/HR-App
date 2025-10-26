package domain.evaluation;

import domain.recruitment.Candidate;
import java.time.LocalDateTime;

public class Evaluation {
    private Candidate candidate;
    private int score;
    private String feedback;
    private LocalDateTime evaluatedAt;

    public Evaluation() {}

    public Evaluation(Candidate candidate, int score, String feedback, LocalDateTime evaluatedAt) {
        this.candidate = candidate;
        this.score = score;
        this.feedback = feedback;
        this.evaluatedAt = evaluatedAt;
    }

    public Evaluation(Candidate candidate, int score, String feedback) {
        this.candidate = candidate;
        this.score = score;
        this.feedback = feedback;
        this.evaluatedAt = LocalDateTime.now();
    }

    public Candidate getCandidate() {
        return candidate;
    }
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }

}
