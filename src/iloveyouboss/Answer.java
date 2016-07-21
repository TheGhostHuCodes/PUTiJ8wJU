package iloveyouboss;

public class Answer {
    private Question question;
    private Bool response;

    public Answer(Question question, Bool response) {
        this.question = question;
        this.response = response;
    }

    public String getQuestionText() { return question.getQuestion(); }

    public boolean match(Answer answer) {
        return answer.response == this.response;
    }
}
