package domain.recruitment;


import java.time.LocalDateTime;

public class Position {

    private int id;
    private String title;
    private String description;
    private String requirements;
    private PositionStatus status;


    protected Position() {}


    public Position(int id, String title, String description, String requirements) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.status = PositionStatus.CREATED;
        LocalDateTime createdAt = LocalDateTime.now();
    }

    public String openPosition (){
        if (status != PositionStatus.CREATED && status != PositionStatus.CLOSED){
            return "Position must be created or closed to open.";
        }
        status = PositionStatus.OPEN;
        return "Success!";
    }

    public String startRecruitment() {
        if (this.status != PositionStatus.OPEN) {
            return "Recruitment can only start from OPEN state.";
        }
        this.status = PositionStatus.IN_RECRUITMENT;
        return "Success";
    }

    public String closePosition() {
        if (this.status == PositionStatus.CLOSED) {
            return "Position is already closed.";
        }
        this.status = PositionStatus.CLOSED;
        LocalDateTime closedAt = LocalDateTime.now();
        return "Success!";
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
