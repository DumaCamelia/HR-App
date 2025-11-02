package app;

import domain.evaluation.Evaluation;
import domain.evaluation.EvaluationType;
import domain.recruitment.Candidate;
import Infrastructure.CandidateRepository;
import Infrastructure.EvaluationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {
    private final CandidateRepository candidateRepository;
    private final EvaluationRepository evaluationRepository;

    public DataLoader(CandidateRepository candidateRepository, EvaluationRepository evaluationRepository) {
        this.candidateRepository = candidateRepository;
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public void run(String... args) {
        candidateRepository.save(new Candidate(1, "Ana", "Ana.simaicum@gmail.com", "00784739213", "folder/altFolder/DanDiaconescu.pdf"));
        candidateRepository.save(new Candidate(2, "Cornel", "Cornel.cinealtu@gmail.com", "00784739212", "folder/altFolder/JustitiaruDeBerceni.pdf"));

        candidateRepository.findAll().forEach(c -> System.out.println(c.getName() + ": " + c.getStatus()));

        evaluationRepository.save(new Evaluation("Marian", 100, "Un baiat de nota 10!", EvaluationType.HR_INTERVIEW, LocalDateTime.now()));
        evaluationRepository.save(new Evaluation("Marian", 100, "Nimic de reprosat!", EvaluationType.TECHNICAL_INTERVIEW, LocalDateTime.now()));
        evaluationRepository.findAll().forEach(evaluation -> System.out.println(evaluation.getCandidateName() + "'s evaluation: " + evaluation.getFeedback()));
    }
}
