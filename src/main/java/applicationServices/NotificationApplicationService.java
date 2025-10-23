package applicationServices;

import domain.recruitment.CandidateStatus;

import java.time.ZonedDateTime;

public class NotificationApplicationService {
    void notifyCandidateStatusChanged(Long candidateId, CandidateStatus newStatus);
    void notifyInterviewScheduled(Long candidateId, ZonedDateTime date);
}
