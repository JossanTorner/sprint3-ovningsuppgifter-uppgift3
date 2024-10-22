package ovningsuppgift3;

import java.util.ArrayList;
import java.util.List;

public class ChangeCalculator {

    public int calculateChangeAmount(int amount, int price){
        return amount - price;
    }

    public int getAmountOfValue(int change, int value){
        return change/value;
    }

    public int getRestOfChange(int change, int value){
        return change%value;
    }

    public List<Change> getChange(int changeAmount, List<Integer> askedFor){
        List<Change> getAll = new ArrayList<>();
        for (Value value : Value.values()) {
            if(askedFor.contains(value.value())){
                //här tas det ut hur många gånger tex en femhundring (value.value()) går i summan av växel vi ska ha tillbaka
                int a = getAmountOfValue(changeAmount, value.value());
                //om det inte är 0, då ska antalet läggas till i listan
                if (a != 0) {
                    getAll.add(new Change(value, a));
                }
                //sen räknas det ut resten
                changeAmount = getRestOfChange(changeAmount, value.value());
            }
        }
        return getAll;
    }

}
