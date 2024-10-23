package ovningsuppgift5;

public enum Symbol {

    STEN ("sten", 0),
    SAX ("sax", 1),
    PÅSE ("påse", 2);

    private String name;
    private int randomNumb;

    Symbol(String name, int randomNumb) {
        this.name = name;
        this.randomNumb = randomNumb;
    }

    public String getName(){
        return name;
    }
    public int getRandomNumb(){
        return randomNumb;
    }
}
