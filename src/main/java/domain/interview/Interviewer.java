package domain.interview;

import domain.recruitment.Candidate;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Interviewer {
    private int id;
    private String name;
    private String email;
    private List<Interview> scheduledInterviews = new ArrayList<>();

    public Interviewer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /*
    TODO: Move this logic to InterviewerApplicationService
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
*/

}
