package domainServices;

import domain.evaluation.Evaluation;
import domain.recruitment.Candidate;

import java.time.LocalDateTime;

public class EvaluationDomainService {
    // CandidateDomainService required mainly for validating the candidate's name
    private final CandidateDomainService candidateDomainService;

    public EvaluationDomainService(CandidateDomainService candidateDomainService){
        this.candidateDomainService = candidateDomainService;
    }

    public boolean validateId(Evaluation evaluation){
        int id = evaluation.getId();
        if(id < 0){
            System.out.println("ID must be a positive integer!");
            return false;
        }
        return true;
    }
    public boolean validateScore(Evaluation evaluation){
        // The score should be an integer between 0 and 100
        int score = evaluation.getScore();
        if(score < 0 || score > 100){
            System.out.println("The score must be between 0 and 100!");
            return false;
        }
        return true;
    }

    public boolean validateFeedback(Evaluation evaluation){
        // The feedback must be not null and longer than 10 characters
        String feedback = evaluation.getFeedback();
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("Feedback cannot be empty!");
            return false;
        }
        if (feedback.length() < 10) {
            System.out.println("Feedback must contain at least 10 characters!");
            return false;
        }
        return true;
    }

    public boolean validateEvaluatedAt(Evaluation evaluation) {
        // The evaluation submission moment cannot be null or from the future
        if (evaluation.getEvaluatedAt() == null) {
            System.out.println("Evaluation date cannot be null!");
            return false;
        }
        if (evaluation.getEvaluatedAt().isAfter(LocalDateTime.now())) {
            System.out.println("Evaluation date cannot be in the future!");
            return false;
        }
        return true;
    }

    public boolean validateEvaluationType(Evaluation evaluation) {
        // The evaluation type should be not null
        if (evaluation.getEvaluationType() == null) {
            System.out.println("Evaluation type cannot be null!");
            return false;
        }
        return true;
    }

    public boolean validateEvaluation(Evaluation evaluation) {
        // Use all the other validations together
        return     validateId(evaluation)
                && candidateDomainService.validateName(new Candidate(0, evaluation.getCandidateName(), "", "", ""))
                && validateScore(evaluation)
                && validateFeedback(evaluation)
                && validateEvaluatedAt(evaluation)
                && validateEvaluationType(evaluation);
    }
}
