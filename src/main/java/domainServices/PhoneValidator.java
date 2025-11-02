package domainServices;

import domain.recruitment.Candidate;

// Validator used to check any given phone number
public class PhoneValidator {
    public boolean validatePhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            System.out.println("Candidate phone number is required!");
            return false;
        }
        return true;
    }
}
