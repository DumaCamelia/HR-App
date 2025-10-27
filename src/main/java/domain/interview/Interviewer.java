package domain.interview;

import domain.recruitment.Candidate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Interviewer {
    private int id;
    private Candidate candidate;
    private Interviewer interviewer;
    private LocalDateTime scheduledAt;
    private InterviewStatus status;
    private List<Interview> scheduledInterviews = new ArrayList<>();

    public Interviewer() {}

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

    public int getId() { return id; }
    public Candidate getCandidate() { return candidate; }
    public Interviewer getInterviewer() { return interviewer; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }
    public InterviewStatus getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setCandidate(Candidate candidate) { this.candidate = candidate; }
    public void setInterviewer(Interviewer interviewer) { this.interviewer = interviewer; }
    public void setScheduledAt(LocalDateTime scheduledAt) { this.scheduledAt = scheduledAt; }
    public void setStatus(InterviewStatus status) { this.status = status; }

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
