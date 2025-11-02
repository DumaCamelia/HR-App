package applicationServices;

import domain.recruitment.Candidate;
import domain.recruitment.CandidateStatus;
import domainServices.CandidateDomainService;
import infrastructure.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateApplicationService {

    private final CandidateDomainService candidateDomainService;
    private final CandidateRepository candidateRepository;

    public CandidateApplicationService(CandidateDomainService candidateDomainService, CandidateRepository candidateRepository) {
        this.candidateDomainService = candidateDomainService;
        this.candidateRepository = candidateRepository;
    }

    public boolean applyCandidate(Candidate candidate) {
        // validare pentru candidatul nou
        if (!candidateDomainService.validateNewCandidate(candidate)) {
            System.out.println("Candidate validation failed. Cannot apply.");
            return false;
        }

        // setare status
        if (!candidateDomainService.validateStatusTransition(candidate, CandidateStatus.APPLIED)) {
            return false;
        }

        candidate.setStatus(CandidateStatus.APPLIED);
        candidateDomainService.validateCandidate(candidate);
        candidateRepository.save(candidate);// salvare automată în repository
        System.out.println("Candidate applied successfully.");
        return true;
    }

    public boolean scheduleInterview(Candidate candidate) {
        // validare status curent și readiness pentru interviu
        if (!candidateDomainService.validateStatusTransition(candidate, CandidateStatus.INTERVIEWED)) {
            return false;
        }

        if (!candidateDomainService.validateReadyForInterview(candidate)) {
            return false;
        }

        candidate.setStatus(CandidateStatus.INTERVIEWED);
        candidateDomainService.validateCandidate(candidate); // salvare automată
        System.out.println("Candidate scheduled for interview successfully.");
        return true;
    }

    public boolean hireCandidate(Candidate candidate) {
        if (!candidateDomainService.validateStatusTransition(candidate, CandidateStatus.HIRED)) {
            return false;
        }

        candidate.setStatus(CandidateStatus.HIRED);
        candidateDomainService.validateCandidate(candidate); // salvare automată
        System.out.println("Candidate hired successfully.");
        return true;
    }

    public boolean rejectCandidate(Candidate candidate) {
        if (!candidateDomainService.validateStatusTransition(candidate, CandidateStatus.REJECTED)) {
            return false;
        }

        candidate.setStatus(CandidateStatus.REJECTED);
        candidateDomainService.validateCandidate(candidate); // salvare automată
        System.out.println("Candidate rejected successfully.");
        return true;
    }

    public boolean deleteCandidate(Candidate candidate) {
        if (!candidateDomainService.validateDeletion(candidate)) {
            return false;
        }
        System.out.println("Candidate deleted successfully.");
        return true;
    }


}
