package infrastructure;

import domain.recruitment.Candidate;
import domain.recruitment.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {
    List<Candidate> findByStatus(CandidateStatus status);
    List<Candidate> findById(int id);
}
