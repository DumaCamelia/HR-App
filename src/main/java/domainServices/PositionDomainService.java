package domainServices;

import domain.recruitment.Position;
import domain.recruitment.PositionStatus;

import java.time.LocalDateTime;

public class PositionDomainService {

    public boolean validateId(Position position) {
        if (position.getId() <= 0) {
            System.out.println("Position ID must be a positive integer!");
            return false;
        }
        return true;
    }

    public boolean validateTitle(Position position) {
        if (position.getTitle() == null || position.getTitle().isBlank()) {
            System.out.println("Position title cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validateDescription(Position position) {
        if (position.getDescription() == null || position.getDescription().isBlank()) {
            System.out.println("Position description cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validateRequirements(Position position) {
        if (position.getRequirements() == null || position.getRequirements().isBlank()) {
            System.out.println("Position requirements cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validateStatus(Position position) {
        PositionStatus status = position.getStatus();
        if (status == null) {
            System.out.println("Position status cannot be null!");
            return false;
        }

        switch (status) {
            case CREATED, OPEN, IN_RECRUITMENT, CLOSED -> {
                return true;
            }
            default -> {
                System.out.println("Position status is invalid!");
                return false;
            }
        }
    }

    public boolean validateCreatedAt(Position position) {
        if (position.getCreatedAt() == null) {
            System.out.println("Position creation date cannot be null!");
            return false;
        }
        return true;
    }

    public boolean validateClosedAt(Position position) {
        LocalDateTime closedAt = position.getClosedAt();
        if (closedAt != null && closedAt.isBefore(position.getCreatedAt())) {
            System.out.println("Position closed date cannot be before creation date!");
            return false;
        }
        return true;
    }

    public boolean validatePosition(Position position) {
        return validateId(position)
                && validateTitle(position)
                && validateDescription(position)
                && validateRequirements(position)
                && validateStatus(position)
                && validateCreatedAt(position)
                && validateClosedAt(position);
    }
}
