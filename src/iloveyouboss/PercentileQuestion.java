package iloveyouboss;

public class PercentileQuestion implements Question {
    private int id;
    private String text;
    private String[] strings;

    public PercentileQuestion(int id, String text, String[] strings) {
        this.id = id;
        this.text = text;
        this.strings = strings;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getText() {
        return text;
    }
}
