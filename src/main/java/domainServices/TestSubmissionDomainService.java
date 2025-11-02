package domainServices;

import domain.evaluation.TestSubmission;
import domain.evaluation.TestQuestion;

import java.time.LocalDateTime;
import java.util.Map;

public class TestSubmissionDomainService {
    public boolean validateSubmittedAt(TestSubmission submission) {
        LocalDateTime submittedAt = submission.getSubmittedAt();
        if (submittedAt == null) {
            System.out.println("Submission date cannot be null!");
            return false;
        }
        if (submittedAt.isAfter(LocalDateTime.now())) {
            System.out.println("Submission date cannot be in the future!");
            return false;
        }
        return true;
    }

    public boolean validateAnswers(TestSubmission submission) {
        Map<TestQuestion, String> answers = submission.getAnswers();
        if (answers == null || answers.isEmpty()) {
            System.out.println("Answers cannot be empty!");
            return false;
        }

        for (Map.Entry<TestQuestion, String> entry : answers.entrySet()) {
            TestQuestion question = entry.getKey();
            String answer = entry.getValue();
            if (question == null || question.getText().trim().isEmpty()) {
                System.out.println("Question cannot be null in answers map!");
                return false;
            }
            if (answer == null || answer.trim().isEmpty()) {
                System.out.println("Answer for question ID " + question.getId() + " cannot be empty!");
                return false;
            }
        }
        return true;
    }

    public boolean validateTotalScore(TestSubmission submission) {
        int score = submission.getTotalScore();
        if (score < 0 || score > 100) {
            System.out.println("Total score must be between 0 and 100!");
            return false;
        }
        return true;
    }

    public boolean validateSubmission(TestSubmission submission, int totalQuestions) {
        return  validateSubmittedAt(submission)
                && validateAnswers(submission)
                && validateTotalScore(submission);
    }
}
