package applicationServices;

import domain.assessmentEvaluation.Evaluation;
import domain.assessmentEvaluation.EvaluationRepository;
import domain.assessmentEvaluation.EvaluationType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/*
    Application service responsible with managing evaluations, with methods for submitting evaluations and
    computing the candidate's final score.
*/
@Service
public class EvaluationApplicationService {
    private final EvaluationRepository evaluationRepository;

    // Constructor where the application service initializes its reference to the EvaluationRepository
    public EvaluationApplicationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    // Saves a new evaluation to the EvaluationRepository
    public Evaluation submitEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    // Calculates the final score of a candidate after undergoing both interviews
    public int computeFinalScore(String candidateName) {
        // Returns the evaluations attended by the candidate
        List<Evaluation> evaluations = evaluationRepository.findByCandidateName(candidateName);
        if(evaluations.size() <= 1){
            System.out.println("The candidate doesn't have both evaluations!");
            return -1;
        }

        // Store the scores obtained in each interview
        int hrScore = Objects.requireNonNull(evaluations.stream().filter(e -> e.getEvaluationType() == EvaluationType.HR_INTERVIEW).findFirst().orElse(null)).getScore();
        int technicalScore = Objects.requireNonNull(evaluations.stream().filter(e -> e.getEvaluationType() == EvaluationType.TECHNICAL_INTERVIEW).findFirst().orElse(null)).getScore();

        /* Return the final score, with the HR Interview score amounting for 25% of it,
           while the Technical Interview score amounts for 75% */
        return (int) (hrScore * 0.25 + technicalScore * 0.75);
    }
}
