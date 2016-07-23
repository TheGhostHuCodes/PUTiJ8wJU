package iloveyouboss;

public class BooleanAnswer {
    private final Integer questionId;
    private final boolean value;

    public BooleanAnswer(Integer questionId, boolean value) {
        this.questionId = questionId;
        this.value = value;
    }

    public Integer getQuestionId() { return questionId; }
    public boolean getValue() { return value; }
}
