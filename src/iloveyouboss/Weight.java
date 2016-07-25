package iloveyouboss;

public enum Weight {
    DontCare(0),
    Important(1),
    MustMatch(2);

    private int value;

    Weight(int value) { this.value = value; }

    public int getValue() { return value; }
}
