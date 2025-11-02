package domain.evaluation;

import lombok.Data;

import java.util.Objects;

@Data
public class TestQuestion {
    private int id;
    private String text;
    private String correctAnswer;
    private int points;
    private String category;

    public TestQuestion(int id, String text, String correctAnswer, int points) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }
}