package ovningsuppgift3;

public enum Value {
    TUSEN(1000),
    FEMHUNDRA (500),
    TVÅHUNDRA (200),
    HUNDRA (100),
    FEMTIO (50),
    TJUGO (20),
    TIO (10),
    FEM (5),
    TVÅ (2),
    EN (1);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}