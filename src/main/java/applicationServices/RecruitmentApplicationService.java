package applicationServices;

public class RecruitmentApplicationService {
    void createNewPosition(PositionDTO dto);
    void startRecruitmentProcess(Long positionId);
    void closePosition(Long positionId);
}
