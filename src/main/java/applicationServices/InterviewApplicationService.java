package applicationServices;

import domain.recruitment.Candidate;

import java.time.ZonedDateTime;

public class InterviewApplicationService {
    private final CandidateApplicationService candidateApplicationService;

    public InterviewApplicationService(CandidateApplicationService candidateApplicationService) {
        this.candidateApplicationService = candidateApplicationService;
    }

    public boolean scheduleInterview(Candidate candidate){
        return candidateApplicationService.scheduleInterview(candidate);
    }
}
