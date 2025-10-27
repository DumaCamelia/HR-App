package domain.evaluation;

public class TestQuestion {
    private int id;
    private String text;
    private String correctAnswer;
    private int points;
    private String category;

    public TestQuestion() {}

    public TestQuestion(int id, String text, String correctAnswer, int points) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }


    public boolean isCorrect(String value) {
        if (correctAnswer == value){
            return true;
        }
        return false;
    }
}