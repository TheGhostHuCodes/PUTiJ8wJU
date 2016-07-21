package iloveyouboss;

public enum Weight {
    DontCare(0),
    MustMatch(1);

    private int value;

    Weight(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
