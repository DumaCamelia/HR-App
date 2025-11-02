package domain.recruitment;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Position {

    private int id;
    private String title;
    private String description;
    private String requirements;
    private PositionStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime closedAt;


    public Position(int id, String title, String description, String requirements) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.status = PositionStatus.CREATED;
        LocalDateTime createdAt = LocalDateTime.now();
    }

    public boolean openPosition() {
        if(status != PositionStatus.CREATED && status != PositionStatus.CLOSED){
            System.out.println("The position must be created or closed to open");
            return false;
        }
        this.status = PositionStatus.OPEN;
        System.out.println("Position opened successfully!");
        return true;
    }

    public boolean startRecruitment() {
        if (this.status != PositionStatus.OPEN) {
            System.out.println("Recruitment can only start from OPEN state.");
            return false;
        }
        this.status = PositionStatus.IN_RECRUITMENT;
        return true;
    }

    public boolean closePosition() {
        if (this.status == PositionStatus.CLOSED) {
            System.out.println("Position is already closed.");
            return false;
        }
        this.status = PositionStatus.CLOSED;
        LocalDateTime closedAt = LocalDateTime.now();
        return true;
    }
}
