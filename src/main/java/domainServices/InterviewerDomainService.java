package domainServices;

import domain.interview.Interview;
import domain.interview.Interviewer;

import java.util.List;

public class InterviewerDomainService {
    public boolean validateEmailUnicity(Interviewer interviewer) {
        String email = interviewer.getEmail();
        // TODO: Implement InterviewerRepository (so we can check email's unicity)
        return true;
    }

    public boolean validateScheduledInterviews(Interviewer interviewer) {
        List<Interview> interviews = interviewer.getScheduledInterviews();
        if (interviews == null) {
            System.out.println("Scheduled interviews list cannot be null!");
            return false;
        }
        return true;
    }

    public boolean validateInterviewer(Interviewer interviewer) {
        return     validateEmailUnicity(interviewer)
                && validateScheduledInterviews(interviewer);
    }
}
