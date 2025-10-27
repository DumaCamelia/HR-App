package domain.interview;

import java.time.ZonedDateTime;

public class Interview {
    private int id;
    private ZonedDateTime dateTime;
    private int interviewerId;
    private int candidateId;
    private int positionId;
    private InterviewStatus status;

    public boolean StartInterview(){
        if(status != InterviewStatus.SCHEDULED){
            System.out.println("The interview must be scheduled!");
            return false;
        }
        status = InterviewStatus.IN_PROGRESS;
        return true;
    }

    public boolean FinishedInterview(){
        if(status != InterviewStatus.IN_PROGRESS){
            System.out.println("The interview must be in progress!");
            return false;
        }
        status = InterviewStatus.FINISHED;
        return true;
    }

    protected Interview() {}


    public Interview(int id, ZonedDateTime dateTime, int interviewerId, int candidateId, int positionId, InterviewStatus status) {
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

    public int getId (){
        return id;
    }
    public ZonedDateTime getDateTime (){
        return dateTime;
    }
    public int getInterviewerId (){
        return interviewerId;
    }
    public int getCandidateId (){
        return candidateId;
    }
    public int getPositionId (){
        return positionId;
    }



}
