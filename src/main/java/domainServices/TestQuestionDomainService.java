package domainServices;

import domain.evaluation.TestQuestion;

public class TestQuestionDomainService {

    public boolean validateId(TestQuestion question) {
        if (question.getId() <= 0) {
            System.out.println("ID must be a positive integer!");
            return false;
        }
        return true;
    }

    public boolean validateText(TestQuestion question) {
        String text = question.getText();
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Question text cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validateCorrectAnswer(TestQuestion question) {
        String answer = question.getCorrectAnswer();
        if (answer == null || answer.trim().isEmpty()) {
            System.out.println("Correct answer cannot be empty!");
            return false;
        }
        return true;
    }

    public boolean validatePoints(TestQuestion question) {
        int points = question.getPoints();
        if (points <= 0) {
            System.out.println("Points must be positive!");
            return false;
        }
        return true;
    }

    public boolean validateCategory(TestQuestion question) {
        String category = question.getCategory();
        if (category != null && category.trim().isEmpty()) {
            System.out.println("Category cannot be empty if provided!");
            return false;
        }
        return true;
    }

    public boolean validateQuestion(TestQuestion question) {
        return validateId(question)
                && validateText(question)
                && validateCorrectAnswer(question)
                && validatePoints(question)
                && validateCategory(question);
    }

    public boolean checkAnswer(TestQuestion question, String value) {
        if (value == null) return false;
        return question.getCorrectAnswer().equals(value);
    }
}
