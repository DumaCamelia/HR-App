package domain.interview;

public interface InterviewRepository {
    void save(Interview interview);
    Interview findById(Long id);
}
