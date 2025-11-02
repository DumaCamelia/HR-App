package domainServices;

import domain.recruitment.Candidate;
import domain.recruitment.CandidateStatus;
import infrastructure.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateDomainService{
    private final CandidateRepository candidateRepository;
    private final PhoneValidator phoneValidator;

    public CandidateDomainService(CandidateRepository candidateRepository, PhoneValidator phoneValidator) {
        this.candidateRepository = candidateRepository;
        this.phoneValidator = phoneValidator;
    }

    public boolean validateCandidate(Candidate candidate) {
        return  validateEmailUnicity(candidate) &&
                validatePhoneUnicity(candidate) &&
                validateCV(candidate);
    }

    private boolean validateEmailUnicity(Candidate candidate) {
        if (candidateRepository.existsByEmail(candidate.getEmail())) {
            System.out.println("A candidate with this email already exists!");
            return false;
        }
        return true;
    }

    private boolean validatePhoneUnicity(Candidate candidate) {
        if (candidateRepository.existsByPhone(candidate.getPhone())) {
            System.out.println("A candidate with this phone number already exists!");
            return false;
        }
        return true;
    }

    private boolean validateCV(Candidate candidate) {
        String cv = candidate.getCvFile();

        if (cv == null || cv.isBlank()) {
            System.out.println("Candidate CV file is required!");
            return false;
        }

        if (!cv.toLowerCase().endsWith(".pdf")) {
            System.out.println("Candidate CV must be a PDF file!");
            return false;
        }

        return true; // CV valid
    }


    public boolean validateStatusTransition(Candidate candidate, CandidateStatus newStatus) {
        CandidateStatus current = candidate.getStatus();

        if (!isValidTransition(current, newStatus)) {
            System.out.println("Invalid status transition: " + current + " → " + newStatus);
            return false;
        }

        return true;
    }

    public boolean isValidTransition(CandidateStatus from, CandidateStatus to) {
        return switch (from) {
            case CREATED -> to == CandidateStatus.APPLIED;
            case APPLIED -> to == CandidateStatus.INTERVIEWED || to == CandidateStatus.REJECTED;
            case INTERVIEWED -> to == CandidateStatus.HIRED || to == CandidateStatus.REJECTED;
            case HIRED, REJECTED -> false; // stări finale, nu se mai schimbă
        };
    }

    public boolean validateReadyForInterview(Candidate candidate) {
        if (validateCV(candidate)) {
            System.out.println("Candidate must have a CV before the interview.");
            return false;
        }

        if (phoneValidator.validatePhone(candidate.getPhone())) {
            System.out.println("Candidate must have a phone number before the interview.");
            return false;
        }

        return true;
    }

    public boolean validateDeletion(Candidate candidate) {
        if (candidate.getStatus() == CandidateStatus.INTERVIEWED || candidate.getStatus() == CandidateStatus.APPLIED) {
            System.out.println("Candidate cannot be deleted.");
            return false;
        }
        return true;
    }
}
