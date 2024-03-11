import java.util.HashMap;

public class Card{
    String[] valueMap = new String[14];
    String[] colorMap = new  String[4];

    int value = -1, 
        color = -1;

    public Card(int val, int col){
        value = val;
        color = col;
        fillMaps();
    }

    void fillMaps(){
        for(int i = 2; i <= 10; ++i){
            valueMap[i] = String.valueOf(i);
        }
        valueMap[1] = "as";
        valueMap[11] = "walet";
        valueMap[12] = "dama";
        valueMap[13] = "król";

        //String[] colorMap = {"kier", "karo", "trefl", "pik"};
        colorMap[0] = "kier";
        colorMap[1] = "karo";
        colorMap[2] = "trefl";
        colorMap[3] = "pik";

    }

    public int getValue(){return value;}
    public int getColor(){return color;}

    public boolean equals(Card card){return value == card.getValue() && color == card.getColor();}

    public String toString(){
        if(value== -1 || color == -1){
            //System.out.printf("wartosc lub kolor jest rowna -1: %d:%d\n", value, color);
            return "";
        }
        return String.format("%10s %10s\n", valueMap[value], colorMap[color]); 
        //jesli wypisze tu "null null" to pewnie uzylo konstruktora bez argumentow, czyli mamy do czynienia z pusta karta
    }

    public boolean valueIs(String s){return valueMap[value].equals(s);}
    public boolean colorIs(String s){return colorMap[color].equals(s);}
}
