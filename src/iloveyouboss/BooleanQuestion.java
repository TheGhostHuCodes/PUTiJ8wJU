package iloveyouboss;

public class BooleanQuestion implements Question {
    private int i;
    private String question;

    public BooleanQuestion(int i, String question) {
        this.i = i;
        this.question = question;
    }

    public String getQuestion() { return question; }
}
