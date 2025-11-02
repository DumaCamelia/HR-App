package domainServices;

import domain.recruitment.HRUser;
import infrastructure.HRUserRepository;

import java.util.regex.Pattern;

public class HRUserDomainService {
    public boolean validateId(HRUser hrUser) {
        if(hrUser.getId() <= 0){
            System.out.println("HRUser ID must be a positive integer!");
            return false;
        }
        return true;
    }

    public boolean validateName(HRUser hrUser) {
        if(hrUser.getName() == null || hrUser.getName().isBlank()){
            System.out.println("HRUser name cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validateEmail(HRUser hrUser) {
        String email = hrUser.getEmail();
        if(email == null || email.isBlank()){
            System.out.println("HRUser email cannot be empty!");
            return false;
        }
        if(HRUserRepository.existsByEmail(hrUser.getEmail())) {
            System.out.println("An HRUser with this email already exists!");
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if(!Pattern.matches(emailRegex, email)){
            System.out.println("HRUser email format is invalid!");
            return false;
        }
        return true;
    }



    public boolean validateHRUser(HRUser hrUser) {
        return validateId(hrUser) &&
                validateName(hrUser) &&
                validateEmail(hrUser);
    }
}
