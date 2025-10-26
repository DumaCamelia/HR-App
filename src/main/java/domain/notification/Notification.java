package domain.notification;

import java.time.LocalDateTime;

public class Notification {
    private int id;
    private NotificationType type;
    private RecipientRole role;
    private String message;
    private int candidateId;


    protected Notification() {}

    public Notification(int id, NotificationType type, RecipientRole role, String message, int candidateId) {
        this.id = id;
        this.type = type;
        this.role = role;
        this.message = message;
        this.candidateId = candidateId;
        LocalDateTime sentAt = LocalDateTime.now();
    }

    public int getId (){
        return id;
    }
    public NotificationType getType() {
        return type;
    }
    public RecipientRole getRole() {
        return role;
    }
    public String getMessage (){
        return message;
    }
    public int getCandidateId() {
        return candidateId;
    }

    public void setId (int id){
        this.id=id;
    }
    public void setMessage (String message) {
        this.message = message;
    }
    public void setCandidateId (int candidateId){
        this.candidateId = candidateId;
    }
}
