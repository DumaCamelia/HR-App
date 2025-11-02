package domainServices;

import domain.recruitment.Candidate;

// Validator used to check any given full name
public class NameValidator {
    public boolean validateName(String name){
        try {
            // Split the full name
            String firstName = name.split("")[0];
            String lastName = name.split("")[1];

            // Check if there are any non-letter characters in the name
            // ex. "Name123" is invalid
            return firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Caught only if the split full name contains less than 2 names
            // and means that the last name is missing
            System.out.println("The name must be full!");
            return false;
        }
    }
}
