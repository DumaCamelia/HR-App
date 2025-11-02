package applicationServices;

import domain.recruitment.Candidate;

import java.time.ZonedDateTime;

public class InterviewApplicationService {
    public void scheduleInterview(Candidate candidate, ZonedDateTime time){
        candidate.scheduleInterviewCandidate();
    }
}
