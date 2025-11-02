package domainServices;

import domain.evaluation.Evaluation;
import domain.recruitment.Candidate;
import domain.recruitment.CandidateStatus;
import infrastructure.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateDomainService {
    private final CandidateRepository candidateRepository;

    public CandidateDomainService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public boolean addCandidate(Candidate candidate) {
        if (!validateName(candidate) ||
            !validateEmail(candidate) ||
            !validatePhone(candidate) ||
            !validateCV(candidate))
            return false;

        candidateRepository.save(candidate);
        return true;
    }

    public boolean deleteCandidate(Candidate candidate) {
        if (!validateDeletion(candidate)) return false;

        candidateRepository.delete(candidate);
        return true;
    }


    public boolean validateNewCandidate(Candidate candidate) {
       return validateName(candidate) &&
        validateEmail(candidate) &&
        validatePhone(candidate) &&
        validateCV(candidate);
    }

    private boolean validateEmail(Candidate candidate) {
        if (candidate.getEmail() == null || candidate.getEmail().isBlank()) {
            System.out.println("Candidate email is required!");
            return false;
        }
        if (candidateRepository.existsByEmail(candidate.getEmail())) {
            System.out.println("A candidate with this email already exists!");
            return false;
        }
        return true;
    }


    private boolean validatePhone(Candidate candidate) {
        if (candidate.getPhone() == null || candidate.getPhone().isBlank()) {
            System.out.println("Candidate phone number is required!");
            return false;
        }
        if (candidateRepository.existsByPhone(candidate.getPhone())) {
            System.out.println("A candidate with this phone number already exists!");
            return false;
        }
        return true;
    }

    public boolean validateName(Candidate candidate){
        // Split the full name
        try {
            String firstName = candidate.getName().split("")[0];
            String lastName = candidate.getName().split("")[1];

            // Check if there are any non-letter characters in the name
            // ex. "Name123" is invalid
            return firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Caught only if the split full name contains less than 2 names
            // and means that the last name is missing
            System.out.println("The candidate's name must be full!");
            return false;
        }
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
        if (candidate.getCvFile() == null || candidate.getCvFile().isBlank()) {
            System.out.println("Candidate must have a CV before the interview.");
            return false;
        }

        if (candidate.getPhone() == null || candidate.getPhone().isBlank()) {
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
