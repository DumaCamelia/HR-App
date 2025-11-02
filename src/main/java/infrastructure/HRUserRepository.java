package infrastructure;

import domain.recruitment.HRUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRUserRepository extends JpaRepository<HRUser, Integer> {
    static boolean existsByEmail(String email) {
        return false;
    }
}

