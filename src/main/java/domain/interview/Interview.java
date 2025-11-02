package domain.interview;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Interview {
    private int id;
    private ZonedDateTime dateTime;
    private int interviewerId;
    private int candidateId;
    private int positionId;
    private InterviewStatus status;

    public Interview(int id, ZonedDateTime dateTime, int interviewerId, int candidateId, int positionId, InterviewStatus status) {
        this.id = id;
        this.dateTime = dateTime;
        this.interviewerId = interviewerId;
        this.candidateId = candidateId;
        this.positionId = positionId;
        this.status = InterviewStatus.SCHEDULED;
    }

    /*
    TODO: Move this logic to InterviewApplicationService
    public boolean StartInterview(){
        if(status != InterviewStatus.SCHEDULED){
            System.out.println("The interview must be scheduled!");
            return false;
        }
        status = InterviewStatus.IN_PROGRESS;
        return true;
    }

    public boolean FinishInterview(){
        if(status != InterviewStatus.IN_PROGRESS){
            System.out.println("The interview must be in progress!");
            return false;
        }
        status = InterviewStatus.FINISHED;
        return true;
    }
    */
}
