package iloveyouboss;

public class Answer {
    private final Question question;
    private Bool response;
    private int percentage;

    public Answer(Question question, Bool response) {
        this.question = question;
        this.response = response;
    }

    public Answer(Question question, int percentage) {
        this.question = question;
        this.percentage = percentage;
    }

    public String getQuestionText() { return question.getText(); }

    public boolean match(Answer answer) {
        return answer.response == this.response;
    }

    public Question getQuestion() { return question; }
}
