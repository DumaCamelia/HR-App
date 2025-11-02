package domainServices;

import domain.notification.Notification;
import domain.notification.NotificationType;
import domain.notification.RecipientRole;

import java.time.LocalDateTime;

public class NotificationDomainService {
    public boolean validateType(Notification notification) {
        NotificationType type = notification.getType();
        if (type == null) {
            System.out.println("Notification type cannot be null!");
            return false;
        }
        switch (type) {
            case INTERVIEW_SCHEDULED, INTERVIEW_UPDATED, INTERVIEW_CANCELLED,
                 INTERVIEW_REMINDER, APPLICATION_ACCEPTED, APPLICATION_REJECTED -> {
                return true;
            }
            default -> {
                System.out.println("Notification type is invalid!");
                return false;
            }
        }
    }

    public boolean validateRole(Notification notification) {
        RecipientRole role = notification.getRole();
        if (role == null) {
            System.out.println("Notification recipient role cannot be null!");
            return false;
        }
        switch (role) {
            case CANDIDATE, INTERVIEWER, HR -> {
                return true;
            }
            default -> {
                System.out.println("Notification recipient role is invalid!");
                return false;
            }
        }
    }

    public boolean validateMessage(Notification notification) {
        String message = notification.getMessage();
        if (message == null || message.isBlank()) {
            System.out.println("Notification message cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validateNotification(Notification notification) {
        return     validateType(notification)
                && validateRole(notification)
                && validateMessage(notification);
    }
}
