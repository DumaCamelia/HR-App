package infrastructure;

import domain.interview.Interview;

public interface InterviewRepository {
    void save(Interview interview);
    Interview findById(Long id);
}
