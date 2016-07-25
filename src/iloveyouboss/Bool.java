package iloveyouboss;

public enum Bool {
    FALSE(0),
    TRUE(1);

    private int value;

    Bool(int value) { this.value = value; }

    public int getValue() { return value; }
}
