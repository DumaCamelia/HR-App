package applicationServices;

import domain.notification.Notification;
import domainServices.NotificationDomainService;

import java.time.LocalDateTime;

public class NotificationApplicationService {

    private final NotificationDomainService notificationDomainService;

    public NotificationApplicationService(NotificationDomainService notificationDomainService) {
        this.notificationDomainService = notificationDomainService;
    }

    public boolean sendNotification(Notification notification) {
        if (!notificationDomainService.validateNotification(notification)) {
            System.out.println("Notification validation failed. Cannot send.");
            return false;
        }

        // Logica de "trimitere" efectivă (ex: print, salvare în DB, etc.)
        notification.setSentAt(LocalDateTime.now());
        System.out.println("Notification sent to " + notification.getRole() + ": " + notification.getMessage());
        return true;
    }
}
