package ovningsuppgift5;

public class GameUtil {

    public Symbol getRandomSymbol(){
        return Symbol.values()[getRandomNumber()];
    }

    public int getRandomNumber(){
        return (int) (Math.random() * 3);
    }

    public Symbol getUserSymbol(String symbol){

        if (symbol.trim().equalsIgnoreCase("sten")){
            return Symbol.STEN;
        }
        else if (symbol.trim().equalsIgnoreCase("sax")){
            return Symbol.SAX;
        }
        else if (symbol.trim().equalsIgnoreCase("påse")){
            return Symbol.PÅSE;
        }
        else{
            throw new IllegalArgumentException("Ogiltig symbol!");
        }
    }

    public Symbol getWinner(Symbol userSymbol, Symbol opponentSymbol) {

        if (userSymbol == opponentSymbol){
            return null;
        }

        return switch (userSymbol) {
            case STEN -> (opponentSymbol == Symbol.SAX) ? Symbol.STEN : Symbol.PÅSE;
            case SAX -> (opponentSymbol == Symbol.PÅSE) ? Symbol.SAX : Symbol.STEN;
            case PÅSE -> (opponentSymbol == Symbol.STEN) ? Symbol.PÅSE : Symbol.SAX;
        };
    }

}
