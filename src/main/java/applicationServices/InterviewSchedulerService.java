package applicationServices;

import java.util.List;
import domain.interviewsScheduling.InterviewStatus;
import domain.recruitment.*;
import domain.interviewsScheduling.Interview;

import java.time.ZonedDateTime;

public class InterviewSchedulerService {
    public List<Interview> interviews;


    public void scheduleInterview(HRUser hrUser, Candidate candidate, int interviewerId, Position position, ZonedDateTime time){
        if(candidate.getStatus() != CandidateStatus.APPLIED){
            throw new IllegalStateException("Candidate must have applied first!");
        }
        if(position.getStatus() != PositionStatus.CLOSED){
            throw  new IllegalStateException("The position cannot be closed!");
        }
        for(Interview interview: interviews){
            if(interview.getInterviewerId() != interviewerId){
                continue;
            }
            if(interview.getDateTime() == time){
                // TODO: replace exceptions with return messages (EVERYWHERE!)
                throw new IllegalStateException("The interview time is already occupied!");
            }
        }
        Interview interview = new Interview(interviews.size() + 1, time, interviewerId, candidate.getId(), position.getId(), InterviewStatus.SCHEDULED);

        interviews.add(interview);
    }
}
