package domain.assessmentEvaluation;

import domain.recruitment.Candidate;
import java.time.LocalDateTime;

public class Evaluation {
    private Candidate candidate;
    private int score;
    private String feedback;
    private LocalDateTime evaluatedAt;
}
