package domainServices;

// Validator used to check any given ID
public class IdValidator {
    public boolean ValidateId(int id){
        if(id < 0){
            System.out.println("ID must be a positive integer!");
            return false;
        }
        return true;
    }
}
