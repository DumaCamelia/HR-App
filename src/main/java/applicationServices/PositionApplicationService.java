package applicationServices;

import domain.recruitment.Position;
import domain.recruitment.PositionStatus;
import domainServices.PositionDomainService;
import infrastructure.PositionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PositionApplicationService {

    private final PositionDomainService positionDomainService;
    private final PositionRepository positionRepository;

    public PositionApplicationService(PositionDomainService positionDomainService,
                                      PositionRepository positionRepository) {
        this.positionDomainService = positionDomainService;
        this.positionRepository = positionRepository;
    }

    // Adaugă o poziție nouă
    public boolean addPosition(Position position) {
        if (!positionDomainService.validatePosition(position)) {
            return false;
        }

        // Dacă createdAt nu e setat, îl punem acum
        if (position.getCreatedAt() == null) {
            position.setCreatedAt(LocalDateTime.now());
        }

        positionRepository.save(position);
        return true;
    }

    // Închide o poziție (schimbă statusul)
    public boolean closePosition(Position position) {
        if (position.getStatus() == PositionStatus.CLOSED) {
            System.out.println("Position is already closed!");
            return false;
        }

        position.setStatus(PositionStatus.CLOSED);
        position.setClosedAt(LocalDateTime.now());
        positionRepository.save(position);
        return true;
    }

    // Deschide o poziție pentru recrutare
    public boolean openPosition(Position position) {
        if (position.getStatus() != PositionStatus.CREATED) {
            System.out.println("Only positions in CREATED status can be opened!");
            return false;
        }

        position.setStatus(PositionStatus.OPEN);
        positionRepository.save(position);
        return true;
    }

    // Schimbă statusul unei poziții în IN_RECRUITMENT
    public boolean startRecruitment(Position position) {
        if (position.getStatus() != PositionStatus.OPEN) {
            System.out.println("Only OPEN positions can start recruitment!");
            return false;
        }

        position.setStatus(PositionStatus.IN_RECRUITMENT);
        positionRepository.save(position);
        return true;
    }

    // Șterge o poziție (dacă e permis)
    public boolean deletePosition(Position position) {
        if (position.getStatus() == PositionStatus.IN_RECRUITMENT ||
                position.getStatus() == PositionStatus.CLOSED) {
            System.out.println("Cannot delete a position that is in recruitment or closed!");
            return false;
        }

        positionRepository.delete(position);
        return true;
    }

}
