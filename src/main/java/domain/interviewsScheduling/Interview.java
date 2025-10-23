package domain.interviewsScheduling;

import java.time.ZonedDateTime;

public class Interview {
    private int id;
    private ZonedDateTime dateTime;
    private int interviewerId;
    private int candidateId;
    private int positionId;
    private InterviewStatus status;

    public void StartInterview(){
        if(status != InterviewStatus.SCHEDULED){
            throw new IllegalStateException("The interview must be scheduled!");
        }
        status = InterviewStatus.IN_PROGRESS;
    }

    public void FinishedInterview(){
        if(status != InterviewStatus.IN_PROGRESS){
            throw new IllegalStateException("The interview must be in progress!");
        }
        status = InterviewStatus.FINISHED;
    }

    protected Interview() {}


    public Interview(int id, ZonedDateTime dateTime, int interviewerId, int candidateId, int positionId, String location) {
        this.id = id;
        this.dateTime = dateTime;
        this.interviewerId = interviewerId;
        this.candidateId = candidateId;
        this.positionId = positionId;
        this.status = InterviewStatus.SCHEDULED;
    }

    public void setId (int id){
        this.id=id;
    }
    public void setDateTime (ZonedDateTime dateTime){
        this.dateTime=dateTime;
    }
    public void setInterviewerId (int interviewerId){
        this.interviewerId=interviewerId;
    }
    public void setPositionId (int positionId){
        this.positionId=positionId;
    }

    public int id (){
        return id;
    }
    public ZonedDateTime dateTime (){
        return dateTime;
    }
    public int interviewerId (){
        return interviewerId;
    }
    public int candidateId (){
        return candidateId;
    }
    public int positionId (){
        return positionId;
    }



}
