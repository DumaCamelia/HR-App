package domain.evaluation;

import domain.recruitment.Candidate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TestSubmission {
    private Candidate candidate;
    private Map<TestQuestion, String> answers = new HashMap<>();
    private int totalScore;
    private LocalDateTime submittedAt;

    public TestSubmission() {}

    public TestSubmission(Candidate candidate) {
        this.candidate = candidate;
        this.submittedAt = LocalDateTime.now();
    }

    public Candidate getCandidate() { return candidate; }
    public void setCandidate(Candidate candidate) { this.candidate = candidate; }

    public Map<TestQuestion, String> getAnswers() { return answers; }
    public void setAnswers(Map<TestQuestion, String> answers) { this.answers = answers; }

    public int getTotalScore() { return totalScore; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }

    public void addAnswer(TestQuestion question, String answer) {
        answers.put(question, answer);
    }

    public void evaluate() {
        totalScore = answers.entrySet().stream()
                .filter(e -> e.getKey().isCorrect(e.getValue()))
                .mapToInt(e -> e.getKey().getPoints())
                .sum();
    }

    public boolean isComplete(int totalQuestions) {
        return answers.size() == totalQuestions;
    }

}
