package domain.interview;

import domain.recruitment.Candidate;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Interviewer {
    private int id;
    private Candidate candidate;
    private Interviewer interviewer;
    private LocalDateTime scheduledAt;
    private InterviewStatus status;
    private List<Interview> scheduledInterviews = new ArrayList<>();

    public Interviewer(int id, Candidate candidate, Interviewer interviewer, LocalDateTime scheduledAt, InterviewStatus status) {
        this.id = id;
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.scheduledAt = scheduledAt;
        this.status = status;
    }

    public Interviewer(Candidate candidate, Interviewer interviewer, LocalDateTime scheduledAt) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.scheduledAt = scheduledAt;
        this.status = InterviewStatus.SCHEDULED;
    }

    public boolean reschedule(LocalDateTime newDate) {
        if (status == InterviewStatus.CANCELLED || status == InterviewStatus.COMPLETED) {
            System.out.println("Cannot reschedule a cancelled or completed interview.");
            return false;
        }
        this.scheduledAt = newDate;
        this.status = InterviewStatus.RESCHEDULED;
        return true;
    }

    public void cancel() {
        this.status = InterviewStatus.CANCELLED;
    }

    public void complete() {
        this.status = InterviewStatus.COMPLETED;
    }

    public void addInterview(Interview interview) {
        scheduledInterviews.add(interview);
    }


}
