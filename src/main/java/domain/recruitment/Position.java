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


}
