package iloveyouboss;

public class BooleanQuestion implements Question {
    private int id;
    private final String text;

    public BooleanQuestion(int id, String text) {
        this.id = id;
        this.text = text;
    }
    public BooleanQuestion(String text) { this.text = text; }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getText() {
        return text;
    }
}
