package domain.recruitment;


import java.time.LocalDateTime;

public class Position {

    private int id;
    private String title;
    private String description;
    private String requirements;
    private PositionStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime closedAt;


    protected Position() {}


    public Position(int id, String title, String description, String requirements) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.status = PositionStatus.OPEN;
        this.createdAt = LocalDateTime.now();
    }

    public void openPosition() {
        this.status = PositionStatus.OPEN;
    }

    public void startRecruitment() {
        if (this.status != PositionStatus.OPEN) {
            throw new IllegalStateException("Recruitment can only start from OPEN state.");
        }
        this.status = PositionStatus.IN_RECRUITMENT;
    }

    public void closePosition() {
        if (this.status == PositionStatus.CLOSED) {
            throw new IllegalStateException("Position is already closed.");
        }
        this.status = PositionStatus.CLOSED;
    }

    public void setId (int id) {
        this.id=id;
    }
    public void setTitle (String title) {
        this.title=title;
    }
    public void setDescription (String description) {
        this.description=description;
    }
    public void setRequirements(String requirements) {
        this.requirements=requirements;
    }

    //am inteles ca la positionstatus n ar trebui sa am setter, doar getter

    public PositionStatus getStatus() {
        return status;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getRequirements() {
        return requirements;
    }
}
