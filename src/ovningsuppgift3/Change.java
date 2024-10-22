package ovningsuppgift3;

public class Change {

    private Value value;
    private int amountOf;
    private String type;

    public Change(Value value, int amountOf) {
        setValue(value);
        setAmountOf(amountOf);
    }

    public boolean compare(Change change){
        return this.value == change.value && this.amountOf == change.amountOf;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
        if (value.value() >= 20){
            this.type = "lappar";
        }
        else{
            this.type = "kronor";
        }
    }

    public int getAmountOf() {
        return amountOf;
    }

    public void setAmountOf(int amountOf) {
        this.amountOf = amountOf;
    }

    public String getType() {
        return type;
    }


}
