package domainServices;

import domain.recruitment.Candidate;

// Validator used to check any given email
public class EmailValidator {
    private boolean validateEmail(Candidate candidate) {
        if (candidate.getEmail() == null || candidate.getEmail().isBlank()) {
            System.out.println("Candidate email is null or empty!");
            return false;
        }
        return true;
    }
}
