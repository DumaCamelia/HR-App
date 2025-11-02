package infrastructure;

import domain.recruitment.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    boolean existsByTitle(String title);
}

