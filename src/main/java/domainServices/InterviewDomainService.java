package domainServices;

import domain.interview.Interview;

import java.time.ZonedDateTime;

public class InterviewDomainService {
    public boolean validateDateTime(Interview interview) {
        ZonedDateTime dateTime = interview.getDateTime();
        if (dateTime == null) {
            System.out.println("Interview date/time cannot be null!");
            return false;
        }
        if (dateTime.isBefore(ZonedDateTime.now())) {
            System.out.println("Interview date/time cannot be in the past!");
            return false;
        }
        return true;
    }

    public boolean validateStatus(Interview interview) {
        if (interview.getStatus() == null) {
            System.out.println("Interview status cannot be null!");
            return false;
        }
        return true;
    }

    public boolean validateInterview(Interview interview) {
        return     validateDateTime(interview)
                && validateStatus(interview);
    }
}
