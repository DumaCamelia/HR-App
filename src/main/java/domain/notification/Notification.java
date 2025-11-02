package domain.notification;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Notification {
    private int id;
    private NotificationType type;
    private RecipientRole role;
    private String message;
    private int candidateId;

    public Notification(int id, NotificationType type, RecipientRole role, String message, int candidateId) {
        this.id = id;
        this.type = type;
        this.role = role;
        this.message = message;
        this.candidateId = candidateId;
        LocalDateTime sentAt = LocalDateTime.now();
    }
}
